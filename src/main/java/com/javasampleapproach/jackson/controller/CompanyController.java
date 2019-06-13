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
import com.javasampleapproach.jackson.model.Company;
import com.javasampleapproach.jackson.service.CompanyService;

/**
 * @author m12264876
 *
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@GetMapping
	public List<Company> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") Long companyId) {
		Company company = companyService.getCompanyById(companyId);
		return ResponseEntity.ok().body(company);
	}

	@JsonView(View.Overall.class)
	@GetMapping("overall/{id}")
	public ResponseEntity<Company> getOveralViewCompanyById(@PathVariable(value = "id") Long companyId) {
		Company company = companyService.getCompanyById(companyId);
		return ResponseEntity.ok().body(company);
	}

	@JsonView(View.Detail.class)
	@GetMapping("detail/{id}")
	public ResponseEntity<Company> getDetailViewCompanyById(@PathVariable(value = "id") Long companyId) {
		Company company = companyService.getCompanyById(companyId);
		return ResponseEntity.ok().body(company);
	}

	@PostMapping
	public Company createCompany(@Valid @RequestBody Company company) {
		Company savedCompany = companyService.createCompany(company);
		return savedCompany;
	}

	@PutMapping("{id}")
	public ResponseEntity<Company> updateCompany(@PathVariable(value = "id") Long companyId,
			@Valid @RequestBody Company company) {
		final Company updatedCompany = companyService.updateCompany(companyId, company);
		return ResponseEntity.ok(updatedCompany);
	}

	@DeleteMapping("{id}")
	public Map<String, Boolean> deleteCompany(@PathVariable(value = "id") Long companyId) {
		companyService.deleteCompany(companyId);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
