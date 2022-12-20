package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/edit")
public class EditProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ProductService ps=new ProductServiceImpl();
		Product p=ps.getById(id);
		
		out.println ("<form action='update' method='post'>") ;
		out.println("Product id : <input type='text' name='pid' id='pid' value='"+p.getPid()+"'readonly><br>");
		out.println("Pruct Name :<input type='text' name='pname' id='pname' value='"+p.getPname()+"'<br>");
		out.println("Product Qty :<input type='text'name='qty' id='qty' value='"+p.getQty()+"'<br> ");
		out.println("Product Price : <input type='text' name='price' id='price' value='"+p.getPrice()+"'<br>");
		out.println("Product Cid : <input type='text' name='cid' id='cid' value='"+p.getCid()+"'<br>");
		
		
		out.println("<button type='submit' name='btn' id='btn' value='update'>Update Product</button>");
		out.print("</form>");
		
		
	}

}
