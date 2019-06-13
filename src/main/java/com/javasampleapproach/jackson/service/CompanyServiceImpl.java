/**
 * 
 */
package com.javasampleapproach.jackson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javasampleapproach.jackson.model.Company;
import com.javasampleapproach.jackson.repository.CompanyRepository;

/**
 * @author m12264876
 *
 */
@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javasampleapproach.jackson.service.CompanyService#getAllCompanies()
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.CompanyService#getCompanyById(java.
	 * lang.Long)
	 */
	@Transactional(readOnly = true)
	@Override
	public Company getCompanyById(Long companyId) {
		return companyRepository.findById(companyId).get();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.javasampleapproach.jackson.service.CompanyService#createCompany(com.
	 * javasampleapproach.jackson.model.Company)
	 */
	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.CompanyService#updateCompany(java.lang
	 * .Long, com.javasampleapproach.jackson.model.Company)
	 */
	@Override
	public Company updateCompany(Long companyId, Company company) {
		return createCompany(company);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.javasampleapproach.jackson.service.CompanyService#deleteCompany(java.lang
	 * .Long)
	 */
	@Override
	public void deleteCompany(Long companyId) {
		companyRepository.deleteById(companyId);
	}

}
