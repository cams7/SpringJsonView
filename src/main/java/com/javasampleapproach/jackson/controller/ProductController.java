/**
 * 
 */
package com.javasampleapproach.jackson.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.javasampleapproach.jackson.View;
import com.javasampleapproach.jackson.model.Product;
import com.javasampleapproach.jackson.service.ProductService;

/**
 * @author m12264876
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@JsonView(View.Product.class)
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) {
		Product product = productService.getProductById(productId);
		return ResponseEntity.ok().body(product);
	}
	
	@JsonView(View.Overall.class)
	@GetMapping("overall/{id}")
	public ResponseEntity<Product> getOverallProductById(@PathVariable(value = "id") Long productId) {
		Product product = productService.getProductById(productId);
		return ResponseEntity.ok().body(product);
	}
	
	@JsonView(View.Detail.class)
	@GetMapping("detail/{id}")
	public ResponseEntity<Product> getDetailProductById(@PathVariable(value = "id") Long productId) {
		Product product = productService.getProductById(productId);
		return ResponseEntity.ok().body(product);
	}

	@PostMapping
	public Product createProduct(@Valid @RequestBody Product product) {
		Product savedProduct = productService.createProduct(product);
		return savedProduct;
	}

	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
			@Valid @RequestBody Product product) {
		final Product updatedProduct = productService.updateProduct(productId, product);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId) {
		productService.deleteProduct(productId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
