package com.design.entity;

import java.util.Date;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Questionnaire implements java.io.Serializable {

	// Fields

	private Integer qnid;
	private String qnname;
	private Integer typeid;
	private String createrid;
	private Date createdate;

	// Constructors

	/** default constructor */
	public Questionnaire() {
	}

	/** full constructor */
	public Questionnaire(String qnname, Integer typeid, String createrid,
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