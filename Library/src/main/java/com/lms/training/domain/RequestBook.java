package com.lms.training.domain;

public class RequestBook
{
private int studentid;
private int isbn;
private String requestbook;
private java.sql.Date requestdate;


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


public String getRequestbook() {
	return requestbook;
}


public void setRequestbook(String requestbook) {
	this.requestbook = requestbook;
}


public java.sql.Date getRequestdate() {
	return requestdate;
}


public void setRequestdate(java.sql.Date requestdate) {
	this.requestdate = requestdate;
}


@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("RequestBook [studentid=");
	builder.append(studentid);
	builder.append(", isbn=");
	builder.append(isbn);
	builder.append(", requestbook=");
	builder.append(requestbook);
	builder.append(", requestdate=");
	builder.append(requestdate);
	return builder.toString();
}
}
