package com.wpc.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "URLRewritingDemoServlet", urlPatterns = { "/urlrewriting" })
public class URLRewritingDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 54L;

	private static final String enCode = "UTF-8";
	private static final String contentType = "text/html";

	private List<String> londonAttractions;
	private List<String> parisAttractions;

	@Override
	public void init() throws ServletException {
		londonAttractions = new ArrayList<String>(10);
		londonAttractions.add("Buckingham Palace");
		londonAttractions.add("London Eye");
		londonAttractions.add("British Museum");
		londonAttractions.add("National Gallery");
		londonAttractions.add("Big Ben");
		londonAttractions.add("Tower of London");
		londonAttractions.add("Natural History Museum");
		londonAttractions.add("Canary Wharf");
		londonAttractions.add("2012 Olympic Park");
		londonAttractions.add("St Paul's Cathedral");

		parisAttractions = new ArrayList<String>(10);
		parisAttractions.add("Eiffel Tower");
		parisAttractions.add("Notre Dame");
		parisAttractions.add("The Louvre");
		parisAttractions.add("Champs Elysees");
		parisAttractions.add("Arc de Triomphe");
		parisAttractions.add("Sainte Chapelle Church");
		parisAttractions.add("Les Invalides");
		parisAttractions.add("Musee d'Orsay");
		parisAttractions.add("Montmarte");
		parisAttractions.add("Sacre Couer Basilica");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding(enCode);
		req.setCharacterEncoding(enCode);

		String city = req.getParameter("city");
		if (city != null && (city.equals("london") || city.equals("paris"))) {
			showAttractions(req, resp, city);
		} else {
			showMainPage(req, resp);
		}

	}

	private void showMainPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding(enCode);
		response.setCharacterEncoding(enCode);
		response.setContentType(contentType);

		PrintWriter writer = response.getWriter();
		writer.print("<html><head><title>" + "Top 10 Tourist Attraction" + "</title></head><body>" + "请选择城市："
				+ "<br /><a href='?city=london'>伦敦</a>" + "<br /><a href='?city=paris'>巴黎</a>" + "</body></html>");
	}

	private void showAttractions(HttpServletRequest request, HttpServletResponse response, String city)
			throws ServletException, IOException {

		request.setCharacterEncoding(enCode);
		response.setCharacterEncoding(enCode);
		response.setContentType(contentType);

		int page = 1;
		String pageParamerter = request.getParameter("page");
		if (pageParamerter != null) {
			try {
				page = Integer.parseInt(pageParamerter);
			} catch (NumberFormatException e) {

			}

			if (page > 2) {
				page = 1;
			}
		}

		List<String> attractions = null;
		if (city.equals("london")) {
			attractions = londonAttractions;
		} else if (city.equals("paris")) {
			attractions = parisAttractions;
		}

		PrintWriter writer = response.getWriter();
		writer.println("<html><head><title>Top 10 Attractions</title></head>");
		writer.println("<body>");
		writer.println("<a href='urlrewriting'>select city</a>");
		writer.println("<br /><hr>Page " + page + "</hr>");

		int start = page * 5 - 5;
		for (int i = start; i < start + 5; i++) {
			writer.println(attractions.get(i) + "<br />");
		}

		writer.println("<a href='?city=" + city + "&page=1'>Page 1</a>");
		writer.println("&nbsp; <a href='?city=" + city + "&page=2'>Page 2</a>");
		writer.print("</body></html>");
	}
}
