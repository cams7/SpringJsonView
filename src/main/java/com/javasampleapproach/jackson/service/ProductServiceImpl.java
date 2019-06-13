/**
 * 
 */
package com.javasampleapproach.jackson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.jackson.model.Product;
import com.javasampleapproach.jackson.repository.ProductRepository;

/**
 * @author m12264876
 *
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javasampleapproach.jackson.service.ProductService#getAllProducts()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.ProductService#getProductById(java.
	 * lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Product getProductById(Long productId) {
		return productRepository.findWithCompanyById(productId).get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javasampleapproach.jackson.service.ProductService#createProduct(com.
	 * javasampleapproach.jackson.model.Product)
	 */
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.ProductService#updateProduct(java.lang
	 * .Long, com.javasampleapproach.jackson.model.Product)
	 */
	@Override
	public Product updateProduct(Long productId, Product product) {
		return createProduct(product);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.ProductService#deleteProduct(java.lang
	 * .Long)
	 */
	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

}
