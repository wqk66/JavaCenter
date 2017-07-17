package com.javaweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {

	
	public ServletDemo() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		//设置编码格式
		request.setCharacterEncoding("gb2312");
		//获得username参数
		String username = request.getParameter("username");
		//获得password 参数
		String password = request.getParameter("password");
		out.println("<html>");
		out.println("<body>");
		out.println("用户名："+username+"<br>");
		out.println("密码："+password+"<br>");
		out.println("</body>");
		out.println("</html>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
	}

}
