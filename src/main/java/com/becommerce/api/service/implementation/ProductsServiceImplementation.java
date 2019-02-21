package com.becommerce.api.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.restlet.resource.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.becommerce.api.Config;
import com.becommerce.api.entity.Product;
import com.becommerce.api.repository.ProductsRepository;
import com.becommerce.api.security.SecurityRuntimeConfigurator;
import com.becommerce.api.service.ProductsService;

/**
 * This resource is responsible to create, update and research all the products
 * in the fishing supplies stores' database
 */

@Service
public class ProductsServiceImplementation implements ProductsService {

	
	@Autowired
	private ProductsRepository productsRepository;

	private SecurityRuntimeConfigurator securityRuntimeConfigurator;

	private static String absolutePath;
	

	public ProductsServiceImplementation() {}

	/**
	 * Constructor.
	 * 
	 * @param config Gathers configuration of the resource URI and security.
	 */
//	public ProductsServiceImplementation(Config config) {
//		this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
//		this.absolutePath = config.getBasePath() + "/products";
//	}

	/**
	 * Constructor.
	 * 
	 * @param config Gathers configuration of the resource URI and security.
	 * @param id     Attribute "id"
	 */

	public ProductsServiceImplementation(Config config, java.lang.String id) {
//		this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
//		this.id = id;
		this.absolutePath = config.getBasePath() + "/products/{id}";
	}

	/**
	 * Get the details from the product record.
	 * 
	 * @return {@link entities.Products}
	 * @throws org.restlet.resource.ResourceException if the call to the API fails
	 */
	public List<Product> getProducts() {
//		ClientResource client = new ClientResource(absolutePath);
//		securityRuntimeConfigurator.configure(client);
		List<Product> products = new ArrayList<>();
		productsRepository.findAll().forEach(products::add);
		return products;
	}

	public void postProduct(Product product) {
//		ClientResource client = new ClientResource(absolutePath);
//		securityRuntimeConfigurator.configure(client);
		productsRepository.save(product);
	}

	
	public void postProducts(List<Product> products) {
//		ClientResource client = new ClientResource(absolutePath);
//		securityRuntimeConfigurator.configure(client);
		productsRepository.saveAll(products);
	}
	// for products/id

	/**
	 * Get the details from the product record.
	 * 
	 * @return {@link Product}
	 * @throws ResourceException if the call to the API fails
	 */
	public Optional<Product> getProductsId(Integer id) {
//		ClientResource client = new ClientResource(absolutePath);
//		client.setAttribute("id", this.id);
//		securityRuntimeConfigurator.configure(client);

		return productsRepository.findById(id);
	}

	/**
	 * Updates the product record.
	 * 
	 * @param bean Parameter "bean"
	 * @return {@link Product}
	 * @throws ResourceException if the call to the API fails
	 */
	public void putProductsId(Product bean, Integer code) {
//		ClientResource client = new ClientResource(absolutePath);
//		client.setAttribute("id", this.id);
//		securityRuntimeConfigurator.configure(client);
		productsRepository.save(bean);
	}

	/**
	 * Inactivate the product record.
	 * 
	 * @throws ResourceException if the call to the API fails
	 */
	public void deleteProductsId(Integer id) {
//		ClientResource client = new ClientResource(absolutePath);
//		client.setAttribute("id", this.id);
//		securityRuntimeConfigurator.configure(client);

		productsRepository.deleteById(id);
	}

}
