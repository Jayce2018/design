package com.design.entity;

import java.util.Date;

/**
 * Questionnaire entity. @author MyEclipse Persistence Tools
 */

public class Qn_topic_option_Union implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer qnid;
	private String qnname;
	private Integer typeid;
	private String createrid;
	private Date createdate;
	
	private Integer topicid;
	private String tocontent;
	private Integer toorderid;
	private Integer optionid;
	private String opcontent;
	private Integer oporderid;
	private Integer tixing;

	// Constructors
	
	public Integer getTopicid() {
		return topicid;
	}

	public Integer getTixing() {
		return tixing;
	}

	public void setTixing(Integer tixing) {
		this.tixing = tixing;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
	}

	public String getTocontent() {
		return tocontent;
	}

	public void setTocontent(String tocontent) {
		this.tocontent = tocontent;
	}

	public Integer getToorderid() {
		return toorderid;
	}

	public void setToorderid(Integer toorderid) {
		this.toorderid = toorderid;
	}

	public Integer getOptionid() {
		return optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public String getOpcontent() {
		return opcontent;
	}

	public void setOpcontent(String opcontent) {
		this.opcontent = opcontent;
	}

	public Integer getOporderid() {
		return oporderid;
	}

	public void setOporderid(Integer objs) {
		this.oporderid = objs;
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
	
	/** full constructor */
	public Qn_topic_option_Union(Integer qnid,String qnname, Integer typeid, String createrid,
			Date createdate,Integer topicid,String tocontent,Integer toorderid,Integer optionid,String opcontent,Integer oporderid) {
		this.qnid=qnid;
		this.qnname = qnname;
		this.typeid = typeid;
		this.createrid = createrid;
		this.createdate = createdate;
		this.topicid=topicid;
		this.tocontent=tocontent;
		this.toorderid=toorderid;
		this.optionid=optionid;
		this.opcontent=opcontent;
		this.oporderid=oporderid;
	}
	
	public Qn_topic_option_Union(){}

}