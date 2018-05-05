package com.design.entity;

/**
 * Customers entity. @author MyEclipse Persistence Tools
 */

public class Customers implements java.io.Serializable {

	// Fields

	private String customerid;
	private String name;
	private String managername;
	private String phone;
	private String mail;
	private String storeurl;

	// Constructors

	/** default constructor */
	public Customers() {
	}

	/** full constructor */
	public Customers(String customerid, String name, String managername,
			String phone, String mail, String storeurl) {
		this.customerid = customerid;
		this.name = name;
		this.managername = managername;
		this.phone = phone;
		this.mail = mail;
		this.storeurl = storeurl;
	}

	// Property accessors

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagername() {
		return this.managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getStoreurl() {
		return this.storeurl;
	}

	public void setStoreurl(String storeurl) {
		this.storeurl = storeurl;
	}

}