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

@WebServlet(urlPatterns = "/addstudent")
public class AddStudent extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//jdbc controller call
		Student student = new Student();
		student.setStname(req.getParameter("stname"));
		student.setStcourse(req.getParameter("stcourse"));
		student.setMarks(Integer.parseInt(req.getParameter("stmarks")));
		
		try {
			if(StudentController.insertStudent(student)==1) {
				out.print("<h2> Student Successfully Added!!</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");  
		        rd.include(req,resp);
			}
			else {
				out.print("<h2> Something Went Wrong!!</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("AddStudent.html");  
		        rd.include(req,resp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
	}

}
