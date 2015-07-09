package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * CatRecommend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cat_recommend", catalog = "trainshop")
public class CatRecommend implements java.io.Serializable {

	// Fields

	private CatRecommendId id;

	// Constructors

	/** default constructor */
	public CatRecommend() {
	}

	/** full constructor */
	public CatRecommend(CatRecommendId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "catId", column = @Column(name = "cat_id", nullable = false)),
			@AttributeOverride(name = "recommendType", column = @Column(name = "recommend_type", nullable = false)) })
	public CatRecommendId getId() {
		return this.id;
	}

	public void setId(CatRecommendId id) {
		this.id = id;
	}

}