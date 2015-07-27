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
	private int orderStatus;
	private int shippingStatus;
	private int payStatus;
	private int actionPlace;
	private String actionNote;
	private Long logTime;

	// Constructors

	/** default constructor */
	public OrderAction() {
	}

	/** full constructor */
	public OrderAction(Long orderId, String actionUser, int orderStatus,
			int shippingStatus, int payStatus, int actionPlace,
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
	public int getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "shipping_status", nullable = false)
	public int getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(int shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Column(name = "pay_status", nullable = false)
	public int getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "action_place", nullable = false)
	public int getActionPlace() {
		return this.actionPlace;
	}

	public void setActionPlace(int actionPlace) {
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