package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * LinkGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "link_goods", catalog = "trainshop")
public class LinkGoods implements java.io.Serializable {

	// Fields

	private LinkGoodsId id;
	private Boolean isDouble;

	// Constructors

	/** default constructor */
	public LinkGoods() {
	}

	/** full constructor */
	public LinkGoods(LinkGoodsId id, Boolean isDouble) {
		this.id = id;
		this.isDouble = isDouble;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "linkGoodsId", column = @Column(name = "link_goods_id", nullable = false)),
			@AttributeOverride(name = "adminId", column = @Column(name = "admin_id", nullable = false)) })
	public LinkGoodsId getId() {
		return this.id;
	}

	public void setId(LinkGoodsId id) {
		this.id = id;
	}

	@Column(name = "is_double", nullable = false)
	public Boolean getIsDouble() {
		return this.isDouble;
	}

	public void setIsDouble(Boolean isDouble) {
		this.isDouble = isDouble;
	}

}