package com.demo.service;

import java.util.List;

import com.demo.bean.Product;
import com.demo.dao.Productpdao;
import com.demo.dao.ProductpdaoImpl;

public class ProductServiceImpl implements ProductService
{
	private Productpdao pdao;
	
	public ProductServiceImpl()
	{
		super();
		this.pdao = new ProductpdaoImpl();
	}

	@Override
	public void insertproduct(Product product) {
		pdao.saveProduct(product);
		
	}

	@Override
	public List<Product> displayAllProduct() {
		
		return pdao.getAllProduct();
	}

	@Override
	public void deleteById(int id) {
		pdao.removeById(id);
		
	}

	@Override
	public Product getById(int id) {
		
		return pdao.findById(id);
	}

	@Override
	public void updateById(Product p) {
		pdao.modifyById(p);
		
	}
	

	
}
