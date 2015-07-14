package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "feedback", catalog = "trainshop")
public class Feedback implements java.io.Serializable {

	// Fields

	private Long msgId;
	private Integer parentId;
	private Integer userId;
	private String userName;
	private String userEmail;
	private String msgTitle;
	private Boolean msgType;
	private Boolean msgStatus;
	private String msgContent;
	private Integer msgTime;
	private String messageImg;
	private Integer orderId;
	private Boolean msgArea;

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(Integer parentId, Integer userId, String userName,
			String userEmail, String msgTitle, Boolean msgType,
			Boolean msgStatus, String msgContent, Integer msgTime,
			String messageImg, Integer orderId, Boolean msgArea) {
		this.parentId = parentId;
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.msgTitle = msgTitle;
		this.msgType = msgType;
		this.msgStatus = msgStatus;
		this.msgContent = msgContent;
		this.msgTime = msgTime;
		this.messageImg = messageImg;
		this.orderId = orderId;
		this.msgArea = msgArea;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "msg_id", unique = true, nullable = false)
	public Long getMsgId() {
		return this.msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_email", nullable = false, length = 60)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "msg_title", nullable = false, length = 200)
	public String getMsgTitle() {
		return this.msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	@Column(name = "msg_type", nullable = false)
	public Boolean getMsgType() {
		return this.msgType;
	}

	public void setMsgType(Boolean msgType) {
		this.msgType = msgType;
	}

	@Column(name = "msg_status", nullable = false)
	public Boolean getMsgStatus() {
		return this.msgStatus;
	}

	public void setMsgStatus(Boolean msgStatus) {
		this.msgStatus = msgStatus;
	}

	@Column(name = "msg_content", nullable = false, length = 65535)
	public String getMsgContent() {
		return this.msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	@Column(name = "msg_time", nullable = false)
	public Integer getMsgTime() {
		return this.msgTime;
	}

	public void setMsgTime(Integer msgTime) {
		this.msgTime = msgTime;
	}

	@Column(name = "message_img", nullable = false)
	public String getMessageImg() {
		return this.messageImg;
	}

	public void setMessageImg(String messageImg) {
		this.messageImg = messageImg;
	}

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "msg_area", nullable = false)
	public Boolean getMsgArea() {
		return this.msgArea;
	}

	public void setMsgArea(Boolean msgArea) {
		this.msgArea = msgArea;
	}

}