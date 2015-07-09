package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AreaRegion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "area_region", catalog = "trainshop")
public class AreaRegion implements java.io.Serializable {

	// Fields

	private AreaRegionId id;

	// Constructors

	/** default constructor */
	public AreaRegion() {
	}

	/** full constructor */
	public AreaRegion(AreaRegionId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "shippingAreaId", column = @Column(name = "shipping_area_id", nullable = false)),
			@AttributeOverride(name = "regionId", column = @Column(name = "region_id", nullable = false)) })
	public AreaRegionId getId() {
		return this.id;
	}

	public void setId(AreaRegionId id) {
		this.id = id;
	}

}