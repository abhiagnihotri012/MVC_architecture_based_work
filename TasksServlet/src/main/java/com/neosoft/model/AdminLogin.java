package com.neosoft.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("admin")&&pass.equals("admin123")){

			request.getRequestDispatcher("welcome.html").include(request, response);
			
		}else{
			
			out.println("<h3>Username or password error</h3>");
			request.getRequestDispatcher("login.html").include(request, response);

			


		}
		
		

		out.close();
	}	
}
