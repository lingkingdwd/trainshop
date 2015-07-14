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

	private Long messageId;
	private Integer senderId;
	private Integer receiverId;
	private Long sentTime;
	private Long readTime;
	private Integer readed;
	private Integer deleted;
	private String title;
	private String message;

	// Constructors

	/** default constructor */
	public AdminMessage() {
	}

	/** full constructor */
	public AdminMessage(Integer senderId, Integer receiverId, Long sentTime,
			Long readTime, Integer readed, Integer deleted, String title,
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
	public Long getMessageId() {
		return this.messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	@Column(name = "sender_id", nullable = false)
	public Integer getSenderId() {
		return this.senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	@Column(name = "receiver_id", nullable = false)
	public Integer getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(Integer receiverId) {
		this.receiverId = receiverId;
	}

	@Column(name = "sent_time", nullable = false)
	public Long getSentTime() {
		return this.sentTime;
	}

	public void setSentTime(Long sentTime) {
		this.sentTime = sentTime;
	}

	@Column(name = "read_time", nullable = false)
	public Long getReadTime() {
		return this.readTime;
	}

	public void setReadTime(Long readTime) {
		this.readTime = readTime;
	}

	@Column(name = "readed", nullable = false)
	public Integer getReaded() {
		return this.readed;
	}

	public void setReaded(Integer readed) {
		this.readed = readed;
	}

	@Column(name = "deleted", nullable = false)
	public Integer getDeleted() {
		return this.deleted;
	}

	public void setDeleted(Integer deleted) {
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