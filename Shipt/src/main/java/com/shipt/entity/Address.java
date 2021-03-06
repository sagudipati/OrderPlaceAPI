package com.shipt.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String city;
	private String state;
	private String zipcode;
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	

}
