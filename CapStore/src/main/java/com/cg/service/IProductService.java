package com.cg.service;

import java.util.List;

import com.cg.entities.Product;

public interface IProductService {

	// Sorting by products price in ascending order
	public List<Product> getProductsAsc(String productCategory);

	// Sorting by products price in descending order
	public List<Product> getProductsDesc(String productCategory);

	// For getting the most viewed product
	public List<Product> getMostViewed(String productCategory);

	// For getting the best-seller product
	public List<Product> getBestSeller(String productCategory);

	// For getting products in a given range of price
	public List<Product> getProductsInRange(String productCategory, int min, int max);
}
