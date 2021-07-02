package com.veb.inventoryservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veb.inventoryservice.models.Product;
import com.veb.inventoryservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@CrossOrigin("*")
	@PostMapping({"/v1.0", "/v1.1"})
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		
		   Product productObj=this.productService.addProduct(product);
		   if(productObj!=null) {
			   return ResponseEntity.status(HttpStatus.OK).body(productObj);
		   }
		   else
			   return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Added"); 
		
	}
	
	@GetMapping({"/v1.0", "/v1.1"})
	public List<Product> getAllProducts(){
		return this.productService.getAllProducts();
	}
	
}
