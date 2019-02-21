package com.becommerce.api.entity;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
@Entity
@Table(name = "products")
public class Product implements java.io.Serializable {

	/** Default serial version ID. */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer code;

	private String name;

	private String description;

	private String category;

	private String unity;

	private Double unitaryPrice;

	private Double totalPrice;

	public Product() {
	}

	public Product(Integer code, String name, String description, String category, String unity,
			Double unitaryPrice, Double totalPrice) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.category = category;
		this.unity = unity;
		this.unitaryPrice = unitaryPrice;
		this.totalPrice = totalPrice;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "unity")
	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	@Column(name = "unitaryPrice", nullable = false)
	public Double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	@Column(name = "totalPrice")
	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Product code: " + code + ", name: " + name + ", description: " + description + ", category: " + category
				+ ", unity: " + unity + ", unitaryPrice: " + unitaryPrice + ", totalPrice: " + totalPrice;
	}
}
