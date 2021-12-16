package com.neosoft.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neosoft.model.Student;

public class StudentController {
	
	public static List<Student> viewAllStudents() throws SQLException {
		
		List<Student> students = new ArrayList<Student>();
		Connection con = JDBCProperties.getConnection();
		
		try {
			String query = "SELECT *FROM MYDB.STUDENT";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) 
				students.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return students;
	}
	
	// making new changes.
	
	//For new student insert
	public static int insertStudent(Student student) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		
		int flag=0;
		try {
			String insertQuery = "INSERT INTO MYDB.STUDENT(stname,stcourse,marks) VALUES(?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(insertQuery);
			pst.setString(1, student.getStname());
			pst.setString(2, student.getStcourse());
			pst.setInt(3, student.getMarks());
			flag=pst.executeUpdate();			
			pst.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				con.close();
		}
		return flag;
	}
	
	//For updating student marks by Id
	public static int updateStudent(Student student) throws SQLException{
		Connection con = JDBCProperties.getConnection();
		
		int flag=0;
		try {
			String updateQuery = "UPDATE STUDENT SET MARKS=? WHERE STID=?";
			
			PreparedStatement pst = con.prepareStatement(updateQuery);
			pst.setInt(1, student.getMarks());
			pst.setInt(2, student.getStid());
			flag=pst.executeUpdate();			
			pst.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(con!=null)
				con.close();
		}
		return flag;
	}
	
	//For deleting student
		public static int deleteStudent(int id) throws SQLException{
			Connection con = JDBCProperties.getConnection();
			
			int flag=0;
			try {
				String deleteQuery = "DELETE FROM STUDENT WHERE STID=?";
				
				PreparedStatement pst = con.prepareStatement(deleteQuery);
				pst.setInt(1, id);
				flag=pst.executeUpdate();			
				pst.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(con!=null)
					con.close();
			}
			return flag;
		}

		//For searching student
		public static Student searchStudent(int id) throws SQLException{
			Connection con = JDBCProperties.getConnection();
			Student s = new Student();
					
			
			try {
				String searchQuery = "SELECT *FROM STUDENT WHERE STID=?";
				
				PreparedStatement pst = con.prepareStatement(searchQuery);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();		
				if(rs.next()) {
					s.setStid(rs.getInt(1));
					s.setStname(rs.getString(2));
					s.setStcourse(rs.getString(3));
					s.setMarks(rs.getInt(4));
				}
				
				pst.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(con!=null)
					con.close();
			}
			return s;
		}
		
		//For updating student course student
		public static int updateStudentCourse(int id,String course) throws SQLException{
			Connection con = JDBCProperties.getConnection();
			int flag = 0;
			
			try {
				String updateQuery = "UPDATE STUDENT SET STCOURSE=? WHERE STID=?";
				PreparedStatement pst = con.prepareStatement(updateQuery);
				pst.setString(1, course);
				pst.setInt(2, id);
				
				flag = pst.executeUpdate();
				
				pst.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				if(con!=null)
					con.close();
			}
			return flag;
		}
		
		//For updating student marks student
				public static int updateStudentMarks(int id,String marks) throws SQLException{
					Connection con = JDBCProperties.getConnection();
					int flag = 0;
					
					try {
						String updateQuery = "UPDATE STUDENT SET MARKS=? WHERE STID=?";
						PreparedStatement pst = con.prepareStatement(updateQuery);
						pst.setString(1, marks);
						pst.setInt(2, id);
						
						flag = pst.executeUpdate();
						
						pst.close();
					}
					catch(Exception e) {
						e.printStackTrace();
					}
					finally {
						if(con!=null)
							con.close();
					}
					return flag;
				}
}
