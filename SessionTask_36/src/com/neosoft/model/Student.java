package com.neosoft.model;

public class Student {
	private int stid;
	private String stname;
	private String stcourse;
	private int marks;
	public Student() { }
	
	public Student(int stid, String stname, String stcourse, int marks) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.stcourse = stcourse;
		this.marks = marks;
	}
	
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStcourse() {
		return stcourse;
	}
	public void setStcourse(String stcourse) {
		this.stcourse = stcourse;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
}

/*create table student(stid int auto_increment primary key,
stname varchar(50) not null,
stcourse varchar(50) not null,
marks int(2) not null);
insert into mydb.student(stname,stcourse,marks)
values('Smita','Java',90), 
('Abitha','Java',93), 
('Saba','Python',91), 
('Sarwar','Python',95), 
('Arif','Java',98); 

SELECT * FROM MYDB.STUDENT;*/