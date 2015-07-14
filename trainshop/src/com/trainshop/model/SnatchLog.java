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

	private Long logId;
	private Long snatchId;
	private Long userId;
	private Double bidPrice;
	private Long bidTime;

	// Constructors

	/** default constructor */
	public SnatchLog() {
	}

	/** full constructor */
	public SnatchLog(Long snatchId, Long userId, Double bidPrice, Long bidTime) {
		this.snatchId = snatchId;
		this.userId = userId;
		this.bidPrice = bidPrice;
		this.bidTime = bidTime;
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

	@Column(name = "snatch_id", nullable = false)
	public Long getSnatchId() {
		return this.snatchId;
	}

	public void setSnatchId(Long snatchId) {
		this.snatchId = snatchId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
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
	public Long getBidTime() {
		return this.bidTime;
	}

	public void setBidTime(Long bidTime) {
		this.bidTime = bidTime;
	}

}