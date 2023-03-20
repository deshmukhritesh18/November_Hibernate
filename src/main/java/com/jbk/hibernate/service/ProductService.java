package com.jbk.hibernate.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.Order;

import com.jbk.hibernate.dao.ProductDao;
import com.jbk.hibernate.entity.Product;

public class ProductService {

	ProductDao dao=new ProductDao();
	public boolean saveProduct(Product product) {
		
		
		return dao.saveProduct(product);
		
	}
	
	public Product getProductById(long productId) {
		
		return dao.getProductById(productId);
	}

	public boolean deleteProductById(long productId) {
		boolean isDeleted=dao.deleteProductById(productId);
		return isDeleted;
	}

	public boolean updateProduct(Product product) {
		boolean isUpdated=dao.updateProduct(product);
		return isUpdated;
	}
	
	public List<Product> getAllProduct(){
		
		return dao.getAllProducts();
		
	}

	public List<Product> getAllProductByAsendingOrderByName() {
		
		return dao.getAllProductByAsendingOrderByName();
	}

	public List<Product> getAllProductByDesendingOrderByName() {
		
		return dao.getAllProductByDesendingOrderByName();
	}

	public List<Product> getAllGtProduct(double productPrice) {
		
		return dao.getAllGtProduct( productPrice);
	}

	public List<Product> getAllLtProduct(double productPrice) {
		
		return dao.getAllLtProduct(productPrice);
	}

	public List<Product> getAllCharProduct(String stringChar) {
		
		return dao.getAllCharProduct(stringChar);
	}

	
	

}