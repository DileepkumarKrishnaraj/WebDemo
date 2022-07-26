/*
 * package com.samco.servlet;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import
 * java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * @WebServlet("/login") public class LoginPage extends HttpServlet { private
 * static final long serialVersionUID = 1L;
 * 
 * public LoginPage() { super(); }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * }
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
 * String name = request.getParameter("uname"); String password =
 * request.getParameter("pwd");
 * 
 * try { Connection con = Database.getConnection(); PreparedStatement pst = con.
 * prepareStatement("select * from REGISTRATION_DETAILS where USERNAME = ? and PASSWORD = ?"
 * ); pst.setString(1, name); pst.setString(2, password); String userNameCheck;
 * String userPasswordCheck; ResultSet rs = pst.executeQuery(); while(rs.next())
 * { if(userNameCheck.equals(name)) { if(userPasswordCheck.equals(password)) {
 * RequestDispatcher rd=request.getRequestDispatcher("Success.html");
 * rd.forward(request,response); }else {
 * out.print("Password Error. Please try again"); RequestDispatcher
 * rd=request.getRequestDispatcher("Login.html"); rd.include(request,response);
 * } }else { out.print("Username Error. Please try again"); RequestDispatcher
 * rd=request.getRequestDispatcher("Login.html"); rd.include(request,response);
 * }
 * 
 * } }catch(Exception e){ e.printStackTrace(); } } }
 */