package com.example.demo.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	

	@Query("SELECT p FROM Product p WHERE p.id = :id")
	List<Product> findByProductId(@Param("id") Integer id);
 
}
