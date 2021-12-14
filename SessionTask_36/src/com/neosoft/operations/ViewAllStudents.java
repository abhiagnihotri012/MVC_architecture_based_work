package com.neosoft.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neosoft.controller.StudentController;

@WebServlet(urlPatterns = "/viewallstudents")
public class ViewAllStudents extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<table border='2'>");
		out.print("<thead><th>STUDENT ID</th><th>NAME</th><th>COURSE</th><th>MARKS</th></thead>");
		out.print("<tbody>");
		try {
			StudentController.viewAllStudents().stream().forEach(
					st -> out.println("<tr><td>"+st.getStid()+"</td><td>"+st.getStname()+"</td><td>"+st.getStcourse()+"</td><td>"+st.getMarks()+"</td>"));
			out.print("</tbody></table>");
			RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");  
	        rd.include(req,resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		
	
	}
}
