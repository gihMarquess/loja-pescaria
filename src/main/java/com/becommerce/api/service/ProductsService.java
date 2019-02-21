package com.becommerce.api.service;

import java.util.List;
import java.util.Optional;

import com.becommerce.api.entity.Product;

public interface ProductsService {

	public List<Product> getProducts();
	public void postProduct(Product product);
	public void postProducts(List<Product> products);
	public Optional<Product> getProductsId(Integer id);
	public void putProductsId(Product bean, Integer code);
	public void deleteProductsId(Integer id);
}
