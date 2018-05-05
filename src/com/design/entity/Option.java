package com.design.entity;

/**
 * Option entity. @author MyEclipse Persistence Tools
 */

public class Option implements java.io.Serializable {

	// Fields

	private Integer optionid;
	private String content;
	private Integer topicid;
	private String orderid;

	// Constructors

	/** default constructor */
	public Option() {
	}

	/** full constructor */
	public Option(String content, Integer topicid, String orderid) {
		this.content = content;
		this.topicid = topicid;
		this.orderid = orderid;
	}

	// Property accessors

	public Integer getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTopicid() {
		return this.topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

}