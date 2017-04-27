package com.wpc.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "MultipleUploadsServlet", urlPatterns = { "/multipleUploads" })
@MultipartConfig
public class MultipleUploadsServlet extends HttpServlet {

	private static final long serialVersionUID = 321471L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/MultipleUploads.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");

		Collection<Part> parts = req.getParts();

		int i = 0;
		Map<String, String> infos = new HashMap<>();
		for (Part part : parts) {
			if (part.getContentType() != null) {
				String fileName = getFileName(part);
				if (fileName != null && !fileName.isEmpty()) {
					i++;
					part.write(getServletContext().getRealPath("/") + "/" + fileName);
					System.out.println(getServletContext().getRealPath("/") + "/" + fileName);
					infos.put("第" + i + "个文件名", fileName);
					infos.put("第" + i + "个文件大小", part.getSize() + "");
				}
			} else {
				String partName = part.getName();
				String fieldValue = req.getParameter(partName);
				req.setAttribute(partName, fieldValue);
			}
		}

		req.setAttribute("infos", infos);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/successUpload.jsp");
		dispatcher.forward(req, resp);
	}

	public String getFileName(Part part) {

		String contentDispositionHeader = part.getHeader("content-disposition");
		String[] elements = contentDispositionHeader.split(";");
		
		for (String element : elements) {
			if (element.trim().startsWith("filename")) {
				return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

}
