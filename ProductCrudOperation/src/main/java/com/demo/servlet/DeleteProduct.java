package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/deleteProduct")
public class DeleteProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		res.setContentType("text/html");
//		PrintWriter out=res.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		ProductService ps=new ProductServiceImpl();
		ps.deleteById(id);
		RequestDispatcher rd=req.getRequestDispatcher("displayAll");
		rd.forward(req, res);
		
		
	}

}
