package com.shipt.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shipt.entity.Order;

@Repository
@Component
public class OrderRepositoryImpl implements OrderRepository {

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public Order find(Long orderId) {
		return em.find(Order.class, orderId);
	}

	@Override
	public List<Order> findByCustomerId(Long customerId) {
		
		Query query = em.createNativeQuery(
		"select order_details.order_id, order_details.order_date, order_details.order_status,order_details.order_total, order_details.customer_id from order_details where order_details.customer_id= :customer_key");
                query.setParameter("customer_key", customerId);
                
                 Collection<Order> typedResult = new ArrayList<Order>(); 
                for(Object result : query.getResultList()) 
                { 
                     typedResult.add((Order) result); 
                }  
                return (List<Order>) typedResult;  
                
	}

	@Override
	public Order save(Order order) {
		em.persist(order);
		em.flush();
		return order;
	}

	@Override
	public Order update(Order order, Long orderId, String orderStatus) {
		Order updatedOrder = em.find(Order.class, orderId);
		updatedOrder.setOrderStatus(orderStatus);
		 updatedOrder = em.merge(updatedOrder);
		em.flush();
		return updatedOrder;
	}

	@Override
	public Order delete(Long orderId) {
		Order orderToDelete = em.find(Order.class, orderId);
		em.remove(orderToDelete);
		return orderToDelete;
	}

	@Override
	public List<Order> getAllOrders() {
		Query query = em.createNativeQuery(
				"select order_details.order_id, order_details.order_date, order_details.order_status,order_details.order_total, order_details.customer_id from order_details");
		             
		               	List<Order> orderList = new ArrayList<Order>();
		                	orderList = query.getResultList(); 
				return orderList;
	}

}
