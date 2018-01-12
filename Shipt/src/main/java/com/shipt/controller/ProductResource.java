package com.shipt.controller;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.shipt.entity.Product;
import com.shipt.repository.ProductRepositoryImpl;
import com.shipt.resources.ProductFilterBean;

@Path("/products")
public class ProductResource {
	
	ProductRepositoryImpl productService = new ProductRepositoryImpl();
	
	@GET
	public List<Product> getProducts(@BeanParam ProductFilterBean filterBean) {
		
		if (filterBean.getStart().length() >= 0 && filterBean.getEnd().length() >= 0) {
			return productService.findByDateRange(filterBean.getStart(), filterBean.getEnd());
		}
		
		return productService.getAllProducts();
	}

}
