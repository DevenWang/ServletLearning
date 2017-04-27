package com.wpc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpc.action.SaveProductAction;
import com.wpc.form.ProductForm;
import com.wpc.model.Product;
import com.wpc.validator.ProductValidator;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input", "/product_save" })
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 12345678L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		process(req, resp);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		int indext = uri.lastIndexOf("/");
		String action = uri.substring(indext + 1);
		String dispatchUrl = null;

		if (action.equals("product_input")) {
			dispatchUrl = "/JSP/ProductForm.jsp";

		} else if (action.equals("product_save")) {

			ProductForm productForm = new ProductForm();
			productForm.setProductName(request.getParameter("productName"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));

			ProductValidator validator = new ProductValidator();
			List<String> errors = validator.validate(productForm);

			if (errors.isEmpty()) {
				Product product = new Product();
				product.setProductName(productForm.getProductName());
				product.setDescription(productForm.getDescription());
				product.setPrice(Double.parseDouble(productForm.getPrice()));
				SaveProductAction saveProductAction = new SaveProductAction();
				saveProductAction.save(product);
				request.setAttribute("product", product);
				dispatchUrl = "/JSP/ProductDetails.jsp";
			} else {

				request.setAttribute("errors", errors);
				request.setAttribute("product", productForm);
				dispatchUrl = "/JSP/ProductForm.jsp";
			}

		}

		if (dispatchUrl != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
			dispatcher.forward(request, response);
		}

	}

}
