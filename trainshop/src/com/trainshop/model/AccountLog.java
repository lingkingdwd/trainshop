package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AccountLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "account_log", catalog = "trainshop")
public class AccountLog implements java.io.Serializable {

	// Fields

	private Long logId;
	private Long userId;
	private Double userMoney;
	private Double frozenMoney;
	private Integer rankPoints;
	private Integer payPoints;
	private Integer changeTime;
	private String changeDesc;
	private Integer changeType;

	// Constructors

	/** default constructor */
	public AccountLog() {
	}

	/** full constructor */
	public AccountLog(Long userId, Double userMoney, Double frozenMoney,
			Integer rankPoints, Integer payPoints, Integer changeTime,
			String changeDesc, Integer changeType) {
		this.userId = userId;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.rankPoints = rankPoints;
		this.payPoints = payPoints;
		this.changeTime = changeTime;
		this.changeDesc = changeDesc;
		this.changeType = changeType;
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

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "user_money", nullable = false, precision = 10)
	public Double getUserMoney() {
		return this.userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	@Column(name = "frozen_money", nullable = false, precision = 10)
	public Double getFrozenMoney() {
		return this.frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	@Column(name = "rank_points", nullable = false)
	public Integer getRankPoints() {
		return this.rankPoints;
	}

	public void setRankPoints(Integer rankPoints) {
		this.rankPoints = rankPoints;
	}

	@Column(name = "pay_points", nullable = false)
	public Integer getPayPoints() {
		return this.payPoints;
	}

	public void setPayPoints(Integer payPoints) {
		this.payPoints = payPoints;
	}

	@Column(name = "change_time", nullable = false)
	public Integer getChangeTime() {
		return this.changeTime;
	}

	public void setChangeTime(Integer changeTime) {
		this.changeTime = changeTime;
	}

	@Column(name = "change_desc", nullable = false)
	public String getChangeDesc() {
		return this.changeDesc;
	}

	public void setChangeDesc(String changeDesc) {
		this.changeDesc = changeDesc;
	}

	@Column(name = "change_type", nullable = false)
	public Integer getChangeType() {
		return this.changeType;
	}

	public void setChangeType(Integer changeType) {
		this.changeType = changeType;
	}

}