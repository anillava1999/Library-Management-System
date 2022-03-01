package com.lms.training.web.handlers;

import javax.servlet.annotation.WebServlet;
import com.lms.mvc.HttpRequestHandler;
import com.lms.training.dao.RegisterBooksDAO;
import com.lms.training.domain.Bookdetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;




@WebServlet("/viewAvailablebooks")
public class viewAvailablebooks implements HttpRequestHandler
{
	public static Logger log=Logger.getLogger(viewAvailablebooks.class);


	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{
		PrintWriter out=response.getWriter();

		RegisterBooksDAO dao=new RegisterBooksDAO();
		List<Bookdetails> list = dao.list();

		request.setAttribute("list",list);
		RequestDispatcher rd = request.getRequestDispatcher("pages/ViewavailableBooks.jsp");
		rd.forward(request,response);

	}

}

