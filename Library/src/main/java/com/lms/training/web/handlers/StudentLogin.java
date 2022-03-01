
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
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.StudentLoginDAO;
import com.lms.training.domain.Student;


public class StudentLogin implements HttpRequestHandler {
	public static Logger log = Logger.getLogger(StudentLogin.class);
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String studentpassword = request.getParameter("studentpassword");

		int flag = -1;
		List admins = null;
		StudentLoginDAO dao = new StudentLoginDAO();
		try {
			admins = dao.validateStudent(studentid, studentpassword);
			log.info(admins);
			for (Object object : admins) {
				Student student = (Student) object;
				if (student.getStudentpassword().equals(studentpassword)) {
					flag = 0;
					break;
				}
			}
			log.info("Flag in login " + flag);
			if (flag == 0) {
				
				// Session Management
				HttpSession session = request.getSession(true);
				session.setAttribute("studentid", studentid);
				session.setMaxInactiveInterval(60);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("studenthome.jsp");
				request.setAttribute("Name", studentid);

				dispatcher.forward(request, response);
				
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("studentlogin.jsp");
				request.setAttribute("Err","Student ID or Student password is incorrect");
				dispatcher.forward(request, response);
			}
		}
		catch (DAOAppException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("studenterror.jsp");
			request.setAttribute("Err1", e.getMessage());
			dispatcher.forward(request, response);


		}
	}

}
