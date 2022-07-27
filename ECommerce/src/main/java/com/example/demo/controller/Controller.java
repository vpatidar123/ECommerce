package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;


@RestController
@RequestMapping("/product")
public class Controller {

	@Autowired
	private ProductService productService;

	@GetMapping("/productList")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/product/{productId}")
	public Product findById(@PathVariable Integer productId) throws Exception {
		Product p = productService.findById(productId);

		if (p == null)
			throw new Exception("product ID : " + productId + " details not available in Repository..");

		return p;
	}

	@PostMapping("/saveProduct")
	public String saveEmployee(@RequestBody Product product) {
		product.setId(0);
		productService.saveOrUpdate(product);

		return "Employee details added successfully!!!";
	}

	@PutMapping("/updateProduct")
	public String updateEmployee(@RequestBody Product product) throws Exception {
	
		
		productService.saveOrUpdate(product);
		
		return "Product ID : "+ product.getId() + " Details updated Succesfully !!"; 
	}

	@DeleteMapping("product/{id}")
	public String deleteById(@PathVariable int id) {
		productService.deleteById(id);
		return "Product ID : " + id +"details  deleted !!!";
	}
}

