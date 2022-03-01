package com.lms.training.domain;

public class Student
{
private int studentid;
private String studentpassword;
private int studentroleid;
private String studentemailid;
private String studentcontactnumber;

public int getStudentid() {
	return studentid;
}
public void setStudentid(int studentid) {
	this.studentid = studentid;
}
public String getStudentpassword() {
	return studentpassword;
}
public void setStudentpassword(String studentpassword) {
	this.studentpassword = studentpassword;
}
public int getStudentroleid() {
	return studentroleid;
}
public void setStudentroleid(int studentroleid) {
	this.studentroleid = studentroleid;
}
public String getStudentemailid() {
	return studentemailid;
}
public void setStudentemailid(String studentemailid) {
	this.studentemailid = studentemailid;
}
public String getStudentcontactnumber() {
	return studentcontactnumber;
}
public void setStudentcontactnumber(String studentcontactnumber) {
	this.studentcontactnumber = studentcontactnumber;
}

@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Student [studentid=");
	builder.append(studentid);
	builder.append(", studentpassword=");
	builder.append(studentpassword);
	
	builder.append(", studentroleid=");
	builder.append(studentroleid);
	
	builder.append(", studentemailid=");
	builder.append(studentemailid);
	builder.append(", studentcontactnumber=");
	builder.append(studentcontactnumber);
	builder.append("]");
	return builder.toString();
}







}
