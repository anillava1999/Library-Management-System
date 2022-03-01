package com.lms.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.UpdateStudentDAO;
import com.lms.training.domain.Student;



	public class UpdateStudent implements HttpRequestHandler {
		static Logger log = Logger.getLogger(UpdateStudent.class);

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
				{
			UpdateStudentDAO dao = new UpdateStudentDAO();
			Student student = new Student();
			
			student.setStudentid(Integer.parseInt(request.getParameter("sid")));
			student.setStudentcontactnumber(request.getParameter("cno"));
			
			int id = Integer.parseInt(request.getParameter("sid"));
			String cno = request.getParameter("cno");


			
			try {
				
				int finalRes = dao.UpdateStudent(id, cno);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/updatestudent.jsp");
					request.setAttribute("success","Student Updated  Succesfully");
					request.setAttribute("student", student);
					dispatcher.forward(request, response);
				}
				
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/updatestudent.jsp");
					request.setAttribute("Err","Sorry Student not Updated Successfully");
					dispatcher.forward(request, response);
				}
			
		} catch (DAOAppException e) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminerror.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		}
	}
	




