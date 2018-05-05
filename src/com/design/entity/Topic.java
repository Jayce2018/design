package com.design.entity;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private Integer topicid;
	private String content;
	private Integer qnid;
	private Integer orderid;
	private Integer tixing;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(String content, Integer qnid, Integer orderid, Integer tixing) {
		this.content = content;
		this.qnid = qnid;
		this.orderid = orderid;
		this.tixing = tixing;
	}

	// Property accessors

	public Integer getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getQnid() {
		return this.qnid;
	}

	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}

	public Integer getOrderid() {
		return this.orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getTixing() {
		return this.tixing;
	}

	public void setTixing(Integer tixing) {
		this.tixing = tixing;
	}

}