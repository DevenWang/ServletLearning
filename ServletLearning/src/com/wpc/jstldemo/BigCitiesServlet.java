package com.wpc.jstldemo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bigCitiesServlet", urlPatterns = { "/bigCities" })
public class BigCitiesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Map<String, String> capitals = new HashMap<String, String>();
		capitals.put("Indonesia", "Jakarta");
		capitals.put("Malaysia", "Kuala Lumpur");
		capitals.put("Thailand", "Bangkok");
		req.setAttribute("capitals", capitals);

		Map<String, String[]> bigCities = new HashMap<String, String[]>();
		bigCities.put("Australia", new String[] { "Sydney", "Melbourne", "Perth" });
		bigCities.put("New Zealand", new String[] { "Auckland", "Christchurch", "Wellington" });
		bigCities.put("Indonesia", new String[] { "Jakarta", "Surabaya", "Medan" });
		req.setAttribute("bigCities", bigCities);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/bigCities.jsp");
		dispatcher.forward(req, resp);

	}

}
