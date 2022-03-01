package com.lms.training.domain;

public class Admin {
	private int adminid;
	private String adminpassword;
	private int  adminroleid;
	private String adminemailid;
	private String admincontactnumber;
		
	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public int getAdminroleid() {
		return adminroleid;
	}

	public void setAdminroleid(int adminroleid) {
		this.adminroleid = adminroleid;
	}

	public String getAdminemailid() {
		return adminemailid;
	}

	public void setAdminemailid(String adminemailid) {
		this.adminemailid = adminemailid;
	}

	public String getAdmincontactnumber() {
		return admincontactnumber;
	}

	public void setAdmincontactnumber(String admincontactnumber) {
		this.admincontactnumber = admincontactnumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [adminid=");
		builder.append(adminid);
		builder.append(", adminpassword=");
		builder.append(adminpassword);
		
		builder.append(", adminroleid=");
		builder.append(adminroleid);
		
		builder.append(", adminemailid=");
		builder.append(adminemailid);
		builder.append(", admincontactnumber=");
		builder.append(admincontactnumber);
		builder.append("]");
		return builder.toString();
	}
}
