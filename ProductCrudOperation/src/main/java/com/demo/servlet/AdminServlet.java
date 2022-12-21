package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
//		res.setContentType("text/html");
//		PrintWriter out=res.getWriter();
//		out.println("in Admin Servlet");
		
		RequestDispatcher rd=req.getRequestDispatcher("displayAll");
		rd.forward(req,res);
	}

}
