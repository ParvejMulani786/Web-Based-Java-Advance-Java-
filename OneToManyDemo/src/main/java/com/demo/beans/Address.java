package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address22")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aid;
	private String street;
	private String city;
	private String state;
	//here we assume one address can have only one user;
	//here we make foreign key (u_uid) references user22 (uid)
     
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private User u;//it contains object of USer Class;
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address( String street, String city, String state, User u) {
		super();
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.u = u;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
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
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	@Override
	public String toString() {
		return "Address [aid=" + aid + ", street=" + street + ", city=" + city + ", state=" + state + "user:"+u+"]";
	}
	
	
	
	

}
