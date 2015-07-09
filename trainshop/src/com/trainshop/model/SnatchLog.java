package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SnatchLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "snatch_log", catalog = "trainshop")
public class SnatchLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Short snatchId;
	private Integer userId;
	private Double bidPrice;
	private Integer bidTime;

	// Constructors

	/** default constructor */
	public SnatchLog() {
	}

	/** full constructor */
	public SnatchLog(Short snatchId, Integer userId, Double bidPrice,
			Integer bidTime) {
		this.snatchId = snatchId;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
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

	@Column(name = "snatch_id", nullable = false)
	public Short getSnatchId() {
		return this.snatchId;
	}

	public void setSnatchId(Short snatchId) {
		this.snatchId = snatchId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "bid_price", nullable = false, precision = 10)
	public Double getBidPrice() {
		return this.bidPrice;
	}

	public void setBidPrice(Double bidPrice) {
		this.bidPrice = bidPrice;
	}

	@Column(name = "bid_time", nullable = false)
	public Integer getBidTime() {
		return this.bidTime;
	}

	public void setBidTime(Integer bidTime) {
		this.bidTime = bidTime;
	}

}