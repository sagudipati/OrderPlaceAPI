package com.shipt.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shipt.entity.Order;
import com.shipt.entity.Product;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Product> findByDateRange(String start, String end) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
		
		
			try {
				Date dStart = sf.parse(start);
				Date dEnd = sf.parse(end);
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			
		        

		
		return null;
	}


	@Override
	public List<Product> getAllProducts() {
		Query query = em.createNativeQuery(
				"select product.product_id, product.product_name, product.price from product");
		             
		               	List<Product> prodList = new ArrayList<Product>();
		               	prodList = query.getResultList(); 
				
		return prodList;
	}


	@Override
	public List<Product> findByDateRangeAndReportBy(String start, String end, String reportBy) {
		// TODO Auto-generated method stub
		return null;
	}

}
