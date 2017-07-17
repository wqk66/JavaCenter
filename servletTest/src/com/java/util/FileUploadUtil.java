package com.java.util;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadUtil {

	//上传文件储存目录
	private static final String UPLOAD_DIRECTORY="upload";
	//上传配置
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
	/**
	 * @param request
	 * @param respon
	 * @return
	 */
	public static boolean isFileUPload(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		//配置参数
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//内存临界值--超过后将产生临时文件存储在磁盘中
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		//设置临时目录
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		//设置最大文件上传值
		upload.setFileSizeMax(MAX_FILE_SIZE);
		//设置最大请求值
		upload.setSizeMax(MAX_REQUEST_SIZE);
		//中文处理
		upload.setHeaderEncoding("UTF-8"); 
		String uploadPath = request.getServletContext().getRealPath("/WebContent/upload");
		System.out.println("uploadpath:"+uploadPath);
		//如何目录不存在则创建
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()){
			uploadDir.mkdir();
		}
		try {
			
			//解析请求内容提取文件数据
			List<FileItem> formItems = upload.parseRequest(request);
			if(formItems != null && formItems.size()>0){
				
				String name = formItems.get(0).getName();
				String fieldName=  formItems.get(0).getFieldName();
				System.out.println("name:"+name);
				System.out.println("fieldName:"+fieldName);
				for(FileItem item:formItems){
					if(!item.isFormField()){
						String fileName = item.getName();
						String filePath = uploadPath+File.separator+fileName;
						File storFile = new File(filePath);
						System.out.println("filepath:"+filePath);
						item.write(storFile);
						request.setAttribute("msg", "上传成功");
					}
				}
			}
		} catch (Exception e) {
			request.setAttribute("message",
                    "错误信息: " + e.getMessage());
		}
		return true;
	}
	 
}
