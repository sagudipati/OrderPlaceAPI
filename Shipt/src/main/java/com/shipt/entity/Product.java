package com.shipt.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	private long productId;
	private String productName;
	private Double price;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategoryKey", cascade = CascadeType.ALL)
	@ElementCollection
	private Set<ProductCategoryMapping> productCategoryMapping = new HashSet<>();
	*/
	
	@ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinTable(name="product_category",
				joinColumns= @JoinColumn(name="product_id"), 
				inverseJoinColumns = @JoinColumn(name="category_id"))
	private Set<Category> categories;
	
	public Product() {
		
	}
	
	public Product(long productId, String productName, double price) {
		this.categories= new HashSet<>();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	
	@Column(name="PRODUCT_ID")
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	@Column(name="PRODUCT_NAME")
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	/*public Set<ProductCategoryMapping> getProductCategoryMapping() {
		return productCategoryMapping;
	}
	public void setProductCategoryMapping(Set<ProductCategoryMapping> productCategoryMapping) {
		this.productCategoryMapping = productCategoryMapping;
	}*/
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	

}
