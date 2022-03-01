package com.lms.training.web.handlers;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.ReturnBookDAO;
import com.lms.training.domain.ReturnBook;


public class GetReturnBook implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GetReturnBook.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ReturnBookDAO dao = new ReturnBookDAO();
		ReturnBook book = new ReturnBook();

		int studentid = Integer.parseInt(request.getParameter("studentid"));
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		String returnbook = request.getParameter("returnbook");

		// java.sql.Date requestdate =  new java.sql.Date(Calendar.getInstance().getTime().getTime());

		String returndate=request.getParameter("returndate");
		Date date=Date.valueOf(returndate);

		book.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setReturnbook(request.getParameter("returnbook"));
		book.setReturndate(date);

		try {

			int res = dao.ReturnBook(studentid,isbn,returnbook,date);
			if (res > 0) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/returnbook.jsp");
				request.setAttribute("success","Book Returned Succesfully");
				request.setAttribute("book", book);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/returnbook.jsp");
				request.setAttribute("Err","Sorry Book not Returned Succesfully");
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







