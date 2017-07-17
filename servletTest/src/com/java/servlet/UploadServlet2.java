package com.java.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadServlet2
 */
@WebServlet("/UploadServlet2")
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	

	/**
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger logger = Logger.getLogger("UploadServlet2");
		LogRecord record = null;
		request.setCharacterEncoding("UTF-8");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileOutputStream out  = null;
		InputStream fs  = null;
		if(isMultipart){
			try {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				String filePath = "G:\\uploadtmep";
				File file = new File(filePath);
				if(!file.exists()){
					file.mkdir();
				}
				factory.setRepository(file);
				factory.setSizeThreshold(5*1024*1024);
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(20*1024*1024);
				
				List<FileItem> items = upload.parseRequest(request);
				for(FileItem item : items){
					if(item.isFormField()){
						
						String name = item.getFieldName();
						String content = item.getString();
						record = new LogRecord(Level.INFO, "属性名称："+name+",属性值:"+content);
						logger.log(record);
					}else{
						String fieldName = item.getFieldName();
						String fileName = item.getName();
						String contentType = item.getContentType();
						String content = item.getString("UTF-8");
						fs = item.getInputStream();
						boolean isInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						byte[] buffer = new byte[1024];
						record = new LogRecord(Level.INFO, "�?������ƣ�"+fieldName+",�ļ���"+fileName
								+ ",�������ͣ�"+contentType + ",�Ƿ� ʹ���ڴ棺"+isInMemory+"����С��"+sizeInBytes);
						String fp = filePath
								+ File.separator;
						out = new FileOutputStream(fp+fileName);
						int len = 0;
						while((len=fs.read(buffer))>0){
							out.write(buffer, 0, len);
						}
						item.delete();
					}
					
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				fs.close();
				out.close();
				
			}
		}else{
			System.out.println("��ͨ�?");
		}
	}

}
