package com.design.entity;

/**
 * Getcoupons entity. @author MyEclipse Persistence Tools
 */

public class Getcoupons implements java.io.Serializable {

	// Fields

	private GetcouponsId id;

	// Constructors

	/** default constructor */
	public Getcoupons() {
	}

	/** full constructor */
	public Getcoupons(GetcouponsId id) {
		this.id = id;
	}

	// Property accessors

	public GetcouponsId getId() {
		return this.id;
	}

	public void setId(GetcouponsId id) {
		this.id = id;
	}

}