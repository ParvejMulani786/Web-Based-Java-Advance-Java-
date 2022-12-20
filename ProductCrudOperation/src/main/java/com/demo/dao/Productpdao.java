package com.demo.dao;

import java.util.List;

import com.demo.bean.Product;

public interface Productpdao {



	void saveProduct(Product product);

	List<Product> getAllProduct();

	void removeById(int id);

	Product findById(int id);

	void modifyById(Product p);

}
