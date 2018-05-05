package com.design.entity;

import java.util.Date;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Get_coupons implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer couponsid;
	private Date finaldata;
	private Integer type;
	private Integer amount;
	private String name;
	private String storeurl;

	// Constructors

	/** default constructor */
	public Get_coupons() {
	}

	public Integer getCouponsid() {
		return couponsid;
	}

	public void setCouponsid(Integer couponsid) {
		this.couponsid = couponsid;
	}

	public Date getFinaldata() {
		return finaldata;
	}

	public void setFinaldata(Date finaldata) {
		this.finaldata = finaldata;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStoreurl() {
		return storeurl;
	}

	public void setStoreurl(String storeurl) {
		this.storeurl = storeurl;
	}

	

}