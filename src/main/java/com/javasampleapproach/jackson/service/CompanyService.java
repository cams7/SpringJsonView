/**
 * 
 */
package com.javasampleapproach.jackson.service;

import java.util.List;

import com.javasampleapproach.jackson.model.Company;


/**
 * @author m12264876
 *
 */
public interface CompanyService {
	
	List<Company> getAllCompanies();

	Company getCompanyById(Long companyId);

	Company createCompany(Company company);

	Company updateCompany(Long companyId, Company company);
	
	void deleteCompany(Long companyId);

}
