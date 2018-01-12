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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long categoryId;
	private String categoryName;
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategoryKey", cascade = CascadeType.ALL)
    @ElementCollection
	private Set<ProductCategoryMapping> productCategoryMapping  = new HashSet<>();
	*/
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="categories")
	private Set<Product> products;
	
	public Category() {
		
	}
	
	public Category(long categoryId, String categoryName) {
		this.products= new HashSet<>();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
	@Column(name="CATEGORY_ID")
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name="CATEGORY_NAME")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}	
	
	

	
}
