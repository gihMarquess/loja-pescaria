package com.becommerce.api.security.authenticators;

import org.restlet.resource.ClientResource;

import com.becommerce.api.security.SecurityConfig;
import com.becommerce.api.security.authenticators.Authenticator;

/**
 * A marker class that serves as the id of the Authenticator that can be configured through
 * {@link SecurityConfig#configureCustomGlobalAuth}.
 */
public class CustomGlobalAuthenticator implements Authenticator {

    @Override
    public void configure(ClientResource clientResource) {
        // nothing
    }

}