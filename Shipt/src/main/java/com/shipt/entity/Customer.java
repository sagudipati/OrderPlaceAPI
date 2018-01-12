package com.shipt.entity;
import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmailId;
	/*@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column = @Column(name="SHIPPING_STREET")),
		@AttributeOverride(name="city", column = @Column(name="SHIPPING_CITY")),
		@AttributeOverride(name="zipcode", column = @Column(name="SHIPPING_ZIP")),
		@AttributeOverride(name="state", column = @Column(name="SHIPPING_STATE"))})
	private Address shippingAddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column = @Column(name="BILLING_STREET")),
		@AttributeOverride(name="city", column = @Column(name="BILLING_CITY")),
		@AttributeOverride(name="zipcode", column = @Column(name="BILLING_ZIP")),
		@AttributeOverride(name="state", column = @Column(name="BILLING_STATE"))})
		private Address BillingAddress;*/
	
	public Customer() {
		
	}
	
	
	public Customer(long customerId, String customerFirstName, String customerLastName, String customerEmailId) {
		this.customerId = customerId;
		this.customerEmailId = customerEmailId;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;

	}
	
	@Column(name="CUSTOMER_ID")
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	@Column(name="CUSTOMER_FIRST_NAME")
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	
	@Column(name="CUSTOMER_LAST_NAME")
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	
	@Column(name="CUSTOMER_EMAILID")
	public String getCustomerEmailId() {
		return customerEmailId;
	}
	public void setCustomerEmailId(String customerEmailId) {
		this.customerEmailId = customerEmailId;
	}
/*	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Address getBillingAddress() {
		return BillingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		BillingAddress = billingAddress;
	}
*/	
	
	
	

}
