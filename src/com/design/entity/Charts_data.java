package com.design.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * Coupons entity. @author MyEclipse Persistence Tools
 */

public class Charts_data implements java.io.Serializable {

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String content;
	private BigInteger num;
	// Constructors

	/** default constructor */
	public Charts_data() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigInteger getNum() {
		return num;
	}

	public void setNum(BigInteger num) {
		this.num = num;
	}	

	
}