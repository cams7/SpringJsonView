package com.javasampleapproach.jackson.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonView;
import com.javasampleapproach.jackson.View;

@NamedEntityGraph(name = Product.SHOW_COMPANY, attributeNodes = { @NamedAttributeNode("company"), })
@Entity
@Table(name = "produto")
public class Product {

	public static final String SHOW_COMPANY = "Product.showCompany";

	@JsonView({ View.Detail.class, View.Product.class })
	@Id
	@SequenceGenerator(name = "sq_produto", sequenceName = "sq_produto", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_produto")
	@Column(name = "id_produto")
	private Long id;

	@JsonView({ View.Overall.class, View.Product.class })
	@Column(name = "nome_produto", nullable = false)
	private String name;

	@JsonView(View.Product.class)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id_fabricante")
	private Company company;

	public Product() {
	}

	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Product(String name, Company company) {
		this.name = name;
		this.company = company;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	// name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// products
	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return this.company;
	}

	public String toString() {
		String info = "";
		try {
			JSONObject jsonInfo = new JSONObject();
			jsonInfo.put("name", this.name);

			JSONObject companyObj = new JSONObject();
			companyObj.put("name", this.company.getName());
			jsonInfo.put("company", companyObj);

			info = jsonInfo.toString();
		} catch (JSONException e) {
		}

		return info;
	}
}
