package com.wpc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wpc.action.GetProductsAction;
import com.wpc.action.SaveProductAction;
import com.wpc.form.ProductForm;
import com.wpc.model.Product;
import com.wpc.validator.ProductValidator;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/product_input", "/product_save", "/product_list" })
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 679L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		/*
		 * uri is in this form: /contextName/resourceName, for example:
		 * /app10a/product_input. However, in the case of a default context, the
		 * context name is empty, and uri has this form /resourceName, e.g.:
		 * /product_input
		 */
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = null;

		if (action.equals("product_input")) {
			// no action class, there is nothing to be done
			dispatchUrl = "/JSP/ProductForm.jsp";
		} else if (action.equals("product_save")) {
			// instantiate action class
			ProductForm productForm = new ProductForm();
			// populate action properties
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));

			// validate ProductForm
			ProductValidator productValidator = new ProductValidator();
			List<String> errors = productValidator.validate(productForm);
			if (errors.isEmpty()) {
				// create Product from ProductForm
				Product product = new Product();
				product.setName(productForm.getName());
				product.setDescription(productForm.getDescription());
				product.setPrice(Float.parseFloat(productForm.getPrice()));

				// no validation error, execute action method
				SaveProductAction saveProductAction = new SaveProductAction();
				saveProductAction.save(product);

				// store action in a scope variable for the view
				request.setAttribute("product", product);
				dispatchUrl = "/JSP/ProductDetails.jsp";
			} else {
				request.setAttribute("errors", errors);
				request.setAttribute("form", productForm);
				dispatchUrl = "/JSP/ProductForm.jsp";
			}
		} else if (action.equals("product_list") || action.isEmpty()) {
			GetProductsAction getProductsAction = new GetProductsAction();
			List<Product> products = getProductsAction.getProducts();
			request.setAttribute("products", products);
			dispatchUrl = "/JSP/ProductList.jsp";
		}

		// forward to a view
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
