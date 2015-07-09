package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VolumePrice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "volume_price", catalog = "trainshop")
public class VolumePrice implements java.io.Serializable {

	// Fields

	private VolumePriceId id;
	private Double volumePrice;

	// Constructors

	/** default constructor */
	public VolumePrice() {
	}

	/** full constructor */
	public VolumePrice(VolumePriceId id, Double volumePrice) {
		this.id = id;
		this.volumePrice = volumePrice;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "priceType", column = @Column(name = "price_type", nullable = false)),
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "volumeNumber", column = @Column(name = "volume_number", nullable = false)) })
	public VolumePriceId getId() {
		return this.id;
	}

	public void setId(VolumePriceId id) {
		this.id = id;
	}

	@Column(name = "volume_price", nullable = false, precision = 10)
	public Double getVolumePrice() {
		return this.volumePrice;
	}

	public void setVolumePrice(Double volumePrice) {
		this.volumePrice = volumePrice;
	}

}