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
import com.neosoft.model.Student;

@WebServlet(urlPatterns = "/searchstudent")
public class SearchStudent extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("searchId"));
		Student s=new Student();
		try {
			s=StudentController.searchStudent(id);
			
			if(s!=null) {
				out.print("<table border='2'>");
				out.print("<thead><th>STUDENT ID</th><th>NAME</th><th>COURSE</th><th>MARKS</th></thead>");
				out.print("<tbody>");
				out.print("<tr><td>"+s.getStid()+"</td><td>"+s.getStname()+"</td><td>"+s.getStcourse()+"</td><td>"+s.getMarks()+"</td></tr>");
				out.print("</tbody></table>");
				RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
				rd.include(req, resp);
			}
			else {
				out.println ("<h2>Sorry! unable to search Student id.</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("SearchStudent.html");  
				rd.include(req,resp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}
