package com.neosoft.operations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/adminlogin")
public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		HttpSession session = req.getSession();
		
		String uid = req.getParameter("uid");
		String pass = req.getParameter("password");
		
		session.setAttribute("uid", uid);
		session.setAttribute("password", pass);
		
		if(uid.toLowerCase().equals("admin") && pass.equals("admin123")) {
			out.println("<h2>Welcome!!</h2>");
	        RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");  
	        rd.include(req,resp);  
	        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            resp.setDateHeader("Expires", 0);
		}
		else {
			out.print("<h2>Sorry username or password error</h2>");  
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");  
			rd.include(req,resp);  
		}
	}
	

}
