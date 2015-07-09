package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VoteLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vote_log", catalog = "trainshop")
public class VoteLog implements java.io.Serializable {

	// Fields

	private Integer logId;
	private Short voteId;
	private String ipAddress;
	private Integer voteTime;

	// Constructors

	/** default constructor */
	public VoteLog() {
	}

	/** full constructor */
	public VoteLog(Short voteId, String ipAddress, Integer voteTime) {
		this.voteId = voteId;
		this.ipAddress = ipAddress;
		this.voteTime = voteTime;
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

	@Column(name = "vote_id", nullable = false)
	public Short getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Short voteId) {
		this.voteId = voteId;
	}

	@Column(name = "ip_address", nullable = false, length = 15)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "vote_time", nullable = false)
	public Integer getVoteTime() {
		return this.voteTime;
	}

	public void setVoteTime(Integer voteTime) {
		this.voteTime = voteTime;
	}

}