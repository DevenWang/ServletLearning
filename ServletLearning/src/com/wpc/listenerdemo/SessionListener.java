package com.wpc.listenerdemo;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, ServletContextListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		AtomicInteger userCount = (AtomicInteger) context.getAttribute("userCount");
		int count = userCount.incrementAndGet();
		System.out.println("--------用户 增加到: " + count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		ServletContext context = session.getServletContext();
		AtomicInteger userCount = (AtomicInteger) context.getAttribute("userCount");
		int count = userCount.incrementAndGet();
		System.out.println("--------用户 减少到: " + count);
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		servletContext.setAttribute("userCount", new AtomicInteger());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
