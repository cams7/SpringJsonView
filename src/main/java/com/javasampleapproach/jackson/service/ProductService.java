/**
 * 
 */
package com.javasampleapproach.jackson.service;

import java.util.List;

import com.javasampleapproach.jackson.model.Product;


/**
 * @author m12264876
 *
 */
public interface ProductService {
	
	List<Product> getAllProducts();

	Product getProductById(Long productId);

	Product createProduct(Product product);

	Product updateProduct(Long productId, Product product);
	
	void deleteProduct(Long productId);

}
