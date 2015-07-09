package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * GoodsCat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_cat", catalog = "trainshop")
public class GoodsCat implements java.io.Serializable {

	// Fields

	private GoodsCatId id;

	// Constructors

	/** default constructor */
	public GoodsCat() {
	}

	/** full constructor */
	public GoodsCat(GoodsCatId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "catId", column = @Column(name = "cat_id", nullable = false)) })
	public GoodsCatId getId() {
		return this.id;
	}

	public void setId(GoodsCatId id) {
		this.id = id;
	}

}