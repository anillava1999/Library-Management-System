package com.lms.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MvcUtil {
	// To check whether the class is implemented the interface using reflection
	private static boolean checkInterface(final Class clazz, final String interfaceName) {
		boolean found = false;
		// getting the interface implemented by the 
		Class[] interfaces = clazz.getInterfaces(); 

		for (int i = 0; i < interfaces.length; i++) {
			if (interfaces[i].getName().equals(interfaceName)) {
				found = true;
				break;
			}
		}
		return found;
	}

	public static Map buildHandlers(final String propsFile) throws MvcException {
		final Map handlers = new HashMap();
		final Properties props = new Properties();
		FileInputStream proStream = null;
		try {
			proStream = new FileInputStream(propsFile); /// in order to collect mvc properties.. 
			props.load(proStream);
			Enumeration proKeys = props.propertyNames();
			while (proKeys.hasMoreElements()) {
				String key = (String) proKeys.nextElement();// Key for the class from property file
				String clazz = props.getProperty(key);// Class path for the key
				Class handClazz = Class.forName(clazz);// Loading the Class

				// Checking whether the class implemented the HttpRequestHandler Interface 
				if (checkInterface(handClazz,
						"com.lms.mvc.HttpRequestHandler"))
				{
					// Thn create the object of that class & add that to the map
					Object handler = handClazz.newInstance();
					handlers.put(key, handler);
				} else {
					throw new MvcException(
							"Class does not implement com.keane.mvc.HttpRequestHandler interface");
				}

			}
		} catch (FileNotFoundException e) {
			throw new MvcException(e);
		} catch (IOException e) {
			throw new MvcException(e);
		} catch (ClassNotFoundException e) {
			throw new MvcException("No such class found..Please check");

		} catch (InstantiationException e) {
			throw new MvcException(e);
		} catch (IllegalAccessException e) {
			throw new MvcException(e);
		} finally {
			try {
				proStream.close();
			} catch (IOException e) {
				throw new MvcException(e);
			}
		}
		return handlers;

	}
}
