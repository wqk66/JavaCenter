package com.windfarm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.windfarm.service.WindService;
import com.windfarm.util.DBManager;

public class Test {
	public static void main(String[] args) throws ParseException, IOException {

		// ≤Â»Î ˝æ›
//		excelInsertData();

		// WindService.calculatedValueInsertTable(64001);
		
		
		InputStream in = null;
		try {
			in = new FileInputStream(new File(""));
			
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(in);
		    	xssfWorkbook.getSheetAt(0);
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			in.close();
		}

	}

	public static void excelInsertData() {
		String sql = "insert into data_powerfarm_realpower (farmid,ymd,T0000,T0015,T0030,T0045,T0100,T0115,T0130,T0145,T0200,T0215,T0230,"
				+ " T0245,T0300,T0315,T0330,T0345,T0400,T0415,T0430,T0445,T0500,T0515,T0530,T0545,T0600,T0615,T0630,"
				+ " T0645,T0700,T0715,T0730,T0745,T0800,T0815,T0830,T0845,T0900,T0915,T0930,T0945,T1000,T1015,T1030,"
				+ " T1045,T1100,T1115,T1130,T1145,T1200,T1215,T1230,T1245,T1300,T1315,T1330,T1345,T1400,T1415,T1430,"
				+ " T1445,T1500,T1515,T1530,T1545,T1600,T1615,T1630,T1645,T1700,T1715,T1730,T1745,T1800,T1815,T1830,"
				+ " T1845,T1900,T1915,T1930,T1945,T2000,T2015,T2030,T2045,T2100,T2115,T2130,T2145,T2200,T2215,T2230,"
				+ " T2245,T2300,T2315,T2330,T2345,T2400) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		DBManager dbManager = new DBManager();
		Map<String, List<String>> hashMap = WindService.getAllDataByExcel("E:\\book7.xlsx");
		dbManager.insertData(sql, 64001, hashMap);
	}
}
