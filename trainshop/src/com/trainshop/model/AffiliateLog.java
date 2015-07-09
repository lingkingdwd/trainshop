package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AffiliateLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "affiliate_log", catalog = "trainshop")
public class AffiliateLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Integer orderId;
	private Integer time;
	private Integer userId;
	private String userName;
	private Double money;
	private Integer point;
	private Boolean separateType;

	// Constructors

	/** default constructor */
	public AffiliateLog() {
	}

	/** minimal constructor */
	public AffiliateLog(Integer orderId, Integer time, Integer userId,
			Double money, Integer point, Boolean separateType) {
		this.orderId = orderId;
		this.time = time;
		this.userId = userId;
		this.money = money;
		this.point = point;
		this.separateType = separateType;
	}

	/** full constructor */
	public AffiliateLog(Integer orderId, Integer time, Integer userId,
			String userName, Double money, Integer point, Boolean separateType) {
		this.orderId = orderId;
		this.time = time;
		this.userId = userId;
		this.userName = userName;
		this.money = money;
		this.point = point;
		this.separateType = separateType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "log_id", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "time", nullable = false)
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "money", nullable = false, precision = 10)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	@Column(name = "point", nullable = false)
	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Column(name = "separate_type", nullable = false)
	public Boolean getSeparateType() {
		return this.separateType;
	}

	public void setSeparateType(Boolean separateType) {
		this.separateType = separateType;
	}

}