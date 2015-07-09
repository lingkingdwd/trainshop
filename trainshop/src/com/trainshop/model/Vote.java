package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vote entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vote", catalog = "trainshop")
public class Vote implements java.io.Serializable {

	// Fields

	private Short voteId;
	private String voteName;
	private Integer startTime;
	private Integer endTime;
	private Boolean canMulti;
	private Integer voteCount;

	// Constructors

	/** default constructor */
	public Vote() {
	}

	/** full constructor */
	public Vote(String voteName, Integer startTime, Integer endTime,
			Boolean canMulti, Integer voteCount) {
		this.voteName = voteName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.canMulti = canMulti;
		this.voteCount = voteCount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "vote_id", unique = true, nullable = false)
	public Short getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Short voteId) {
		this.voteId = voteId;
	}

	@Column(name = "vote_name", nullable = false, length = 250)
	public String getVoteName() {
		return this.voteName;
	}

	public void setVoteName(String voteName) {
		this.voteName = voteName;
	}

	@Column(name = "start_time", nullable = false)
	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Column(name = "can_multi", nullable = false)
	public Boolean getCanMulti() {
		return this.canMulti;
	}

	public void setCanMulti(Boolean canMulti) {
		this.canMulti = canMulti;
	}

	@Column(name = "vote_count", nullable = false)
	public Integer getVoteCount() {
		return this.voteCount;
	}

	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}

}