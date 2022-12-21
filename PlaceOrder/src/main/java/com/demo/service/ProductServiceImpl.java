package com.demo.service;

import java.util.List;

import com.demo.bean.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
    private ProductDao pdao;
   public ProductServiceImpl()
   {
	   pdao=new ProductDaoImpl();
   }
	@Override
	public List<Product> getByCatID(int catid) {
		
		return pdao.findByCatID(catid);
	}

}
