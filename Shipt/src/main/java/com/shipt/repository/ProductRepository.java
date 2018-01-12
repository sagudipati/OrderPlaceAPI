package com.shipt.repository;

import java.util.List;

import com.shipt.entity.Product;


public interface ProductRepository {

	 List<Product> findByDateRange(String start, String end);
	 List<Product> findByDateRangeAndReportBy(String start, String end, String reportBy);
	 List<Product> getAllProducts();
}
