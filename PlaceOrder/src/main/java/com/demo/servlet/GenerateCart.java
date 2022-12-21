package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.Product;

@WebServlet("/generatecart")
public class GenerateCart extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		//values received from calling servlet is string str (1:shirt:500.0),
		//it conatains multiple values (hence use "getParameterValues") and store it in Sting array
		String []arr=req.getParameterValues("prod");


		Stream.of(arr).forEach(x->{System.out.println(x);});
		HttpSession session=req.getSession();
		System.out.println("new session:"+session.isNew() );
		if(session.isNew()){
			session.setMaxInactiveInterval(10);
		}
		//craetion of session object

		//here we fetch data (if Any) available in session object and store it into arraylist 

		List<Product> list=(List<Product>) session.getAttribute("cart"); 


		if(list==null) {
			System.out.println("New list created");
			list=new ArrayList<>();
		}
		
		for(String s:arr) {
			// 3:shoes:56.0
			String[] sarr=s.split(":");
			
			System.out.println("sarr"+sarr);
			Product p=new Product(Integer.parseInt(sarr[0]),sarr[1],Double.parseDouble(sarr[2]));
			System.out.println("split: "+p);
			list.add(p);
		}

		//add req and res (session data) in session attribute
		session.setAttribute("cart", list);
		System.out.println("In g cart ");
		for(Product a:list) {
			System.out.println(a);
		}

		out.println("in generateCart server");
		RequestDispatcher rd=req.getRequestDispatcher("categorydetails.html");
		rd.forward(req,res);

	}

}
