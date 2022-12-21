package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String username=req.getParameter("un");
		String password=req.getParameter("pw");
		LoginService ls=new LoginServiceImpl();
		User u=ls.validateUser(username,password);
		if(u!=null) {
			if(u.getRole().equals("admin")) {
				RequestDispatcher rd=req.getRequestDispatcher("admin");
//				out.println("Admin Logged In");
				
				
				rd.forward(req,res);
				}
			else {
				RequestDispatcher rd=req.getRequestDispatcher("users");
				rd.forward(req,res);
			}
		}
		else {
			out.println("Invalid User!!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
			rd.include(req, res);
		}
	}

}
