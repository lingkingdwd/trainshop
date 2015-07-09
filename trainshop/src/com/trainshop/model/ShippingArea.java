package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ShippingArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shipping_area", catalog = "trainshop")
public class ShippingArea implements java.io.Serializable {

	// Fields

	private Short shippingAreaId;
	private String shippingAreaName;
	private Short shippingId;
	private String configure;

	// Constructors

	/** default constructor */
	public ShippingArea() {
	}

	/** full constructor */
	public ShippingArea(String shippingAreaName, Short shippingId,
			String configure) {
		this.shippingAreaName = shippingAreaName;
		this.shippingId = shippingId;
		this.configure = configure;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "shipping_area_id", unique = true, nullable = false)
	public Short getShippingAreaId() {
		return this.shippingAreaId;
	}

	public void setShippingAreaId(Short shippingAreaId) {
		this.shippingAreaId = shippingAreaId;
	}

	@Column(name = "shipping_area_name", nullable = false, length = 150)
	public String getShippingAreaName() {
		return this.shippingAreaName;
	}

	public void setShippingAreaName(String shippingAreaName) {
		this.shippingAreaName = shippingAreaName;
	}

	@Column(name = "shipping_id", nullable = false)
	public Short getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Short shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "configure", nullable = false, length = 65535)
	public String getConfigure() {
		return this.configure;
	}

	public void setConfigure(String configure) {
		this.configure = configure;
	}

}