package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
 
@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public Product save(Product product) {
    	return repo.save(product);
    }
     
    public List<Product> getProductById(Integer id) {
        return repo.findByProductId(id);
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
