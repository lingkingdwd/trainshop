package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GoodsCatId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class GoodsCatId implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Short catId;

	// Constructors

	/** default constructor */
	public GoodsCatId() {
	}

	/** full constructor */
	public GoodsCatId(Integer goodsId, Short catId) {
		this.goodsId = goodsId;
		this.catId = catId;
	}

	// Property accessors

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "cat_id", nullable = false)
	public Short getCatId() {
		return this.catId;
	}

	public void setCatId(Short catId) {
		this.catId = catId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GoodsCatId))
			return false;
		GoodsCatId castOther = (GoodsCatId) other;

		return ((this.getGoodsId() == castOther.getGoodsId()) || (this
				.getGoodsId() != null && castOther.getGoodsId() != null && this
				.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getCatId() == castOther.getCatId()) || (this
						.getCatId() != null && castOther.getCatId() != null && this
						.getCatId().equals(castOther.getCatId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37 * result
				+ (getCatId() == null ? 0 : this.getCatId().hashCode());
		return result;
	}

}