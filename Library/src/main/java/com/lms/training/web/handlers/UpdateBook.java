package com.lms.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.UpdateBookDAO;
import com.lms.training.domain.Bookdetails;



public class UpdateBook implements HttpRequestHandler {
	static Logger log = Logger.getLogger(UpdateBook.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		UpdateBookDAO dao = new UpdateBookDAO();
		Bookdetails book = new Bookdetails();

		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setPrice(Integer.parseInt(request.getParameter("price")));

		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int price = Integer.parseInt(request.getParameter("price"));

		try {

			int finalRes = dao.UpdateBook(isbn,price);
			if (finalRes > 0) {

				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/updatebook.jsp");
				request.setAttribute("success","Book Updated  Succesfully");
				request.setAttribute("book", book);
				dispatcher.forward(request, response);
			}
			
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/updatebook.jsp");
				request.setAttribute("Err","Sorry Book Record not Updated Succesfully");
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





