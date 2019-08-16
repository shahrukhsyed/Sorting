package com.cg.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Product;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/capstore")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	Product p1=new Product("Oreo",201,null,"Cadbury",null,null,null,"Food",2000,5,20,404);
	Product p2=new Product("Gems",201,null,"Cadbury",null,null,null,"Food",2100,5,210,402);
	Product p3=new Product("5-star",201,null,"Cadbury",null,null,null,"Food",2900,5,203,401);
	Product p4=new Product("Dairy-Milk",201,null,"Cadbury",null,null,null,"Food",2800,5,202,4020);
	Product p5=new Product("Perk",201,null,"Cadbury",null,null,null,"Food",2500,5,200,403);
	
	@PostConstruct
	public void populate() {
		
		// creating dummy accounts
		
		productService.addProduct(p1);
		productService.addProduct(p2);
		productService.addProduct(p3);
		productService.addProduct(p4);
		productService.addProduct(p5);
		
	}
	

	// For getting products of a category in order of product price from low to high
	@GetMapping("/{category}/lowtohigh")
	public ResponseEntity<List<Product>> getProductsAsc(@PathVariable("category") String category) {
		List<Product> productAsc = productService.getProductsAsc(category);
		if (productAsc.isEmpty())
			return new ResponseEntity("Sorry! Products can't Retrieved!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(productAsc, HttpStatus.OK);

	}

	// For getting products of a category in order of product price from high to low
	@GetMapping("/{category}/hightolow")
	public ResponseEntity<List<Product>> getProductsDesc(@PathVariable String category) {
		List<Product> productDesc = productService.getProductsDesc(category);
		if (productDesc.isEmpty())
			return new ResponseEntity("Sorry! Products can't Retrieved!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(productDesc, HttpStatus.OK);

	}

	// For getting most-viewed products of a category
	@GetMapping("/{category}/mostViewed")
	public ResponseEntity<List<Product>> getMostViewed(@PathVariable String category) {
		List<Product> mostViewed = productService.getMostViewed(category);
		if (mostViewed.isEmpty())
			return new ResponseEntity("Sorry! Products can't Retrieved!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(mostViewed, HttpStatus.OK);

	}

	// For getting best-seller product of a category
	@GetMapping("/{category}/BestSeller")
	public ResponseEntity<List<Product>> getBestSeller(@PathVariable String category) {
		List<Product> bestSeller = productService.getBestSeller(category);
		if (bestSeller.isEmpty())
			return new ResponseEntity("Sorry! Product can't fetch!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(bestSeller, HttpStatus.OK);

	}

	// For getting products in a given range of price
	@GetMapping("/{category}/{min}/{max}")
	public ResponseEntity<List<Product>> getProductsInRange(@PathVariable String category,
			@PathVariable int min, @PathVariable int max) {
		List<Product> inRangeProducts = productService.getProductsInRange(category, min, max);
		if (inRangeProducts.isEmpty())
			return new ResponseEntity("Sorry! Product can't fetch!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(inRangeProducts, HttpStatus.OK);

	}

}
