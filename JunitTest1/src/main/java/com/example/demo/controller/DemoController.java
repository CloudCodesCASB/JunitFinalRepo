package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@RestController
public class DemoController {
	
	 @Autowired
	    private ProductService service;
	
	@GetMapping(value="/getByProductId/{productId}")
	public ResponseEntity<List<Product>> getByProductId(@PathVariable("productId") Integer productId) {
	    List<Product> tutorialData = service.getProductById(productId);
	    
	    if(tutorialData != null)
	       return new ResponseEntity<>(tutorialData, HttpStatus.OK);
	    else
	    	return new ResponseEntity<>(tutorialData, HttpStatus.BAD_REQUEST);
	   
	  }
	
	@PostMapping(value = "/save")
	public Product saveUser(@RequestBody Product product) {
		return service.save(product);
	}
	
	@GetMapping("/getAllUsers")
	public List<Product> findAllUsers() {
		return service.listAll();
	}
	

}
