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

@WebServlet(urlPatterns = "/updatecourse")
public class UpdateStudentCourse extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		String course= req.getParameter("course");
		
		try {
			if(StudentController.updateStudentCourse(id,course)==1) {
		         resp.sendRedirect ("viewallstudents");
		    }
		    else {
		        out.println ("<h2>Sorry! unable to Update Course record</h2>");
		        RequestDispatcher rd=req.getRequestDispatcher("UpdateCourse.html");  
		        rd.include(req,resp);
		    }
		} catch (SQLException e) {
				e.printStackTrace();
		}
		out.close();
	}
}