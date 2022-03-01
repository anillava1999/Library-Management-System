package com.lms.training.web.handlers;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.CancelBookDAO;
import com.lms.training.dao.DAOAppException;
import com.lms.training.domain.CancelBook;



	public class GetCancelBook implements HttpRequestHandler {
		static Logger log = Logger.getLogger(GetRequestBook.class);

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			CancelBookDAO dao = new CancelBookDAO();
			CancelBook book = new CancelBook();
			
			book.setStudentid(Integer.parseInt(request.getParameter("studentid")));
			book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
			
			book.setCanceldate(request.getParameter("canceldate"));
			book.setCancelbook(request.getParameter("cancelbook"));
			
			
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			int isbn = Integer.parseInt(request.getParameter("isbn"));
		    String cancelbook = request.getParameter("cancelbook");
		    String canceldate = request.getParameter("canceldate");
		
			try {
				
				int finalRes = dao.CancelBook(studentid,isbn,cancelbook,canceldate);
				if (finalRes > 0) {

					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/cancelbook.jsp");
					request.setAttribute("success","Book Canceled Succesfully");
					request.setAttribute("book", book);
					dispatcher.forward(request, response);
				}
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/cancelbook.jsp");
					request.setAttribute("Err","Sorry Book not Canceled Succesfully");
					dispatcher.forward(request, response);
				}
			
		} catch (DAOAppException e) 
		{
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("adminerror.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
		}
	}
