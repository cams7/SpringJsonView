/**
 * 
 */
package com.javasampleapproach.jackson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasampleapproach.jackson.model.Company;

/**
 * @author m12264876
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
