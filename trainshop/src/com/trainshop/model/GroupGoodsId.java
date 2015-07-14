package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GroupGoodsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class GroupGoodsId implements java.io.Serializable {

	// Fields

	private Long parentId;
	private Long goodsId;
	private Short adminId;

	// Constructors

	/** default constructor */
	public GroupGoodsId() {
	}

	/** full constructor */
	public GroupGoodsId(Long parentId, Long goodsId, Short adminId) {
		this.parentId = parentId;
		this.goodsId = goodsId;
		this.adminId = adminId;
	}

	// Property accessors

	@Column(name = "parent_id", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
		if (!(other instanceof GroupGoodsId))
			return false;
		GroupGoodsId castOther = (GroupGoodsId) other;

		return ((this.getParentId() == castOther.getParentId()) || (this
				.getParentId() != null && castOther.getParentId() != null && this
				.getParentId().equals(castOther.getParentId())))
				&& ((this.getGoodsId() == castOther.getGoodsId()) || (this
						.getGoodsId() != null && castOther.getGoodsId() != null && this
						.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getAdminId() == castOther.getAdminId()) || (this
						.getAdminId() != null && castOther.getAdminId() != null && this
						.getAdminId().equals(castOther.getAdminId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getParentId() == null ? 0 : this.getParentId().hashCode());
		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37 * result
				+ (getAdminId() == null ? 0 : this.getAdminId().hashCode());
		return result;
	}

}