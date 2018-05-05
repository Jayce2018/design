package com.design.entity;

/**
 * Coupons entity. @author MyEclipse Persistence Tools
 */

public class Coupons implements java.io.Serializable {

	// Fields

	private Integer couponsid;
	private Integer type;
	private Integer amount;
	private String customerid;

	// Constructors

	/** default constructor */
	public Coupons() {
	}

	/** full constructor */
	public Coupons(Integer type, Integer amount, String customerid) {
		this.type = type;
		this.amount = amount;
		this.customerid = customerid;
	}

	// Property accessors

	public Integer getCouponsid() {
		return this.couponsid;
	}

	public void setCouponsid(Integer couponsid) {
		this.couponsid = couponsid;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

}