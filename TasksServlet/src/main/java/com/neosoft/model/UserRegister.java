package com.neosoft.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.beans.StudentBean;

@WebServlet(urlPatterns="/UserRegister")
public class UserRegister extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
//		String name=request.getParameter("name");
//		response.setParameter(name);
		out.println("Registration successful!");
		request.getRequestDispatcher("login.html").include(request, response);
		
		
		StudentBean student= new StudentBean();
		
	
		out.close();
	}
}
