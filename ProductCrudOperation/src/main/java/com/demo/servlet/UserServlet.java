package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class UserServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException  {
//		res.setContentType("text/html");
//		PrintWriter out=res.getWriter();
//		out.println("In UserServlet");
		
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		ProductService ps=new ProductServiceImpl();
		List<Product> plist=ps.displayAllProduct();
		//out.println("<a href='addproduct'>Add Product</a>");
		
		out.println("<a href='Login.html'><button>LogOut</button></a>");
		out.println("<center>");
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>Qty</th><th>Price</th><th>Cid</th></tr>");
		

		for(Product p:plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getCid()+"</td>");
			out.println("</tr>");
																					

		}
		out.println("</table>");
		out.println("</center>");

				
		
	}

}
