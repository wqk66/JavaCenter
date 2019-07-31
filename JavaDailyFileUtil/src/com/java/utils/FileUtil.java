/*
 * Copyright (c) 2005-2014 Beijing TsingSoft Technology Co.,Ltd.
 * All rights reserved.
 * Created on 2019-7-30
 *
 * JavaDailyFileUtil
 * com.java.utils
 * FileUtil.java
 */
package com.java.utils;

import java.io.File;


/**
 * 描述：公用的文件操作工具
 * @author 
 * @since 2019-7-30 上午10:48:53
 * @version   
 */
public class FileUtil {

	/**
	 * 
	 * 功能：判断zip文件是否存在，存在返回true，不存在返回false
	 * 作者：wqk
	 * 日期：2019-7-30 上午10:53:12 
	 * @param fileName
	 * @return
	 */
	public static boolean checkZipFileName(File zipFile){
		
		// 判断是否存在文件
		if (!zipFile.exists()) {
			return false;
		}
		// 判断是否是zip文件
		int index = zipFile.getName().lastIndexOf(".");
		String suffix = zipFile.getName().substring(index + 1);
		if (!"zip".equalsIgnoreCase(suffix)) {
			return false;
		}
		return true;
	}
}
