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

	private Long logId;
	private Long voteId;
	private String ipAddress;
	private Long voteTime;

	// Constructors

	/** default constructor */
	public VoteLog() {
	}

	/** full constructor */
	public VoteLog(Long voteId, String ipAddress, Long voteTime) {
		this.voteId = voteId;
		this.ipAddress = ipAddress;
		this.voteTime = voteTime;
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

	@Column(name = "vote_id", nullable = false)
	public Long getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Long voteId) {
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
	public Long getVoteTime() {
		return this.voteTime;
	}

	public void setVoteTime(Long voteTime) {
		this.voteTime = voteTime;
	}

}