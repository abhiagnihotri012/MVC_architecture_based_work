package com.neosoft.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
//	response.sendRedirect("/register.html");
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("</head>");
		out.println("<body><h1>Your Form's Here!</h1>");
		out.println("</body>");
	
	
	
	String sname=request.getParameter("sname");
	String course=request.getParameter("course");
	String email_id=request.getParameter("email_id");
	String quaification=request.getParameter("qualification");
	String mobile_no=request.getParameter("mobile_no");
	String age=request.getParameter("age");
	out.println();
	out.println("<html><head>\r\n"
			+ "<style>\r\n"
			+ "table, th, td {\r\n"
			+ "  border: 1px solid black;\r\n"
			+ "}\r\n"
			+ "</style>\r\n"
			+ "</head>");
	out.println("<body><table><tr><td>Name</td><td>Course</td><td>Email-Id</td><td>Qualification</td><td>Mobile-no</td><td>Age</td></tr>");
	out.println("<tr><td>"+sname+"</td><td>"+course+"</td><td>"+email_id+"</td><td>UG</td><td>"+mobile_no+"</td><td>"+age+"</td></tr></table></body></html>");
	}

}
