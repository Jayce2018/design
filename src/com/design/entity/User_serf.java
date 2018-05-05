package com.design.entity;

import java.util.Date;

/**
 * Coupons entity. @author MyEclipse Persistence Tools
 */

public class User_serf implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer qnid;
	private String qnname;
	private String typecontent;
	private String storename;
	private Date endingdate;

	// Constructors

	/** default constructor */
	public User_serf() {
	}

	
	public Integer getQnid() {
		return qnid;
	}

	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}

	public String getQnname() {
		return qnname;
	}

	public void setQnname(String qnname) {
		this.qnname = qnname;
	}

	public String getTypecontent() {
		return typecontent;
	}

	public void setTypecontent(String typecontent) {
		this.typecontent = typecontent;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public Date getEndingdate() {
		return endingdate;
	}

	public void setEndingdate(Date endingdate) {
		this.endingdate = endingdate;
	}

	

	
}