package com.wpc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ServletConfigDemoServlet", urlPatterns = { "/ServletConfigDemo" }, 
		initParams = {
				@WebInitParam(name = "admin", value = "wpc"), 
				@WebInitParam(name = "email", value = "1806842229@qq.com") 
			}
		)
public class ServletConfigDemoServlet implements Servlet {

	private transient ServletConfig servletConfig;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
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
		return "ServletConfigDemo";
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		String admin = servletConfig.getInitParameter("admin");
		String email = servletConfig.getInitParameter("email");
		
		arg1.setContentType("text/html");
		PrintWriter writer = arg1.getWriter();
		writer.print("<html><head></head></html><body>"
				+ "ServletConfigDemo: "
				+ "<br />"
				+ "admin is " + admin
				+ "<br />"
				+ "email is " + email
				+ "</body></html>");
	}
}
