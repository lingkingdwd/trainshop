package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Payment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "payment", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "pay_code"))
public class Payment implements java.io.Serializable {

	// Fields

	private Short payId;
	private String payCode;
	private String payName;
	private String payFee;
	private String payDesc;
	private Short payOrder;
	private String payConfig;
	private Boolean enabled;
	private Boolean isCod;
	private Boolean isOnline;

	// Constructors

	/** default constructor */
	public Payment() {
	}

	/** full constructor */
	public Payment(String payCode, String payName, String payFee,
			String payDesc, Short payOrder, String payConfig, Boolean enabled,
			Boolean isCod, Boolean isOnline) {
		this.payCode = payCode;
		this.payName = payName;
		this.payFee = payFee;
		this.payDesc = payDesc;
		this.payOrder = payOrder;
		this.payConfig = payConfig;
		this.enabled = enabled;
		this.isCod = isCod;
		this.isOnline = isOnline;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pay_id", unique = true, nullable = false)
	public Short getPayId() {
		return this.payId;
	}

	public void setPayId(Short payId) {
		this.payId = payId;
	}

	@Column(name = "pay_code", unique = true, nullable = false, length = 20)
	public String getPayCode() {
		return this.payCode;
	}

	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}

	@Column(name = "pay_name", nullable = false, length = 120)
	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	@Column(name = "pay_fee", nullable = false, length = 10)
	public String getPayFee() {
		return this.payFee;
	}

	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}

	@Column(name = "pay_desc", nullable = false, length = 65535)
	public String getPayDesc() {
		return this.payDesc;
	}

	public void setPayDesc(String payDesc) {
		this.payDesc = payDesc;
	}

	@Column(name = "pay_order", nullable = false)
	public Short getPayOrder() {
		return this.payOrder;
	}

	public void setPayOrder(Short payOrder) {
		this.payOrder = payOrder;
	}

	@Column(name = "pay_config", nullable = false, length = 65535)
	public String getPayConfig() {
		return this.payConfig;
	}

	public void setPayConfig(String payConfig) {
		this.payConfig = payConfig;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "is_cod", nullable = false)
	public Boolean getIsCod() {
		return this.isCod;
	}

	public void setIsCod(Boolean isCod) {
		this.isCod = isCod;
	}

	@Column(name = "is_online", nullable = false)
	public Boolean getIsOnline() {
		return this.isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

}