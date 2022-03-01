package com.lms.training.web.handlers;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpHandler;

import com.lms.mvc.HttpRequestHandler;

@WebServlet("/adminlogout")
public class AdminLogout implements HttpRequestHandler {  
	
	
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	{ 
	response.setContentType("text/html");  
	PrintWriter out=response.getWriter();  
	RequestDispatcher dispatcher;

	HttpSession session=request.getSession();  
	session.invalidate();
    HttpSession nsession = request.getSession(false);
    if(nsession!=null) {
       String data=(String)session.getAttribute( "studentid" );
       out.println(data);
    }
    else
   
	 dispatcher = request.getRequestDispatcher("index.jsp");
}  
}  

