package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AreaRegionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AreaRegionId implements java.io.Serializable {

	// Fields

	private Long shippingAreaId;
	private Long regionId;

	// Constructors

	/** default constructor */
	public AreaRegionId() {
	}

	/** full constructor */
	public AreaRegionId(Long shippingAreaId, Long regionId) {
		this.shippingAreaId = shippingAreaId;
		this.regionId = regionId;
	}

	// Property accessors

	@Column(name = "shipping_area_id", nullable = false)
	public Long getShippingAreaId() {
		return this.shippingAreaId;
	}

	public void setShippingAreaId(Long shippingAreaId) {
		this.shippingAreaId = shippingAreaId;
	}

	@Column(name = "region_id", nullable = false)
	public Long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AreaRegionId))
			return false;
		AreaRegionId castOther = (AreaRegionId) other;

		return ((this.getShippingAreaId() == castOther.getShippingAreaId()) || (this
				.getShippingAreaId() != null
				&& castOther.getShippingAreaId() != null && this
				.getShippingAreaId().equals(castOther.getShippingAreaId())))
				&& ((this.getRegionId() == castOther.getRegionId()) || (this
						.getRegionId() != null
						&& castOther.getRegionId() != null && this
						.getRegionId().equals(castOther.getRegionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getShippingAreaId() == null ? 0 : this.getShippingAreaId()
						.hashCode());
		result = 37 * result
				+ (getRegionId() == null ? 0 : this.getRegionId().hashCode());
		return result;
	}

}