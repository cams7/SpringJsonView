package com.javasampleapproach.jackson.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonView;
import com.javasampleapproach.jackson.View;

@Entity
@Table(name = "fabricante")
public class Company {
	@JsonView({ View.Detail.class, View.Product.class })
	@Id
	@SequenceGenerator(name = "sq_fabricante", sequenceName = "sq_fabricante", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_fabricante")
	@Column(name = "id_fabricante")
	private Long id;

	@JsonView(View.Overall.class)
	@Column(name = "nome_fabricante", nullable = false)
	private String name;

	@JsonView(View.Overall.class)
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
	private List<Product> products;

	public Company() {
	}

	public Company(Long id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
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
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	/**
	 * 
	 * Show Overal View
	 */
	public String overalViewString() throws JSONException {
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("name", this.name);

		JSONArray productArray = new JSONArray();
		if (this.products != null) {
			this.products.forEach(product -> {
				JSONObject subJson = new JSONObject();
				try {
					subJson.put("name", product.getName());
				} catch (JSONException e) {
				}
				productArray.put(subJson);
			});
		}
		jsonInfo.put("products", productArray);

		return jsonInfo.toString();
	}

	/**
	 * 
	 * Show Detail View
	 */
	public String detailViewString() throws JSONException {
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("id", this.id);
		jsonInfo.put("name", this.name);

		JSONArray productArray = new JSONArray();
		if (this.products != null) {
			this.products.forEach(product -> {
				JSONObject subJson = new JSONObject();
				try {
					subJson.put("id", product.getId());
					subJson.put("name", product.getName());
				} catch (JSONException e) {
				}
				productArray.put(subJson);
			});
		}
		jsonInfo.put("products", productArray);

		return jsonInfo.toString();
	}

}