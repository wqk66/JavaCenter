package com.javaweb.exportexcel;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExpEexcelServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		OutputStream output = response.getOutputStream();
		CreateExcel ce = new CreateExcel();
		try{
			int count = ce.createExcel(wb, request, response);
			if(count==0){
				response.setContentType("application/vnd.ms-excel charset=GBK");
            	response.setHeader("Content-Disposition","attachment;filename= page-new.xls");
            	wb.write(output);
			}
		}catch (Exception e) {
			
		}
	}

}
