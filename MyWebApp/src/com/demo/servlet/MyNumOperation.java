package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyNumOperation extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		System.out.println("Query String : "+req.getQueryString());
		int num1=Integer.parseInt(req.getParameter("num1"));
		int num2=Integer.parseInt(req.getParameter("num2"));
		String btn=req.getParameter("btn");
		switch(btn) {
		case "Add":
			int result=num1+num2;
			out.println("<h1>Addition :"+result+ "</h1>");
			break;
		case "Sub":
			result=num1-num2;
			out.println("<h1>Subtraction : "+result+"</h1>");
			break;
		case "Mult":
			result=num1*num2;
			out.println("<h1>Multiplication : "+result+"</h1>");
			break;
		}
	}

}
