package com.becommerce.api;

import com.becommerce.api.service.ProductsService;
import com.becommerce.api.service.implementation.ProductsServiceImplementation;

/**
 * Entry-point for API calls.
 */
public class Sdk {

    private final Config config = new Config();

    /**
     * Returns the SDK configuration.
     */
    public com.becommerce.api.Config getConfig() {
        return config;
    }

    public ProductsService products() {
        return new ProductsServiceImplementation(config, null);
    }
}
