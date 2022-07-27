package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		
		return repository.findAll();
	}

	
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}
	
	public void saveOrUpdate(Product product) {
		repository.saveOrUpdate(product);
	}



	public void deleteById(int productId) {
		repository.deleteById(productId);
		
	}


	

}

