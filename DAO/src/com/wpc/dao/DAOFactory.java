package com.wpc.dao;

public class DAOFactory {
	public static ProductDAO getProductDAO() {
        return new ProductDAOImpl(); 
    }
}
