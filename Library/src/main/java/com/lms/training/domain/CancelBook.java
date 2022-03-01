package com.lms.training.domain;

public class CancelBook
{
	private int studentid;
	private int isbn;
	private String cancelbook;
	private String canceldate;
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
	public String getCancelbook() {
		return cancelbook;
	}
	public void setCancelbook(String cancelbook) {
		this.cancelbook = cancelbook;
	}
	public String getCanceldate() {
		return canceldate;
	}
	public void setCanceldate(String canceldate) {
		this.canceldate = canceldate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RequestBook [studentid=");
		builder.append(studentid);
		builder.append(", isbn=");
		builder.append(isbn);
		builder.append(", cancelbook=");
		builder.append(cancelbook);
		builder.append(", canceldate=");
		builder.append(canceldate);
		return builder.toString();
	}
}
