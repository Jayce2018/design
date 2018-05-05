package com.design.entity;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer implements java.io.Serializable {

	// Fields

	private AnswerId id;

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** full constructor */
	public Answer(AnswerId id) {
		this.id = id;
	}

	// Property accessors

	public AnswerId getId() {
		return this.id;
	}

	public void setId(AnswerId id) {
		this.id = id;
	}

}