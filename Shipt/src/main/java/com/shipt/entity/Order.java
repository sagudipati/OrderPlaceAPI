package com.shipt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ORDER_DETAILS")
@XmlRootElement
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long orderId;
	private Date orderDate;
	private Double orderTotal;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="orderMap")
    private List<OrderLine> orderLines;
	
	private String orderStatus;
	
	public Order() {
		
	}
	
	public Order(long orderId, Date orderDate, double orderTotal, String orderStatus) {
		this.orderId = orderId;
		this.orderLines = new ArrayList<>();
		this.orderTotal = orderTotal;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Double getOrderTotal() {
		double sum=0;
		if(orderLines != null) {
		for(OrderLine lines: orderLines) {
			sum += lines.getTotalPrice();
		}}
		return sum;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	

}
