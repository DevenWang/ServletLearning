package com.wpc.listenerdemo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		Map<String, String> countries = new HashMap<>();
		countries.put("one", "China");
		countries.put("two", "USA");
		servletContext.setAttribute("countries", countries);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
