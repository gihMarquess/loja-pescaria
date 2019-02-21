package com.becommerce.api.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.becommerce.api.dto.ProductDto;
import com.becommerce.api.entity.Product;
import com.becommerce.api.respose.Response;
import com.becommerce.api.service.ProductsService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class ProductsController {

	private static final Logger log = LoggerFactory.getLogger(ProductsController.class);
	
	
	@Autowired
	private ProductsService productsService;
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> getProducts (){
		log.info("Getting all products");
		return productsService.getProducts();
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Response<List<ProductDto>>> postProducts(@Valid @RequestBody List<ProductDto> productsDto,
			BindingResult result) throws NoSuchAlgorithmException {
		log.info("Posting products: {}", productsDto.toString());
		Response<List<ProductDto>> response = new Response<>();

		if (result.hasErrors()) {
			log.error("Error in posting product: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		List<Product> products = productsDto.stream().map(productDTO->convertDtoToProducts(productDTO)).collect(Collectors.toList()); //convertDtoToProducts(productsDto);
		productsService.postProducts(products);
		response.setData(productsDto);
		return ResponseEntity.ok(response);
	}
	

	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	public Optional<Product> getProductId(@PathVariable Integer id) {
		log.info("Getting product: " + id);
		return productsService.getProductsId(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public Object updateProduct (@Valid @RequestBody ProductDto productDto, Integer id, BindingResult result) throws NoSuchAlgorithmException {
		
		Response<ProductDto> response = new Response<>();

		if (result.hasErrors()) {
			log.error("Error in puting product: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		Product product = convertDtoToProducts(productDto);
		productsService.putProductsId(product, id);
		response.setData(productDto);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
		
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public Object deleteProduct (@PathVariable Integer id) {
		log.info("Deleting product: " + id);
		productsService.deleteProductsId(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	private static Product convertDtoToProducts( @Valid ProductDto productsDto) {
		Product product = new Product();
		product.setCode(productsDto.getCode());
		product.setName(productsDto.getName());
		product.setCategory(productsDto.getCategory());
		product.setDescription(productsDto.getDescription());
		product.setUnity(productsDto.getUnity());
		product.setUnitaryPrice(productsDto.getUnitaryPrice());
		product.setTotalPrice(productsDto.getTotalPrice());
		
		return product;
	}
}
