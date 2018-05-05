package com.design.entity;

/**
 * Types entity. @author MyEclipse Persistence Tools
 */

public class Types implements java.io.Serializable {

	// Fields

	private Integer typeid;
	private String typecontent;

	// Constructors

	/** default constructor */
	public Types() {
	}

	/** full constructor */
	public Types(Integer typeid, String typecontent) {
		this.typeid = typeid;
		this.typecontent = typecontent;
	}

	// Property accessors

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypecontent() {
		return this.typecontent;
	}

	public void setTypecontent(String typecontent) {
		this.typecontent = typecontent;
	}

}