package com.shipt.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.shipt.entity.Order;
import com.shipt.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
    private OrderRepository orderRepository;
	
	public Order find(Long orderId) {
		return orderRepository.find(orderId);
	}

	public List<Order> findByCustomerId(Long customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	@Transactional
	public Order save(Order order) {
		orderRepository.save(order);
		return order;
	}

	@Transactional
	public Order update(Order order, Long orderId, String orderStatus) {
		return orderRepository.update(order, orderId, orderStatus);
		
	}

	@Transactional
	public Order delete(Long orderId) {
		return orderRepository.delete(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderRepository.getAllOrders();
	}

}
