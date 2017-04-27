package com.wpc.action;

import com.wpc.dao.DAOException;
import com.wpc.dao.DAOFactory;
import com.wpc.dao.ProductDAO;
import com.wpc.model.Product;

public class SaveProductAction {
	public void save(Product product) {
		ProductDAO productDAO = DAOFactory.getProductDAO();
		try {
			productDAO.insert(product);
		} catch (DAOException e) {
			e.printStackTrace();

		}
	}
}
