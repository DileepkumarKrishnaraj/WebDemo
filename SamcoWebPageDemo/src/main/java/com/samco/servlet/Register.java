package com.samco.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("uname");
		String email = request.getParameter("mail");
		String password = request.getParameter("pwd");
		String confirmPassword = request.getParameter("confirmpassword");
		String dateOfBirth = request.getParameter("dob");
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String userNameCheck = null;
		Statement s = null;
		try {
			con = Database.getConnection();
			s = con.createStatement();
			rs = s.executeQuery("select USERNAME from REGISTRATION_DETAILS"); 
			while(rs.next()) {
				userNameCheck = rs.getString("username");
				if(userNameCheck.equals(name)) {
					out.println("Username already taken");
					RequestDispatcher rd=request.getRequestDispatcher("Register.html");  
			        rd.include(request,response); 
			        return;
				}
			}		
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pst != null) pst.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		
		try {
			if (password.equals(confirmPassword)) {
				con = Database.getConnection();
				pst = con.prepareStatement("Insert into REGISTRATION_DETAILS(USERNAME, EMAIL, PASSWORD, DATEOFBIRTH) values(?,?,?,?)");
				
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, password);
				pst.setString(4, dateOfBirth);
				
				int x = pst.executeUpdate();
				if(x>=0) {
					RequestDispatcher rd = request.getRequestDispatcher("Success.html");
					rd.forward(request, response);
				}else {
					out.println("<h2>Data not saved</h2>");
				}
				
			} else {
				out.print("Sorry username or password error");
				RequestDispatcher rd = request.getRequestDispatcher("Register.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
