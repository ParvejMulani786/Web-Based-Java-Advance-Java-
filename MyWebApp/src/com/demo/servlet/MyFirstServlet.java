package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("In Init method");
		}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		//set response text into html
		res.setContentType("text/html");
		//print content in webpage using writer from java.io package 
		PrintWriter out=res.getWriter();
		out.println("<h1>Welcome to my first Servlet!!</h1>");
		
	}
	
	public void destroy() {
		System.out.println("in destroy method");
	}
}
