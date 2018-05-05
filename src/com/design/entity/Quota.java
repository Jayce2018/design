package com.design.entity;

import java.util.Date;

/**
 * Quota entity. @author MyEclipse Persistence Tools
 */

public class Quota implements java.io.Serializable {

	// Fields

	private Integer qnid;
	private Date enddate;
	private Integer couponsid;

	// Constructors

	/** default constructor */
	public Quota() {
	}

	/** full constructor */
	public Quota(Integer qnid, Date enddate, Integer couponsid) {
		this.qnid = qnid;
		this.enddate = enddate;
		this.couponsid = couponsid;
	}

	// Property accessors

	public Integer getQnid() {
		return this.qnid;
	}

	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Integer getCouponsid() {
		return this.couponsid;
	}

	public void setCouponsid(Integer couponsid) {
		this.couponsid = couponsid;
	}

}