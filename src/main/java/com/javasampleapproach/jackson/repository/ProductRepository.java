/**
 * 
 */
package com.javasampleapproach.jackson.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.jackson.model.Product;

/**
 * @author m12264876
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@EntityGraph(value = Product.SHOW_COMPANY)
	@Query("SELECT p FROM Product p WHERE p.id = :productId")
	Optional<Product> findWithCompanyById(Long productId);
}
