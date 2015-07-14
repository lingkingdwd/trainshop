package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrderAction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_action", catalog = "trainshop")
public class OrderAction implements java.io.Serializable {

	// Fields

	private Long actionId;
	private Long orderId;
	private String actionUser;
	private Boolean orderStatus;
	private Boolean shippingStatus;
	private Boolean payStatus;
	private Boolean actionPlace;
	private String actionNote;
	private Long logTime;

	// Constructors

	/** default constructor */
	public OrderAction() {
	}

	/** full constructor */
	public OrderAction(Long orderId, String actionUser, Boolean orderStatus,
			Boolean shippingStatus, Boolean payStatus, Boolean actionPlace,
			String actionNote, Long logTime) {
		this.orderId = orderId;
		this.actionUser = actionUser;
		this.orderStatus = orderStatus;
		this.shippingStatus = shippingStatus;
		this.payStatus = payStatus;
		this.actionPlace = actionPlace;
		this.actionNote = actionNote;
		this.logTime = logTime;
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

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "action_user", nullable = false, length = 30)
	public String getActionUser() {
		return this.actionUser;
	}

	public void setActionUser(String actionUser) {
		this.actionUser = actionUser;
	}

	@Column(name = "order_status", nullable = false)
	public Boolean getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "shipping_status", nullable = false)
	public Boolean getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(Boolean shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Column(name = "pay_status", nullable = false)
	public Boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Boolean payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "action_place", nullable = false)
	public Boolean getActionPlace() {
		return this.actionPlace;
	}

	public void setActionPlace(Boolean actionPlace) {
		this.actionPlace = actionPlace;
	}

	@Column(name = "action_note", nullable = false)
	public String getActionNote() {
		return this.actionNote;
	}

	public void setActionNote(String actionNote) {
		this.actionNote = actionNote;
	}

	@Column(name = "log_time", nullable = false)
	public Long getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Long logTime) {
		this.logTime = logTime;
	}

}