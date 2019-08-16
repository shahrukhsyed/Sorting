package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.ProductDao;
import com.cg.entities.Product;

@Service
@Transactional
public class ProductService implements IProductService {

	@Autowired
	private ProductDao productDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public boolean addProduct(Product p) {
		// Adding Products
		productDao.save(p); // otherwise saving it in database
		return true;
	}

	// Sorting by products price in ascending order
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getProductsAsc(String productCategory) {
		List<Product> products = productDao.findByProductCategoryOrderByProductPrice(productCategory);

		return products;
	}

	// Sorting by products price in descending order
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getProductsDesc(String productCategory) {
		List<Product> products1 = productDao.findByProductCategoryOrderByProductPriceDesc(productCategory);
		return products1;
	}

	// For getting the most viewed product
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getMostViewed(String productCategory) {

		List<Product> product2 = productDao.findByproductCategoryOrderByProductViewDesc(productCategory);
		return product2;

	}

	// For getting the best-seller product
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getBestSeller(String productCategory) {
		List<Product> product3 = productDao.findByproductCategoryOrderByProductsSoldDesc(productCategory);
		return product3;
	}

	// For getting products in a given range of price
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Product> getProductsInRange(String productCategory, int min, int max) {
		List<Product> product4 = productDao.getProductsInRange(productCategory, min, max);
		return product4;
	}

}