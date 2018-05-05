package com.design.entity;

import java.util.Date;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Qn_quota implements java.io.Serializable {

	// Fields

	private Integer qnid;
	private String qnname;
	private Integer typeid;
	private String createrid;
	private Date createdate;
	private Date endingdate;

	// Constructors

	/** default constructor */
	public Qn_quota() {
	}

	/** full constructor */
	public Qn_quota(String qnname, Integer typeid, String createrid,
			Date createdate) {
		this.qnname = qnname;
		this.typeid = typeid;
		this.createrid = createrid;
		this.createdate = createdate;
	}

	// Property accessors

	public Integer getQnid() {
		return this.qnid;
	}

	public Date getEndingdate() {
		return endingdate;
	}

	public void setEndingdate(Date endingdate) {
		this.endingdate = endingdate;
	}

	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}

	public String getQnname() {
		return this.qnname;
	}

	public void setQnname(String qnname) {
		this.qnname = qnname;
	}

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getCreaterid() {
		return this.createrid;
	}

	public void setCreaterid(String createrid) {
		this.createrid = createrid;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}