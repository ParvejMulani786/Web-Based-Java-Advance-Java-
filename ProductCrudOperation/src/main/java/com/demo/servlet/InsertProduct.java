package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/insertproduct")
public class InsertProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int pid = Integer.parseInt(req.getParameter("pid"));
    	String name = req.getParameter("pname");
    	int qty = Integer.parseInt(req.getParameter("qty"));
    	double price = Double.parseDouble(req.getParameter("price"));
    	int cid = Integer.parseInt(req.getParameter("cid"));
    	ProductService ps = new ProductServiceImpl();
    	ps.insertproduct(new Product(pid,name,qty,price,cid));
    	RequestDispatcher rd=req.getRequestDispatcher("displayAll");
    	rd.forward(req,res);
    
	}

}
