package com.design.entity;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private String id;
	private String password;
	private String name;
	private String type;
	private String gender;
	private Date date;
	private Integer flag;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String id, String password, String name, String type,
			String gender) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
		this.gender = gender;
	}

	/** full constructor */
	public User(String id, String password, String name, String type,
			String gender, Date date, Integer flag) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.type = type;
		this.gender = gender;
		this.date = date;
		this.flag = flag;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

}