package com.design.entity;

/**
 * AnswerId entity. @author MyEclipse Persistence Tools
 */

public class AnswerId implements java.io.Serializable {

	// Fields

	private String userid;
	private Integer optionid;

	// Constructors

	/** default constructor */
	public AnswerId() {
	}

	/** full constructor */
	public AnswerId(String userid, Integer optionid) {
		this.userid = userid;
		this.optionid = optionid;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getOptionid() {
		return this.optionid;
	}

	public void setOptionid(Integer optionid) {
		this.optionid = optionid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AnswerId))
			return false;
		AnswerId castOther = (AnswerId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null && castOther.getUserid() != null && this
				.getUserid().equals(castOther.getUserid())))
				&& ((this.getOptionid() == castOther.getOptionid()) || (this
						.getOptionid() != null
						&& castOther.getOptionid() != null && this
						.getOptionid().equals(castOther.getOptionid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getOptionid() == null ? 0 : this.getOptionid().hashCode());
		return result;
	}

}