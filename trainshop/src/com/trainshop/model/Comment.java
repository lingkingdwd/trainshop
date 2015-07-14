package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "trainshop")
public class Comment implements java.io.Serializable {

	// Fields

	private Long commentId;
	private Integer commentType;
	private Integer idValue;
	private String email;
	private String userName;
	private String content;
	private Integer commentRank;
	private Long addTime;
	private String ipAddress;
	private Integer status;
	private Long parentId;
	private Long userId;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(Integer commentType, Integer idValue, String email,
			String userName, String content, Integer commentRank, Long addTime,
			String ipAddress, Integer status, Long parentId, Long userId) {
		this.commentType = commentType;
		this.idValue = idValue;
		this.email = email;
		this.userName = userName;
		this.content = content;
		this.commentRank = commentRank;
		this.addTime = addTime;
		this.ipAddress = ipAddress;
		this.status = status;
		this.parentId = parentId;
		this.userId = userId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "comment_id", unique = true, nullable = false)
	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@Column(name = "comment_type", nullable = false)
	public Integer getCommentType() {
		return this.commentType;
	}

	public void setCommentType(Integer commentType) {
		this.commentType = commentType;
	}

	@Column(name = "id_value", nullable = false)
	public Integer getIdValue() {
		return this.idValue;
	}

	public void setIdValue(Integer idValue) {
		this.idValue = idValue;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "comment_rank", nullable = false)
	public Integer getCommentRank() {
		return this.commentRank;
	}

	public void setCommentRank(Integer commentRank) {
		this.commentRank = commentRank;
	}

	@Column(name = "add_time", nullable = false)
	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	@Column(name = "ip_address", nullable = false, length = 15)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "parent_id", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}