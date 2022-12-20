package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/displayAll")
public class DisplayAllProduct extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ProductService ps=new ProductServiceImpl();
		List<Product> plist=ps.displayAllProduct();
		out.println("<a href='addproduct'>Add Product</a>");
		
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>Qty</th><th>Price</th><th>Cid</th><th>Operations</th></tr>");
		

		for(Product p:plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='deleteProduct?id="+p.getPid()+"'>delete</a> / <a href='edit?id="+p.getPid()+"'>edit</a></td></tr>");
																					

		}
		out.println("</table>");


	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		doGet(req,res);
	}

}
