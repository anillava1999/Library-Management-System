package com.lms.training.web.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.AdminLoginDAO;
import com.lms.training.dao.DAOAppException;
import com.lms.training.domain.Admin;



public class AdminLogin implements HttpRequestHandler {
	public static Logger log = Logger.getLogger(AdminLogin.class);
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		int aid = Integer.parseInt(request.getParameter("adminid"));
		String apwsd = request.getParameter("adminpassword");
		int flag = -1;
		List admins = null;
		AdminLoginDAO dao = new AdminLoginDAO();
		try {
			admins = dao.validateAdmin(aid);
			log.info(admins);
			for (Object object : admins) {
				Admin admin = (Admin) object;
				if (admin.getAdminpassword().equals(apwsd)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			if (flag == 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminhome.jsp");
				request.setAttribute("Name", aid);
				dispatcher.forward(request, response);
				
				// Session Management
				HttpSession session = request.getSession(true);
				session.setAttribute("adminid", aid);
				session.setMaxInactiveInterval(60);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp");
				request.setAttribute("Err","AdminID or Adminpassword is Incorrect");
				dispatcher.forward(request, response);
			}
		}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminerror.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);


		}

	}



}
