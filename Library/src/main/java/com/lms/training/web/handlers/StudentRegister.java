
package com.lms.training.web.handlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.StudentRegisterDAO;
import com.lms.training.domain.Student;



public class StudentRegister implements HttpRequestHandler {
	static Logger log = Logger.getLogger(StudentRegister.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		StudentRegisterDAO dao = new StudentRegisterDAO();
		Student student = new Student();

		student.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		student.setStudentpassword(request.getParameter("studentpassword"));
		student.setStudentroleid(Integer.parseInt(request.getParameter("studentroleid")));
		student.setStudentemailid(request.getParameter("studentemailid"));
		student.setStudentcontactnumber(request.getParameter("studentcontactnumber"));

		int studentid = Integer.parseInt(request.getParameter("studentid"));
		String studentpassword = request.getParameter("studentpassword");


		boolean isExists;
		try {
			isExists = dao.validateStudent(student.getStudentid(),student.getStudentpassword());

			if (isExists) {
				
				
				log.info("Student already registered");
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/studentregistration.jsp");
				request.setAttribute("Err","Student already registered with the system");
				dispatcher.forward(request, response);
			} else {
				student.setStudentpassword(student.getStudentpassword());
				int finalRes = dao.registerStudent(student);
				if (finalRes > 0) {
					
					// Session Management
					HttpSession session = request.getSession(true);
					session.setAttribute("studentid", studentid);
					session.setMaxInactiveInterval(60);
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/studentregistration.jsp");
					request.setAttribute("success","Student succesfully registered with the system");
					request.setAttribute("details", student);
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/studentregistration.jsp");
					request.setAttribute("Err","Sorry Student Record not Stored Successfully");
					dispatcher.forward(request, response);
				}
			}
		} catch (DAOAppException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/studenterror.jsp");
			request.setAttribute("Err1","Sorry Can't Register Please Check");
			request.setAttribute("Err1", e.getMessage());
			dispatcher.forward(request, response);
		}
	}

}

