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

	private Long logId;
	private Long orderId;
	private Long time;
	private Long userId;
	private String userName;
	private Double money;
	private Integer point;
	private Integer separateType;

	// Constructors

	/** default constructor */
	public AffiliateLog() {
	}

	/** minimal constructor */
	public AffiliateLog(Long orderId, Long time, Long userId, Double money,
			Integer point, Integer separateType) {
		this.orderId = orderId;
		this.time = time;
		this.userId = userId;
		this.money = money;
		this.point = point;
		this.separateType = separateType;
	}

	/** full constructor */
	public AffiliateLog(Long orderId, Long time, Long userId, String userName,
			Double money, Integer point, Integer separateType) {
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
	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "time", nullable = false)
	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
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
	public Integer getSeparateType() {
		return this.separateType;
	}

	public void setSeparateType(Integer separateType) {
		this.separateType = separateType;
	}

}