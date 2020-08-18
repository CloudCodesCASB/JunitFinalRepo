package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;
import com.example.demo.service.ProductService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JunitTestwithSpringBoot1ApplicationTests {


	    @Autowired
	    ProductService manager;
	     
	    @MockBean
	    ProductRepository dao;
	    
	    
	    @Test
		public void getAllUsers() {
			when(dao.findAll()).thenReturn(Stream
					.of(new Product(1, "sanrosh", 1000)).collect(Collectors.toList()));
			assertEquals(1, manager.listAll().size());
		}

	    
	    @Test
	    public void getEmployeeByIdTest()
	    {
	    	when(dao.findByProductId(1)).thenReturn(Stream
					.of(new Product(1, "sanrosh", 1000)).collect(Collectors.toList()));
	    	assertEquals(1, manager.getProductById(1).size());

	    }
	    
	    @Test
		public void save() {
	    	Product user = new Product(2, "Harish", 3000);
			when(dao.save(user)).thenReturn(user);
			assertEquals(user, manager.save(user));
		}
}
