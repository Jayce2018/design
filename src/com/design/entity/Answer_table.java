package com.design.entity;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer_table implements java.io.Serializable {

	private Integer qnid;
	private String qnname;
	private Integer topicid;
	private String tocontent;
	private Integer toorderid;
	private Integer optionid;
	private String opcontent;
	private String oporderid;
	
	/** default constructor */
	public Answer_table() {
	}
	
	public Integer getQnid() {
		return qnid;
	}
	public void setQnid(Integer qnid) {
		this.qnid = qnid;
	}
	public String getQnname() {
		return qnname;
	}
	public void setQnname(String qnname) {
		this.qnname = qnname;
	}
	public Integer getTopicid() {
		return topicid;
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
	public void setToorderid(Integer objs) {
		this.toorderid = objs;
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
	public String getOporderid() {
		return oporderid;
	}
	public void setOporderid(String oporderid) {
		this.oporderid = oporderid;
	}
	
	

}