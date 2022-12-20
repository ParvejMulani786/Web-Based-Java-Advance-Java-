package com.demo.service;

import java.util.List;

import com.demo.bean.Product;

public interface ProductService {

	void insertproduct(Product product);

	List<Product> displayAllProduct();

	void deleteById(int id);

	Product getById(int id);

	void updateById(Product p);

	

}
