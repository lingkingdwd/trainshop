package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VolumePriceId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class VolumePriceId implements java.io.Serializable {

	// Fields

	private Boolean priceType;
	private Integer goodsId;
	private Short volumeNumber;

	// Constructors

	/** default constructor */
	public VolumePriceId() {
	}

	/** full constructor */
	public VolumePriceId(Boolean priceType, Integer goodsId, Short volumeNumber) {
		this.priceType = priceType;
		this.goodsId = goodsId;
		this.volumeNumber = volumeNumber;
	}

	// Property accessors

	@Column(name = "price_type", nullable = false)
	public Boolean getPriceType() {
		return this.priceType;
	}

	public void setPriceType(Boolean priceType) {
		this.priceType = priceType;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "volume_number", nullable = false)
	public Short getVolumeNumber() {
		return this.volumeNumber;
	}

	public void setVolumeNumber(Short volumeNumber) {
		this.volumeNumber = volumeNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VolumePriceId))
			return false;
		VolumePriceId castOther = (VolumePriceId) other;

		return ((this.getPriceType() == castOther.getPriceType()) || (this
				.getPriceType() != null && castOther.getPriceType() != null && this
				.getPriceType().equals(castOther.getPriceType())))
				&& ((this.getGoodsId() == castOther.getGoodsId()) || (this
						.getGoodsId() != null && castOther.getGoodsId() != null && this
						.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getVolumeNumber() == castOther.getVolumeNumber()) || (this
						.getVolumeNumber() != null
						&& castOther.getVolumeNumber() != null && this
						.getVolumeNumber().equals(castOther.getVolumeNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPriceType() == null ? 0 : this.getPriceType().hashCode());
		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37
				* result
				+ (getVolumeNumber() == null ? 0 : this.getVolumeNumber()
						.hashCode());
		return result;
	}

}