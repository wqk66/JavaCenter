/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2019-7-30
 * 
 * JavaDailyFileUtil
 * com.java.utils
 * ZipUtils.java
 */
package com.java.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import com.java.utils.DateUtil;
import com.java.utils.FileUtil;
import com.java.utils.PropertyUtil;

/**
 * 
 * @author
 * @since 2019-7-30 上午10:21:16
 * @version
 */
public class ZipUtil {

	private static final int BUFFER_SIZE = 2 * 1024;

	/**
	 * 
	 * 功能：压缩成zip文件
	 * 作者：wqk
	 * 日期：2019-7-30 上午10:36:27
	 * 
	 * @param srcDir
	 *            压缩文件夹路径
	 * @param out
	 *            压缩文件输出流
	 * @param KeepDirStructure
	 *            是否保留原来的目录结构,true:保留目录结构;
	 *            false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws RuntimeException
	 *             压缩失败会抛出运行时异常
	 */

	public static void toZip(String srcDir,boolean KeepDirStructure) throws Exception {
		long start = System.currentTimeMillis();
		File dirFile = new File(srcDir);
		OutputStream out = new FileOutputStream(dirFile.getParent()+File.separator+dirFile.getName()+".zip");
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(out);
			File sourceFile = new File(srcDir);
			compress(sourceFile, zos, sourceFile.getName(), KeepDirStructure);
			long end = System.currentTimeMillis();
			System.out.println("压缩完成，耗时：" + (end - start) + " ms");
		}
		catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils", e);
		}
		finally {
			if (zos != null) {
				try {
					zos.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * 功能：递归压缩方法
	 * 作者：wqk
	 * 日期：2019-7-30 上午10:35:08
	 * 
	 * @param sourceFile
	 *            源文件
	 * @param zos
	 *            zip输出流
	 * @param name
	 *            压缩后的名称
	 * @param KeepDirStructure
	 *            是否保留原来的目录结构,true:保留目录结构;
	 *            false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws Exception
	 */
	private static void compress(File sourceFile, ZipOutputStream zos,
	        String name, boolean KeepDirStructure) throws Exception {
		byte[] buf = new byte[BUFFER_SIZE];
		if (sourceFile.isFile()) {
			// 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
			zos.putNextEntry(new ZipEntry(name));
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1) {
				zos.write(buf, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
		}
		else {
			File[] listFiles = sourceFile.listFiles();
			if (listFiles == null || listFiles.length == 0) {
				// 需要保留原来的文件结构时,需要对空文件夹进行处理
				if (KeepDirStructure) {
					// 空文件夹的处理
					zos.putNextEntry(new ZipEntry(name + "/"));
					// 没有文件，不需要文件的copy
					zos.closeEntry();
				}
			}
			else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构
					if (KeepDirStructure) {
						// 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
						// 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
						compress(file, zos, name + "/" + file.getName(),
						        KeepDirStructure);
					}
					else {
						compress(file, zos, file.getName(), KeepDirStructure);
					}
				}
			}
		}
	}

	/**
	 * 
	 * 功能：解压缩zip文件
	 * 作者：wqk
	 * 日期：2019-7-30 下午01:24:26 
	 * @param srcFile 源文件
	 * @param destDir 解压到目标文件夹
	 * @throws Exception 
	 * @throws Exception
	 */
	public static void unzip(String srcFile, String destDir) throws Exception {
		long startTime = System.currentTimeMillis();
		boolean isExist = FileUtil.checkZipFileName(new File(srcFile));
		if (!isExist) {
			throw new RuntimeException(srcFile + "所指文件不存在");
		}
		ZipFile zipFile = null;
        try {
	        zipFile = new ZipFile(srcFile);
	        Enumeration<?> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				System.out.println("解压" + entry.getName());
				if (entry.isDirectory()) {
					String dirPath = destDir + "/" + entry.getName();
					File dir = new File(dirPath);
					dir.mkdirs();
				}
				else {
					// 如果是文件，就先创建一个文件，然后用io流把内容copy过去
					File targetFile = new File(destDir + "/" + entry.getName());
					// 保证这个文件的父文件夹必须要存在
					if (!targetFile.getParentFile().exists()) {
						targetFile.getParentFile().mkdirs();
					}
					targetFile.createNewFile();
					// 将压缩文件内容写入到这个文件中
					InputStream is = zipFile.getInputStream(entry);
					FileOutputStream fos = new FileOutputStream(targetFile);
					int len;
					byte[] buf = new byte[BUFFER_SIZE];
					while ((len = is.read(buf)) != -1) {
						fos.write(buf, 0, len);
					}
					// 关流顺序，先打开的后关闭
					fos.close();
					is.close();
				}
			}
        }
        catch (IOException e) {
        }finally{
        	if(zipFile != null){
    			zipFile.close();
    		}
        }
		long endTime = System.currentTimeMillis();
		System.out.println("解压完成！所需时间为：" + (endTime - startTime) + "ms");
	}

	public static void main(String[] args) throws Exception {

		/** 测试压缩方法1 */
		PropertyUtil proper = new PropertyUtil("config");
		String currDate = DateUtil.getCurrDate("yyyyMMdd");
		
		String toZipFile = proper.getValue("toZipDir")+File.separator + currDate;
		ZipUtil.toZip(toZipFile, true);
		
		
		String unZipFile = proper.getValue("srcFile")+File.separator + currDate+".zip";
		String destDir = proper.getValue("destDir");
		ZipUtil.unzip(unZipFile,destDir);
	}
}
