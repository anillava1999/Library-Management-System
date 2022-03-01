
package com.lms.training.web.handlers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.lms.training.dao.*;
import com.lms.mvc.HttpRequestHandler;
import com.lms.training.domain.Bookdetails;


// Registration  Book Operation
public class RegisterBooks implements HttpRequestHandler
{
	static Logger log = Logger.getLogger(RegisterBooks.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegisterBooksDAO add = new RegisterBooksDAO();
		Bookdetails bookdetials=new Bookdetails();

		bookdetials.setBookname(request.getParameter("bookname"));
		bookdetials.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		bookdetials.setAuthor(request.getParameter("author"));
		bookdetials.setPublisher(request.getParameter("publisher"));
		bookdetials.setEdition(Integer.parseInt(request.getParameter("edition")));
		bookdetials.setPrice(Integer.parseInt(request.getParameter("price")));
		bookdetials.setQuantity(Integer.parseInt(request.getParameter("quantity")));

		try {

			int flag = add.addbooks(bookdetials);
			if (flag > 0) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/bookregistration.jsp");
				request.setAttribute("success","Book Stored succesfully");
				request.setAttribute("book", bookdetials);
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/bookregistration.jsp");
				request.setAttribute("Err","Sorry Book not Stored Successfully");
				dispatcher.forward(request, response);
			}

		} catch (DAOAppException e) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("adminerrorpage.jsp");
			request.setAttribute("Err", e.getMessage());
			dispatcher.forward(request, response);
		}
	}


}

