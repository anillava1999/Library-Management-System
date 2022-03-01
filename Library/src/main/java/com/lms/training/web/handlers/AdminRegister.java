package com.lms.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.AdminRegisterDAO;
import com.lms.training.dao.DAOAppException;
import com.lms.training.domain.Admin;



public class AdminRegister implements HttpRequestHandler {
	static Logger log = Logger.getLogger(AdminRegister.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminRegisterDAO adao = new AdminRegisterDAO();
		Admin admin = new Admin();

		admin.setAdminid(Integer.parseInt(request.getParameter("adminid")));
		admin.setAdminpassword(request.getParameter("adminpassword"));
		admin.setAdminroleid(Integer.parseInt(request.getParameter("adminroleid")));
		admin.setAdminemailid(request.getParameter("adminemailid"));
		admin.setAdmincontactnumber(request.getParameter("admincontactnumber"));

		int adminid = Integer.parseInt(request.getParameter("adminid"));
		String adminpassword = request.getParameter("adminpassword");

		String page = "";

		if(adminid==123458 && adminpassword.equals("anil"))
		{
			boolean isExists;
			try {
				isExists = adao.validateAdmin(admin.getAdminid());

				if (isExists) {
					
				
					
					log.info("Admin already registered");
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/adminregistration.jsp");
					request.setAttribute("Err","Admin already registered with the system");
					dispatcher.forward(request, response);
				} else {
					//admin.setAdminpassword(admin.getAdminpassword());
					int res = adao.registerAdmin(admin);
					if (res > 0) {
						
						// Session Management
						HttpSession session = request.getSession(true);
						session.setAttribute("adminid", adminid);
						session.setMaxInactiveInterval(60);

						RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/adminlhome.jsp");
						request.setAttribute("success","Admin Succesfully Registered with the System");
						request.setAttribute("details", admin);
						dispatcher.forward(request, response);
					}
					else {
						RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/adminregistration.jsp");
						request.setAttribute("Err2","Sorry Admin not Registered Successfully");
						dispatcher.forward(request, response);
					}
				}
			} catch (DAOAppException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminerror.jsp");
				request.setAttribute("Err1", e.getMessage());
				dispatcher.forward(request, response);
			}
		}
		else
		{

			page="Invalidadmin.html";

		}
	}
}