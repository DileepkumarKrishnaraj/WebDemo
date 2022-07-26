/*
 * package com.samco.servlet;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.PreparedStatement; import java.sql.ResultSet;
 * 
 * public class LoginDatabase {
 * 
 * public static boolean validate(String name,String password){ boolean status =
 * false;
 * 
 * 
 * try{ Class.forName("org.h2.Driver"); Connection
 * con=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
 * 
 * PreparedStatement ps=con.
 * prepareStatement("select * from REGISTRATION_DETAILS where USERNAME = ? and PASSWORD = ?"
 * ); ps.setString(1,name); ps.setString(2,password);
 * 
 * ps.setString(1,name); ps.setString(2,password);
 * 
 * ResultSet rs=ps.executeQuery(); status=rs.next(); String usernameCounter;
 * 
 * 
 * 
 * ResultSet rs=ps.executeQuery(); status=rs.next(); String usernameCounter;
 * String userPassword; while(rs.next()) {
 * 
 * if(usernameCounter.equals(name)) { System.out.println("It already exists");
 * status = true; if(userPassword.equals(password)) {
 * 
 * }
 * 
 * RequestDispatcher rd = request.getRequestDispatcher("index.html");
 * rd.include(request, response);
 * 
 * 
 * } }
 * 
 * }catch(Exception e){ System.out.println(e); } finally { rs.close();
 * ps.close(); con.close(); } return status; }
 * 
 * }
 * 
 * 
 */