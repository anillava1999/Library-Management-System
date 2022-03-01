
	package com.lms.training.web.handlers;

	import java.io.IOException;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import org.apache.log4j.Logger;

import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.DAOAppException;
import com.lms.training.dao.DeleteBookDAO;
import com.lms.training.domain.Bookdetails;



	public class DeleteBook implements HttpRequestHandler {
		static Logger log = Logger.getLogger(DeleteBook.class);

		@Override
		public void handle(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			DeleteBookDAO dao = new DeleteBookDAO();
			Bookdetails book = new Bookdetails();
			
			book.setIsbn(Integer.parseInt(request.getParameter("isbn")));	
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			
			try {
				
				int res = dao.DeleteBook(isbn);
				if (res > 0) {

					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/deletebook.jsp");
					request.setAttribute("success","Book Deleted  Succesfully");
					request.setAttribute("book", book);
					dispatcher.forward(request, response);
				}
				
				else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("../pages/deletebook.jsp");
					request.setAttribute("Err","Sorry Book not Deleted Succesfully");
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
	


