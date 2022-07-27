package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
	public List<Product> findAll();
	public Product findById(Integer id);
	public void saveOrUpdate(Product product);
	public void deleteById(int productId);
	
}
