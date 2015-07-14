package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin_log", catalog = "trainshop")
public class AdminLog implements java.io.Serializable {

	// Fields

	private Long logId;
	private Long logTime;
	private Integer userId;
	private String logInfo;
	private String ipAddress;

	// Constructors

	/** default constructor */
	public AdminLog() {
	}

	/** full constructor */
	public AdminLog(Long logTime, Integer userId, String logInfo,
			String ipAddress) {
		this.logTime = logTime;
		this.userId = userId;
		this.logInfo = logInfo;
		this.ipAddress = ipAddress;
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

	@Column(name = "log_time", nullable = false)
	public Long getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Long logTime) {
		this.logTime = logTime;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "log_info", nullable = false)
	public String getLogInfo() {
		return this.logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	@Column(name = "ip_address", nullable = false, length = 15)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}