package com.becommerce.api;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.becommerce.api.entity.Product;
import com.becommerce.api.repository.ProductsRepository;
import com.becommerce.api.service.ProductsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")

public class ProductsTest {

	@Autowired 
	private ProductsService productsService;

	@MockBean
	private ProductsRepository productsRepository;
	
	Product product;
	
	@Before
	public void setUp() throws Exception {
	product = new Product();
	product.setCode(1);
	product.setCategory("Carretilhas");
	product.setDescription("Carretilha Marine Sports Caster 400 3 Rol. Direita");
	product.setUnity("unity");
	product.setUnitaryPrice(20.00);
	
		BDDMockito.given(productsRepository.save(product)).willReturn(product);
	}

	@Test
	public void testGetProducts() {
			List<Product> products = (List<Product>) productsRepository.findAll();
			assertNotNull(products);
	}

	@Test
	public void postProduct() {
		Product prod = productsRepository.save(product);
		assertNotNull(prod);
	}

	@Test
	public void putProductsId() {
		Product prod = productsRepository.save(product);
		assertNotNull(prod);
	
	}

}