package com.java.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet2
 */
@WebServlet("/DownloadServlet2")
public class DownloadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName = request.getParameter("file");
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment;filename=test.txt");
		String filePath = "G:\\uploadtmep"+File.separator+fileName;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(filePath));
		BufferedOutputStream os = new BufferedOutputStream(response.getOutputStream());
		byte[] buf = new byte[1024];
		int len = 0;
		while((len=in.read(buf))!=-1){
			os.write(buf, 0, len);
		}
		in.close();
		os.close();
	}

}
