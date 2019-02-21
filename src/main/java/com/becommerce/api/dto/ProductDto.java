package com.becommerce.api.dto;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class ProductDto {
	
	private Integer code;
	private String name;
	private String description;
	private String category;
	private String unity;
	private Double unitaryPrice;
	private Double totalPrice;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@NotEmpty(message = "Name cannot be empty")
	@Length(min = 3, max = 200, message = "Name has to be 3 between 200 characters.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}

	public Double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

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
