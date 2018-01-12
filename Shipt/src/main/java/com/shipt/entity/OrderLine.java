package com.shipt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class OrderLine implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long orderLineId;
	private Double unitPrice;
	private Double totalPrice;	
	private int quantity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_ID")
	private Product product;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="ORDER_ID", nullable=false)
    private Order orderMap;
	
	public OrderLine() {
		
	}
	
	public OrderLine(long orderLineId, double unitPrice, double totalPrice, int quantity) {
		this.orderLineId = orderLineId;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
	}
	

	@Column(name="ORDER_LINE_ID")
	public Long getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(Long orderLineId) {
		this.orderLineId = orderLineId;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getTotalPrice() {
		return unitPrice*quantity;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name="NUMBER_PURCHASED")
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrderMap() {
		return orderMap;
	}

	public void setOrderMap(Order orderMap) {
		this.orderMap = orderMap;
	} 
	
	
}
