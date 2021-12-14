package com.neosoft.beans;  


public class StudentBean {
	
	private int uid;
	private String name, email_id,mobile_no, pass;
	
	
	
	public StudentBean() {
	
		// TODO Auto-generated constructor stub
	}

	

	public StudentBean(String name, String email_id, String mobile_no, String qualification, String course, int age) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.mobile_no = mobile_no;
	
	}



	public int getUid() {
		return uid;
	}



	public void setUid(int uid) {
		this.uid = uid;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail_id() {
		return email_id;
	}



	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}



	public String getMobile_no() {
		return mobile_no;
	}



	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}

 

	
}
