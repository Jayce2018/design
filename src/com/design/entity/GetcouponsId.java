package com.design.entity;

import java.util.Date;

/**
 * GetcouponsId entity. @author MyEclipse Persistence Tools
 */

public class GetcouponsId implements java.io.Serializable {

	// Fields

	private String userid;
	private Integer couponsid;
	private Date finaldate;

	// Constructors

	/** default constructor */
	public GetcouponsId() {
	}

	/** full constructor */
	public GetcouponsId(String userid, Integer couponsid, Date finaldate) {
		this.userid = userid;
		this.couponsid = couponsid;
		this.finaldate = finaldate;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Integer getCouponsid() {
		return this.couponsid;
	}

	public void setCouponsid(Integer couponsid) {
		this.couponsid = couponsid;
	}

	public Date getFinaldate() {
		return this.finaldate;
	}

	public void setFinaldate(Date finaldate) {
		this.finaldate = finaldate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GetcouponsId))
			return false;
		GetcouponsId castOther = (GetcouponsId) other;

		return ((this.getUserid() == castOther.getUserid()) || (this
				.getUserid() != null && castOther.getUserid() != null && this
				.getUserid().equals(castOther.getUserid())))
				&& ((this.getCouponsid() == castOther.getCouponsid()) || (this
						.getCouponsid() != null
						&& castOther.getCouponsid() != null && this
						.getCouponsid().equals(castOther.getCouponsid())))
				&& ((this.getFinaldate() == castOther.getFinaldate()) || (this
						.getFinaldate() != null
						&& castOther.getFinaldate() != null && this
						.getFinaldate().equals(castOther.getFinaldate())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserid() == null ? 0 : this.getUserid().hashCode());
		result = 37 * result
				+ (getCouponsid() == null ? 0 : this.getCouponsid().hashCode());
		result = 37 * result
				+ (getFinaldate() == null ? 0 : this.getFinaldate().hashCode());
		return result;
	}

}