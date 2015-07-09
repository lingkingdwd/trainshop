package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminMessage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin_message", catalog = "trainshop")
public class AdminMessage implements java.io.Serializable {

	// Fields

	private Short messageId;
	private Short senderId;
	private Short receiverId;
	private Integer sentTime;
	private Integer readTime;
	private Boolean readed;
	private Boolean deleted;
	private String title;
	private String message;

	// Constructors

	/** default constructor */
	public AdminMessage() {
	}

	/** full constructor */
	public AdminMessage(Short senderId, Short receiverId, Integer sentTime,
			Integer readTime, Boolean readed, Boolean deleted, String title,
			String message) {
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.sentTime = sentTime;
		this.readTime = readTime;
		this.readed = readed;
		this.deleted = deleted;
		this.title = title;
		this.message = message;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "message_id", unique = true, nullable = false)
	public Short getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Short messageId) {
		this.messageId = messageId;
	}

	@Column(name = "sender_id", nullable = false)
	public Short getSenderId() {
		return this.senderId;
	}

	public void setSenderId(Short senderId) {
		this.senderId = senderId;
	}

	@Column(name = "receiver_id", nullable = false)
	public Short getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(Short receiverId) {
		this.receiverId = receiverId;
	}

	@Column(name = "sent_time", nullable = false)
	public Integer getSentTime() {
		return this.sentTime;
	}

	public void setSentTime(Integer sentTime) {
		this.sentTime = sentTime;
	}

	@Column(name = "read_time", nullable = false)
	public Integer getReadTime() {
		return this.readTime;
	}

	public void setReadTime(Integer readTime) {
		this.readTime = readTime;
	}

	@Column(name = "readed", nullable = false)
	public Boolean getReaded() {
		return this.readed;
	}

	public void setReaded(Boolean readed) {
		this.readed = readed;
	}

	@Column(name = "deleted", nullable = false)
	public Boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	@Column(name = "title", nullable = false, length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "message", nullable = false, length = 65535)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}