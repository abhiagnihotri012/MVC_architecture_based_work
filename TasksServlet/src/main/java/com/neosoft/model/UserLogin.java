package com.neosoft.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/UserLogin")
public class UserLogin extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
//	   String pass=request.getParameter("pass");
//		   if(pass.equals("admin123")) {
		String name=request.getParameter("uname");
		
//		HttpSession session=request.getSession();
//		session.setAttribute(name,"true");
		   
		
		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
		
		if(timeOfDay >= 0 && timeOfDay < 12) {
			out.print("Hi "+name+", Good Morning");
		}
		else if(timeOfDay >= 12 && timeOfDay < 16) {
			out.print("Hi "+name+", Good Afternoon");
		}
		else if(timeOfDay >= 16 && timeOfDay < 21) {
			out.print("Hi "+name+", Good Evening");
		}
		else if(timeOfDay >= 21 && timeOfDay < 24) {
			out.print("Hi "+name+", Good Night");
		}
//		   }
	
	}
}
