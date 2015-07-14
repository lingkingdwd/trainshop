package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin_action", catalog = "trainshop")
public class AdminAction implements java.io.Serializable {

	// Fields

	private Long actionId;
	private Integer parentId;
	private String actionCode;
	private String relevance;

	// Constructors

	/** default constructor */
	public AdminAction() {
	}

	/** full constructor */
	public AdminAction(Integer parentId, String actionCode, String relevance) {
		this.parentId = parentId;
		this.actionCode = actionCode;
		this.relevance = relevance;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "action_id", unique = true, nullable = false)
	public Long getActionId() {
		return this.actionId;
	}

	public void setActionId(Long actionId) {
		this.actionId = actionId;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "action_code", nullable = false, length = 20)
	public String getActionCode() {
		return this.actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

	@Column(name = "relevance", nullable = false, length = 20)
	public String getRelevance() {
		return this.relevance;
	}

	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}

}