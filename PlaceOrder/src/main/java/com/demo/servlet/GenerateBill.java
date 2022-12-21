package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.Product;


@WebServlet("/generatebill")
public class GenerateBill extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//generate same session here
		HttpSession session=req.getSession();
		//store session object data into arraylist
		List<Product> list=(List<Product>) session.getAttribute("cart");
		System.out.println("In g bill ");
		for(Product a:list) {
			System.out.println(a);
		}
		
		
		if(list!=null) {
			double Amount=0;
			out.println("<form action='finalizeorder'>");
			out.println("<table border='2'<tr><th>Id</th><th>Name</th><th>Price</th></tr");
			for(Product p:list) {
				out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPrice()+"</td></tr>");
				Amount=Amount+p.getPrice();
			}
			out.println("<tr><td colspan='2'>Total Bill</td><td>"+Amount+"</td></tr>");
			out.println("</table>");
			out.println("<button type='submit' name='btn' id='btn'>Make Payment</button>");
			out.println("</form>");
		}
		
		
	}

}
