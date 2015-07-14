package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LinkGoodsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class LinkGoodsId implements java.io.Serializable {

	// Fields

	private Long goodsId;
	private Long linkGoodsId;
	private Short adminId;

	// Constructors

	/** default constructor */
	public LinkGoodsId() {
	}

	/** full constructor */
	public LinkGoodsId(Long goodsId, Long linkGoodsId, Short adminId) {
		this.goodsId = goodsId;
		this.linkGoodsId = linkGoodsId;
		this.adminId = adminId;
	}

	// Property accessors

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "link_goods_id", nullable = false)
	public Long getLinkGoodsId() {
		return this.linkGoodsId;
	}

	public void setLinkGoodsId(Long linkGoodsId) {
		this.linkGoodsId = linkGoodsId;
	}

	@Column(name = "admin_id", nullable = false)
	public Short getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Short adminId) {
		this.adminId = adminId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LinkGoodsId))
			return false;
		LinkGoodsId castOther = (LinkGoodsId) other;

		return ((this.getGoodsId() == castOther.getGoodsId()) || (this
				.getGoodsId() != null && castOther.getGoodsId() != null && this
				.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getLinkGoodsId() == castOther.getLinkGoodsId()) || (this
						.getLinkGoodsId() != null
						&& castOther.getLinkGoodsId() != null && this
						.getLinkGoodsId().equals(castOther.getLinkGoodsId())))
				&& ((this.getAdminId() == castOther.getAdminId()) || (this
						.getAdminId() != null && castOther.getAdminId() != null && this
						.getAdminId().equals(castOther.getAdminId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37
				* result
				+ (getLinkGoodsId() == null ? 0 : this.getLinkGoodsId()
						.hashCode());
		result = 37 * result
				+ (getAdminId() == null ? 0 : this.getAdminId().hashCode());
		return result;
	}

}