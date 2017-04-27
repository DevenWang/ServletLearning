package com.wpc.action;

import java.util.List;

import com.wpc.dao.DAOException;
import com.wpc.dao.DAOFactory;
import com.wpc.dao.ProductDAO;
import com.wpc.model.Product;

public class GetProductsAction {
	public List<Product> getProducts() {
		ProductDAO productDAO = DAOFactory.getProductDAO();
		List<Product> products = null;
		try {
			products = productDAO.getProducts();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return products;
	}
}
