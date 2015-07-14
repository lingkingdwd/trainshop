package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * CatRecommendId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class CatRecommendId implements java.io.Serializable {

	// Fields

	private Long catId;
	private Integer recommendType;

	// Constructors

	/** default constructor */
	public CatRecommendId() {
	}

	/** full constructor */
	public CatRecommendId(Long catId, Integer recommendType) {
		this.catId = catId;
		this.recommendType = recommendType;
	}

	// Property accessors

	@Column(name = "cat_id", nullable = false)
	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	@Column(name = "recommend_type", nullable = false)
	public Integer getRecommendType() {
		return this.recommendType;
	}

	public void setRecommendType(Integer recommendType) {
		this.recommendType = recommendType;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CatRecommendId))
			return false;
		CatRecommendId castOther = (CatRecommendId) other;

		return ((this.getCatId() == castOther.getCatId()) || (this.getCatId() != null
				&& castOther.getCatId() != null && this.getCatId().equals(
				castOther.getCatId())))
				&& ((this.getRecommendType() == castOther.getRecommendType()) || (this
						.getRecommendType() != null
						&& castOther.getRecommendType() != null && this
						.getRecommendType()
						.equals(castOther.getRecommendType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getCatId() == null ? 0 : this.getCatId().hashCode());
		result = 37
				* result
				+ (getRecommendType() == null ? 0 : this.getRecommendType()
						.hashCode());
		return result;
	}

}