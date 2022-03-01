package com.lms.mvc;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MvcController extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	public static final Logger log = Logger.getLogger(MvcController.class);
	private Map handlers;

	static final long serialVersionUID = 1L;

	public void init(final ServletConfig config) throws ServletException {
		super.init(config);
		final String mvcProps = getServletContext().getRealPath(  
				"/WEB-INF/mvc.properties");
		try {
			this.handlers = MvcUtil.buildHandlers(mvcProps);
			log.info(handlers);
		} catch (MvcException e) {
			throw new ServletException(
					"Unable to configure controller servlet", e);
		}
	}

	protected void doGet(final HttpServletRequest request,
			final HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		File f = new File(url);
		String file = f.getName();
		String key = file.substring(0, file.lastIndexOf('.'));
		log.info(key);
		HttpRequestHandler handler = (HttpRequestHandler) handlers.get(key);
		if (handler != null) {
			handler.handle(request, response);
		} else {
			throw new ServletException("No matching handler");
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
