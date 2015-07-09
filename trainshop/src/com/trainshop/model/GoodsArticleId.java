package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GoodsArticleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class GoodsArticleId implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Integer articleId;
	private Short adminId;

	// Constructors

	/** default constructor */
	public GoodsArticleId() {
	}

	/** full constructor */
	public GoodsArticleId(Integer goodsId, Integer articleId, Short adminId) {
		this.goodsId = goodsId;
		this.articleId = articleId;
		this.adminId = adminId;
	}

	// Property accessors

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "article_id", nullable = false)
	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
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
		if (!(other instanceof GoodsArticleId))
			return false;
		GoodsArticleId castOther = (GoodsArticleId) other;

		return ((this.getGoodsId() == castOther.getGoodsId()) || (this
				.getGoodsId() != null && castOther.getGoodsId() != null && this
				.getGoodsId().equals(castOther.getGoodsId())))
				&& ((this.getArticleId() == castOther.getArticleId()) || (this
						.getArticleId() != null
						&& castOther.getArticleId() != null && this
						.getArticleId().equals(castOther.getArticleId())))
				&& ((this.getAdminId() == castOther.getAdminId()) || (this
						.getAdminId() != null && castOther.getAdminId() != null && this
						.getAdminId().equals(castOther.getAdminId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getGoodsId() == null ? 0 : this.getGoodsId().hashCode());
		result = 37 * result
				+ (getArticleId() == null ? 0 : this.getArticleId().hashCode());
		result = 37 * result
				+ (getAdminId() == null ? 0 : this.getAdminId().hashCode());
		return result;
	}

}