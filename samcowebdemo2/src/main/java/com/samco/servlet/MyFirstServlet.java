package com.samco.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MyFirstServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String password = request.getParameter("pwd");
		
		if(name.equals("Dileepkumar K")) {
			if(password.equals("dileep")) {
				RequestDispatcher rs = request.getRequestDispatcher("Success.html");
				out.println("Welcome " + name);
	            rs.forward(request, response);
			}else {
				out.println("Invalid Password");
				RequestDispatcher rs = request.getRequestDispatcher("index.html");
		        rs.include(request, response);
			}
		
		}else {
			out.println("Invalid Username");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
	        rs.include(request, response);	
		}
	}
}
