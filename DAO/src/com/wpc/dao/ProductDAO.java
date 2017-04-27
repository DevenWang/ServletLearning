package com.wpc.dao;

import java.util.List;

import com.wpc.model.Product;

public interface ProductDAO extends DAO {
	List<Product> getProducts() throws DAOException;
	void insert(Product product) throws DAOException;

}
