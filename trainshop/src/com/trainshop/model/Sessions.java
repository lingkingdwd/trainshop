package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Sessions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sessions", catalog = "trainshop")
public class Sessions implements java.io.Serializable {

	// Fields

	private String sesskey;
	private Integer expiry;
	private Long userid;
	private Long adminid;
	private String ip;
	private String userName;
	private Short userRank;
	private Double discount;
	private String email;
	private String data;

	// Constructors

	/** default constructor */
	public Sessions() {
	}

	/** full constructor */
	public Sessions(String sesskey, Integer expiry, Long userid, Long adminid,
			String ip, String userName, Short userRank, Double discount,
			String email, String data) {
		this.sesskey = sesskey;
		this.expiry = expiry;
		this.userid = userid;
		this.adminid = adminid;
		this.ip = ip;
		this.userName = userName;
		this.userRank = userRank;
		this.discount = discount;
		this.email = email;
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

	@Column(name = "userid", nullable = false)
	public Long getUserid() {
		return this.userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name = "adminid", nullable = false)
	public Long getAdminid() {
		return this.adminid;
	}

	public void setAdminid(Long adminid) {
		this.adminid = adminid;
	}

	@Column(name = "ip", nullable = false, length = 15)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_rank", nullable = false)
	public Short getUserRank() {
		return this.userRank;
	}

	public void setUserRank(Short userRank) {
		this.userRank = userRank;
	}

	@Column(name = "discount", nullable = false, precision = 3)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "data", nullable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

}