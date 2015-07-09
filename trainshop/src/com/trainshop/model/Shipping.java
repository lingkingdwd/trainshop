package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shipping entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shipping", catalog = "trainshop")
public class Shipping implements java.io.Serializable {

	// Fields

	private Short shippingId;
	private String shippingCode;
	private String shippingName;
	private String shippingDesc;
	private String insure;
	private Boolean supportCod;
	private Boolean enabled;
	private String shippingPrint;
	private String printBg;
	private String configLable;
	private Boolean printModel;
	private Short shippingOrder;

	// Constructors

	/** default constructor */
	public Shipping() {
	}

	/** minimal constructor */
	public Shipping(String shippingCode, String shippingName,
			String shippingDesc, String insure, Boolean supportCod,
			Boolean enabled, String shippingPrint, Short shippingOrder) {
		this.shippingCode = shippingCode;
		this.shippingName = shippingName;
		this.shippingDesc = shippingDesc;
		this.insure = insure;
		this.supportCod = supportCod;
		this.enabled = enabled;
		this.shippingPrint = shippingPrint;
		this.shippingOrder = shippingOrder;
	}

	/** full constructor */
	public Shipping(String shippingCode, String shippingName,
			String shippingDesc, String insure, Boolean supportCod,
			Boolean enabled, String shippingPrint, String printBg,
			String configLable, Boolean printModel, Short shippingOrder) {
		this.shippingCode = shippingCode;
		this.shippingName = shippingName;
		this.shippingDesc = shippingDesc;
		this.insure = insure;
		this.supportCod = supportCod;
		this.enabled = enabled;
		this.shippingPrint = shippingPrint;
		this.printBg = printBg;
		this.configLable = configLable;
		this.printModel = printModel;
		this.shippingOrder = shippingOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shipping_id", unique = true, nullable = false)
	public Short getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Short shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "shipping_code", nullable = false, length = 20)
	public String getShippingCode() {
		return this.shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	@Column(name = "shipping_name", nullable = false, length = 120)
	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name = "shipping_desc", nullable = false)
	public String getShippingDesc() {
		return this.shippingDesc;
	}

	public void setShippingDesc(String shippingDesc) {
		this.shippingDesc = shippingDesc;
	}

	@Column(name = "insure", nullable = false, length = 10)
	public String getInsure() {
		return this.insure;
	}

	public void setInsure(String insure) {
		this.insure = insure;
	}

	@Column(name = "support_cod", nullable = false)
	public Boolean getSupportCod() {
		return this.supportCod;
	}

	public void setSupportCod(Boolean supportCod) {
		this.supportCod = supportCod;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "shipping_print", nullable = false, length = 65535)
	public String getShippingPrint() {
		return this.shippingPrint;
	}

	public void setShippingPrint(String shippingPrint) {
		this.shippingPrint = shippingPrint;
	}

	@Column(name = "print_bg")
	public String getPrintBg() {
		return this.printBg;
	}

	public void setPrintBg(String printBg) {
		this.printBg = printBg;
	}

	@Column(name = "config_lable", length = 65535)
	public String getConfigLable() {
		return this.configLable;
	}

	public void setConfigLable(String configLable) {
		this.configLable = configLable;
	}

	@Column(name = "print_model")
	public Boolean getPrintModel() {
		return this.printModel;
	}

	public void setPrintModel(Boolean printModel) {
		this.printModel = printModel;
	}

	@Column(name = "shipping_order", nullable = false)
	public Short getShippingOrder() {
		return this.shippingOrder;
	}

	public void setShippingOrder(Short shippingOrder) {
		this.shippingOrder = shippingOrder;
	}

}