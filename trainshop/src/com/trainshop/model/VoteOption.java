package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VoteOption entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "vote_option", catalog = "trainshop")
public class VoteOption implements java.io.Serializable {

	// Fields

	private Short optionId;
	private Short voteId;
	private String optionName;
	private Integer optionCount;
	private Short optionOrder;

	// Constructors

	/** default constructor */
	public VoteOption() {
	}

	/** full constructor */
	public VoteOption(Short voteId, String optionName, Integer optionCount,
			Short optionOrder) {
		this.voteId = voteId;
		this.optionName = optionName;
		this.optionCount = optionCount;
		this.optionOrder = optionOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "option_id", unique = true, nullable = false)
	public Short getOptionId() {
		return this.optionId;
	}

	public void setOptionId(Short optionId) {
		this.optionId = optionId;
	}

	@Column(name = "vote_id", nullable = false)
	public Short getVoteId() {
		return this.voteId;
	}

	public void setVoteId(Short voteId) {
		this.voteId = voteId;
	}

	@Column(name = "option_name", nullable = false, length = 250)
	public String getOptionName() {
		return this.optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	@Column(name = "option_count", nullable = false)
	public Integer getOptionCount() {
		return this.optionCount;
	}

	public void setOptionCount(Integer optionCount) {
		this.optionCount = optionCount;
	}

	@Column(name = "option_order", nullable = false)
	public Short getOptionOrder() {
		return this.optionOrder;
	}

	public void setOptionOrder(Short optionOrder) {
		this.optionOrder = optionOrder;
	}

}