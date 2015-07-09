package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SessionsData entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sessions_data", catalog = "trainshop")
public class SessionsData implements java.io.Serializable {

	// Fields

	private String sesskey;
	private Integer expiry;
	private String data;

	// Constructors

	/** default constructor */
	public SessionsData() {
	}

	/** full constructor */
	public SessionsData(String sesskey, Integer expiry, String data) {
		this.sesskey = sesskey;
		this.expiry = expiry;
		this.data = data;
	}

	// Property accessors
	@Id
	@Column(name = "sesskey", unique = true, nullable = false, length = 32)
	public String getSesskey() {
		return this.sesskey;
	}

	public void setSesskey(String sesskey) {
		this.sesskey = sesskey;
	}

	@Column(name = "expiry", nullable = false)
	public Integer getExpiry() {
		return this.expiry;
	}

	public void setExpiry(Integer expiry) {
		this.expiry = expiry;
	}

	@Column(name = "data", nullable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

}