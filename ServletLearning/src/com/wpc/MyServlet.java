package com.wpc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "MyServlet", urlPatterns = { "/my" })
public class MyServlet implements Servlet {

	private transient ServletConfig servletConfig;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("初始化MyServlet");
		this.servletConfig = arg0;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String servletName = getServletConfig().getServletName();
		arg1.setContentType("text/html");
		PrintWriter printWriter = arg1.getWriter();
		printWriter.print("<html><head></head>" + "<body>Hello from " + servletName + "</body></html>");
	}

	@Override
	public void destroy() {
	}

	@Override
	public ServletConfig getServletConfig() {
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		return "My Servlet";
	}

}
