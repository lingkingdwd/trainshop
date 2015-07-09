package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserAccount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_account", catalog = "trainshop")
public class UserAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String adminUser;
	private Double amount;
	private Integer addTime;
	private Integer paidTime;
	private String adminNote;
	private String userNote;
	private Boolean processType;
	private String payment;
	private Boolean isPaid;

	// Constructors

	/** default constructor */
	public UserAccount() {
	}

	/** full constructor */
	public UserAccount(Integer userId, String adminUser, Double amount,
			Integer addTime, Integer paidTime, String adminNote,
			String userNote, Boolean processType, String payment, Boolean isPaid) {
		this.userId = userId;
		this.adminUser = adminUser;
		this.amount = amount;
		this.addTime = addTime;
		this.paidTime = paidTime;
		this.adminNote = adminNote;
		this.userNote = userNote;
		this.processType = processType;
		this.payment = payment;
		this.isPaid = isPaid;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
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

	@Column(name = "admin_user", nullable = false)
	public String getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	@Column(name = "amount", nullable = false, precision = 10)
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "paid_time", nullable = false)
	public Integer getPaidTime() {
		return this.paidTime;
	}

	public void setPaidTime(Integer paidTime) {
		this.paidTime = paidTime;
	}

	@Column(name = "admin_note", nullable = false)
	public String getAdminNote() {
		return this.adminNote;
	}

	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}

	@Column(name = "user_note", nullable = false)
	public String getUserNote() {
		return this.userNote;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	@Column(name = "process_type", nullable = false)
	public Boolean getProcessType() {
		return this.processType;
	}

	public void setProcessType(Boolean processType) {
		this.processType = processType;
	}

	@Column(name = "payment", nullable = false, length = 90)
	public String getPayment() {
		return this.payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Column(name = "is_paid", nullable = false)
	public Boolean getIsPaid() {
		return this.isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

}