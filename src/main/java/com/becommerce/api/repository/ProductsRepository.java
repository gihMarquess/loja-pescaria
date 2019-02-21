package com.becommerce.api.repository;


import org.springframework.data.repository.CrudRepository;

import com.becommerce.api.entity.Product;

/**
 * This resource is responsible to create, update and research all the products
 * in the fishing supplies stores' database
 */
public interface ProductsRepository extends CrudRepository<Product, Integer> {

}