
	package com.lms.training.web.handlers;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.DeleteStudentDAO;
import com.lms.training.domain.Student;


	public class DeleteStudent implements HttpRequestHandler {
		static Logger log = Logger.getLogger(DeleteStudent.class);

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			DeleteStudentDAO dao = new DeleteStudentDAO();
			Student student = new Student();
			
			student.setStudentid(Integer.parseInt(request.getParameter("studentid")));	
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			
			try {
				
				int res = dao.DeleteStudent(studentid);
				if (res > 0) {

					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/deletestudent.jsp");
					request.setAttribute("success","student Record deleted  Succesfully");
					request.setAttribute("student", student);
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/deletestudent.jsp");
					request.setAttribute("Err","Sorry Student Record not Deleted Succesfully");
					dispatcher.forward(request, response);
				}
			
		} catch (DAOAppException e) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminerror.jsp");
			request.setAttribute("Err1", e.getMessage());
			dispatcher.forward(request, response);
		}
		}
	}
	
