package com.LoanManagementSystem.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="UserId")
	private int user_id;
	

	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Overall_limit")
	private String overalllimit;
	
	@Column(name="Utilized_limit")
	private String utilizedlimit;
	
	@Column(name="Available_limit")
	private String availablelimit;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOveralllimit() {
		return overalllimit;
	}

	public void setOveralllimit(String overalllimit) {
		this.overalllimit = overalllimit;
	}

	public String getUtilizedlimit() {
		return utilizedlimit;
	}

	public void setUtilizedlimit(String utilizedlimit) {
		this.utilizedlimit = utilizedlimit;
	}

	public String getAvailablelimit() {
		return availablelimit;
	}

	public void setAvailablelimit(String availablelimit) {
		this.availablelimit = availablelimit;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phone=" + phone + ", overalllimit=" + overalllimit
				+ ", utilizedlimit=" + utilizedlimit + ", availablelimit=" + availablelimit + "]";
	}

	public User(String name, String email, String phone, String overalllimit, String utilizedlimit,
			String availablelimit) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.overalllimit = overalllimit;
		this.utilizedlimit = utilizedlimit;
		this.availablelimit = availablelimit;
	}
	
	public User() {
	}

}
