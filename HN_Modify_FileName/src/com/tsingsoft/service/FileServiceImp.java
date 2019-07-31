package com.tsingsoft.service;

import com.tsingsoft.util.DateUtil;
import com.tsingsoft.util.PropertyUtil;

import java.io.*;
import java.util.Map;

public class FileServiceImp {

	private Map<String, String> fileNameMap = null;

	public FileServiceImp() {

	}

	/**
	 * 文件操作方法：将文件从一个目录复制到另一个目录，并修改文件的名称
	 */
	public void handleFile() {
		PropertyUtil proper = new PropertyUtil("config");
		String name = proper.getValue("shortName");// 资源文件中的shortName
		String[] shortNames = name.split(";");
		String currDate = DateUtil.getCurrDate("yyyyMMdd");// 当前日期
		for (String shortName : shortNames) {
			String oriDir = proper.getValue("oriPath") + File.separator
			        + shortName + File.separator + "upload" + File.separator
			        + currDate;
			String destDir = proper.getValue("destPath") + File.separator
			        + shortName + File.separator + "upload" + File.separator
			        + currDate;
			if (copyDir(oriDir, destDir)) {
				File file = new File(destDir);
				File[] files = file.listFiles();
				for (File f : files) {
					System.out.println("文件名称：" + f.getName());
					String[] fileNames = f.getName().split("_");
					String fileName = "hn." + shortName + "_" + fileNames[1]
					        + "_" + fileNames[2];
					modifyFileName(new File(destDir + File.separator
					        + f.getName()), new File(destDir + File.separator
					        + fileName));

				}
			}
		}

	}

	/**
	 * 复制文件夹
	 * 
	 * @param oriDir
	 * @param destDir
	 * @return
	 */
	public boolean copyDir(String oriDir, String destDir) {

		File file = new File(oriDir);
		String[] filePath = file.list();

		if (!(new File(destDir)).exists()) {
			(new File(destDir)).mkdirs();
		}

		if (filePath == null) {
			return false;
		}
		System.out.println("filepath的大小：" + filePath.length);
		for (int i = 0; i < filePath.length; i++) {
			if ((new File(oriDir + file.separator + filePath[i])).isDirectory()) {
				return copyDir(oriDir + file.separator + filePath[i], destDir
				        + file.separator + filePath[i]);
			}
			File f = new File(oriDir + file.separator + filePath[i]);
			if (f.isFile()) {
				String[] fileNames = f.getName().split("_");
				String fileName = fileNames[1] + "_" + fileNames[2];
				System.out.println("fileName:" + fileName);
				if (!isExist(destDir, fileName)) {
					copyFiles(oriDir + file.separator + filePath[i], destDir
					        + file.separator + filePath[i]);
				}
			}
		}

		return true;
	}

	/**
	 * 复制文件
	 * 
	 * @param oriFilePath
	 * @param destFilePath
	 * @return
	 */
	public boolean copyFiles(String oriFilePath, String destFilePath) {

		File oldFile = new File(oriFilePath);
		File file = new File(destFilePath);
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream(oldFile);
			out = new FileOutputStream(file);
			byte[] buffer = new byte[2097152];
			int readByte = 0;
			while ((readByte = in.read(buffer)) != -1) {
				out.write(buffer, 0, readByte);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}

			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	/**
	 * 修改文件操作方法
	 */
	public void handleModifyFileName() {

		PropertyUtil proper = new PropertyUtil("config");
		String name = proper.getValue("shortName");// 资源文件中的shortName
		String[] shortNames = name.split(";");
		String currDate = DateUtil.getCurrDate("yyyyMMdd");// 当前日期
		String time = DateUtil.DateToString(DateUtil.getLastPointTime(15))
		        .substring(8, 12);
		System.out.println("begin modify filename："
		        + DateUtil.getCurrDate("yyyyMMdd HH:mm:ss"));
		for (String shortName : shortNames) {
			String destDir = proper.getValue("destPath") + File.separator
			        + shortName + File.separator + "upload" + File.separator
			        + currDate;
			File file = new File(destDir);
			File[] files = file.listFiles();

			if (files != null) {
				for (File f : files) {
					if (f.getName().contains("4Cwind_" + currDate + time)
					        || f.getName().contains("24Bwind")
					        || f.getName().contains("72nwp")
					        || f.getName().contains("72wind")) {
						String[] fileNames = f.getName().split("_");
						String fileName = "hn." + shortName + "_"
						        + fileNames[1] + "_" + fileNames[2];
						boolean isSuccess;
                        isSuccess = modifyFileName(new File(destDir
                                + File.separator +f.getName()), new File(
                                destDir + File.separator + fileName));
                        System.out.println(f.getName()
                                + "  to  "
                                + fileName
                                + (isSuccess == true ? "  modified success!"
                                        : " modified failure!"));
					}
				}
			}
		}
		System.out.println("end modify filename："
		        + DateUtil.getCurrDate("yyyyMMdd HH:mm:ss"));
	}

	/**
	 * 修改文件名称
	 * 
	 * @param oldFilePath
	 *            源文件
	 * @param newFilePath
	 *            修改后的文件
	 * @return
	 */
	public boolean modifyFileName(String oldFilePath, String newFilePath) {

		File oldFile = new File(oldFilePath);
		File newFile = new File(newFilePath);
		return modifyFileName(oldFile, newFile);
	}

	/**
	 * 修改文件名称
	 * 
	 * @param oldFile
	 *            源文件
	 * @param newFile
	 *            修改后的文件
	 * @return
	 */
	public boolean modifyFileName(File oldFile, File newFile) {
		return oldFile.renameTo(newFile);
	}

	public boolean isExist(String fileDir, String fileName) {
		File file = new File(fileDir);
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.getName().contains(fileName)) {
				return true;
			}
		}
		return false;
	}
}
