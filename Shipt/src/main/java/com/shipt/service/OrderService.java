package com.shipt.service;

import java.util.List;

import com.shipt.entity.Order;

public interface OrderService {
	
	 Order find(Long orderId);
	    List<Order> findByCustomerId(Long customerId);
	    List<Order> getAllOrders();
	    Order save(Order order);
	    Order update(Order order, Long orderId, String orderStatus);
	    Order delete(Long orderId);
}
