package com.javaweb.exportexcel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
public class CreateExcel {
	public int createExcel(HSSFWorkbook wb,HttpServletRequest request,HttpServletResponse response){
		//设置表头样式
		HSSFCellStyle styleField = wb.createCellStyle();
		HSSFFont fontField = wb.createFont();//设置字体
		fontField.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗
		styleField.setFont(fontField);
		styleField.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左右居中
		styleField.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上下居中
		styleField.setFillBackgroundColor(HSSFColor.BLUE.index);
		styleField.setFillForegroundColor(HSSFColor.RED.index);
		styleField.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		
		//设定字符
		HSSFCellStyle styleChar = wb.createCellStyle();
		styleChar.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleChar.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		styleChar.setFillForegroundColor(HSSFColor.GREEN.index);//设置背景色
		styleChar.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);//设置背景色的样式
		
		//设定数字
		HSSFCellStyle styleNum = wb.createCellStyle();
		styleNum.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleNum.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		//获得sheet
		HSSFSheet sheet = wb.createSheet();
		//设置表名
		HSSFRow rowT = sheet.createRow(0);
		HSSFCell cellT = rowT.createCell((short)0);
		rowT.setHeight((short)400);
		sheet.addMergedRegion(new Region(0, (short)0, 0, (short)4));
		cellT.setEncoding(HSSFCell.ENCODING_UTF_16);
		cellT.setCellValue("个人信息");
		cellT.setCellStyle(styleField);
		HSSFRow rowTT = sheet.createRow(1);
		HSSFCell cellTT = rowTT.createCell((short)0);
		rowTT.setHeight((short)400);
		sheet.addMergedRegion(new Region(1, (short)0, 1, (short)4));
		cellTT.setEncoding(HSSFCell.ENCODING_UTF_16);
		cellTT.setCellValue("不知道");
		cellTT.setCellStyle(styleChar);
		//设置列宽
		sheet.setColumnWidth((short)0,(short)1000);
		sheet.setColumnWidth((short)1,(short)2000 );
		sheet.setColumnWidth((short)2,(short)3000 );
		sheet.setColumnWidth((short)3,(short)4000 );
		sheet.setColumnWidth((short)4,(short)4000 );
		//设置表头
		HSSFRow row = sheet.createRow(2);
		HSSFCell cell0 = row.createCell((short)0);
		cell0.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell0.setCellValue("序号");
		cell0.setCellStyle(styleField);
		HSSFCell cell1 = row.createCell((short)1);
		cell1.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell1.setCellValue("姓名");
		cell1.setCellStyle(styleField);
		HSSFCell cell2 = row.createCell((short)2);
		cell2.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell2.setCellValue("年龄");
		cell2.setCellStyle(styleField);
		HSSFCell cell3 = row.createCell((short)3);
		cell3.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell3.setCellValue("职业");
		cell3.setCellStyle(styleField);
		HSSFCell cell4 = row.createCell((short)4);
		cell4.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell4.setCellValue("住址");
		cell4.setCellStyle(styleField);
		HSSFRow rowj = sheet.createRow(3);
		
		HSSFCell cellj0 = rowj.createCell((short)0);
		cellj0.setCellValue("--");
		cellj0.setCellStyle(styleField);
		HSSFCell cellj1 = rowj.createCell((short)1);
		cellj1.setCellValue("--");
		HSSFCell cellj2 = rowj.createCell((short)2);
		cellj2.setCellValue("--");
		HSSFCell cellj3 = rowj.createCell((short)3);
		cellj3.setCellValue("--");
		HSSFCell cellj4 = rowj.createCell((short)4);
		cellj4.setCellValue("--");
		for(int i=0;i<5;i++){
			HSSFRow rowData = sheet.createRow((short)i+4);
			HSSFCell cellData0 = rowData.createCell((short)0);
			cellData0.setCellValue(i+1);
			cellData0.setCellStyle(styleChar);
			HSSFCell cellData1 = rowData.createCell((short)1);
			cellData1.setEncoding(HSSFCell.ENCODING_UTF_16);
			cellData1.setCellValue("aa"+i);
			cellData1.setCellStyle(styleField);
			HSSFCell cellData2 = rowData.createCell((short)2);
			cellData2.setEncoding(HSSFCell.ENCODING_UTF_16);
			cellData2.setCellValue(String.valueOf(20+i));
			cellData2.setCellStyle(styleChar);
			HSSFCell cellData3 = rowData.createCell((short)3);
			cellData3.setEncoding(HSSFCell.ENCODING_UTF_16);
			cellData3.setCellValue("aa"+i);
			cellData3.setCellStyle(styleChar);
			HSSFCell cellData4 = rowData.createCell((short)4);
			cellData4.setEncoding(HSSFCell.ENCODING_UTF_16);
			cellData4.setCellValue("aa"+i);
			cellData4.setCellStyle(styleChar);
		}
		return 0;
	}
}
