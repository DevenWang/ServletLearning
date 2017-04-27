package com.wpc.filterdemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "LoggingFilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "logFilterName", value = "filterLog.txt"),
		@WebInitParam(name = "prefix", value = "URI:") })
public class LoggingFilter implements Filter {

	private String prefix;
	private PrintWriter logger;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		prefix = filterConfig.getInitParameter("prefix");
		String logFilterName = filterConfig.getInitParameter("logFilterName");
		String appPath = filterConfig.getServletContext().getRealPath("/");
		System.out.println("logFilterName:" + logFilterName + " appPath:" + appPath);

		try {
			logger = new PrintWriter(new File(appPath, logFilterName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LoggingFilter.doFilter");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		logger.println(new Date() + " " + prefix + httpServletRequest.getRequestURI());
		logger.flush();
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		if (logger != null) {
			logger.close();
		}
	}

}
