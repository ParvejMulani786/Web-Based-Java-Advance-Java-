package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/findprod")
public class ProductDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		String btn = request.getParameter("btn");
		if(btn.equals("find"))
		{
			int catid= Integer.parseInt(request.getParameter("catid"));
			ProductService ps = new ProductServiceImpl();
			List<Product>list=ps.getByCatID(catid);
			System.out.println("In prod detail ");
			for(Product a:list) {
				System.out.println(a);
			}
			out.println("<form action ='generatecart' method='get'>");
			int cnt =1;
			for(Product p:list)
			{
				String str = p.getPid()+":"+p.getPname()+":"+p.getPrice();
				
				out.println("<input type='checkbox' name='prod' id='p"+cnt+"' value='"+str+"'><label for='p"+cnt+"'>"+p.getPname()+"---"+p.getPrice()+"<lable><br>");
				System.out.println("str list "+str);
				cnt++;
				
			}
			out.println("<button type='submit' name ='btn' id='btn'>Add to Cart</button>");
			out.println("</form>");
			
		}
		else if(btn.equals("payment"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("generatebill");
			rd.forward(request, response);
		}

	}



}
