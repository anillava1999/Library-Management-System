package com.lms.training.domain;

	public class ReturnBook
	{
	private int studentid;
	private int isbn;
	private String returnbook;
	private java.sql.Date returndate;


	public int getStudentid() {
		return studentid;
	}


	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getReturnbook() {
		return returnbook;
	}


	public void setReturnbook(String returnbook) {
		this.returnbook = returnbook;
	}


	public java.sql.Date getReturndate() {
		return returndate;
	}


	public void setReturndate(java.sql.Date returndate) {
		this.returndate = returndate;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReturnBook [studentid=");
		builder.append(studentid);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append(", returnbook=");
		builder.append(returnbook);
		builder.append(", returndate=");
		builder.append(returndate);
		return builder.toString();
	}
	}


