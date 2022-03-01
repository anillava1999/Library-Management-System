

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
import com.lms.training.dao.RequestBookDAO;
import com.lms.training.domain.RequestBook;



public class GetRequestBook implements HttpRequestHandler {
	static Logger log = Logger.getLogger(GetRequestBook.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestBookDAO dao = new RequestBookDAO();
		RequestBook book = new RequestBook();

		int studentid = Integer.parseInt(request.getParameter("studentid"));
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		String requestbook = request.getParameter("requestbook");

		// java.sql.Date requestdate =  new java.sql.Date(Calendar.getInstance().getTime().getTime());

		String requestdate=request.getParameter("requestdate");
		Date date=Date.valueOf(requestdate);

		book.setStudentid(Integer.parseInt(request.getParameter("studentid")));
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setRequestbook(request.getParameter("requestbook"));

		book.setRequestdate(date);
		try {

			int finalRes = dao.RequestBook(studentid,isbn,requestbook,date);
			if (finalRes > 0) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/requestbook.jsp");
				request.setAttribute("success","Book Requested Succesfully");
				request.setAttribute("book", book);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/requestbook.jsp");
				request.setAttribute("Err","Sorry Book not Requested Successfulyy");
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





