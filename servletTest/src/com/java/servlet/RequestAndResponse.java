package com.java.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAndResponse
 */
@WebServlet("/RequestAndResponse")
public class RequestAndResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestAndResponse() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setIntHeader("Refresh", 3);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		System.out.println("getRequestURL"+request.getRequestURL());
//		System.out.println("getRequestURI"+request.getRequestURI());
//		System.out.println("getQueryString"+request.getQueryString());
//		System.out.println("getRemoteAddr"+request.getRemoteAddr());
//		System.out.println("getRemoteHost:"+request.getRemoteHost());
//		System.out.println("getRemotePort:"+request.getRemotePort());
//		System.out.println("getRemoteUser:"+request.getRemoteUser());
//		System.out.println("getLocalAddr:"+request.getLocalAddr());
//		System.out.println("getLocalName:"+request.getLocalName());
//		System.out.println("getLocalPort:"+request.getLocalPort());
//		System.out.println("getMethod:"+request.getMethod());
//		System.out.println("-----request.getParameterMap()-----");
//		Map<String, String[]> map = request.getParameterMap();
//		
//		for(Map.Entry<String, String[]>  entry : map.entrySet()){
//			String key = entry.getKey();
//			String[] values = entry.getValue();
//			for(String value :values){
//				System.out.println(key+"="+value);
//			}
//		}
//		System.out.println("------request.getHeader----");
//		Enumeration<String> em = request.getHeaderNames();
//		while(em.hasMoreElements()){
//			String name = em.nextElement();
//			String value = request.getHeader(name);
//			System.out.println(name+"--"+value);
//		}
//		response.sendRedirect("message.jsp");
		
		System.out.println(response.getBufferSize());
		response.setBufferSize(1024);
		System.out.println(response.getBufferSize());
		int len = response.getBufferSize();
		for(int i=0;i<len;i++){
			System.out.println("w");
		}
	}

}
