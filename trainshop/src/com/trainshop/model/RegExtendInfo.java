package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RegExtendInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reg_extend_info", catalog = "trainshop")
public class RegExtendInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer regFieldId;
	private String content;

	// Constructors

	/** default constructor */
	public RegExtendInfo() {
	}

	/** full constructor */
	public RegExtendInfo(Integer userId, Integer regFieldId, String content) {
		this.userId = userId;
		this.regFieldId = regFieldId;
		this.content = content;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "reg_field_id", nullable = false)
	public Integer getRegFieldId() {
		return this.regFieldId;
	}

	public void setRegFieldId(Integer regFieldId) {
		this.regFieldId = regFieldId;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}