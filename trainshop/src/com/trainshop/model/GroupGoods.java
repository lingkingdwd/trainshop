package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * GroupGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "group_goods", catalog = "trainshop")
public class GroupGoods implements java.io.Serializable {

	// Fields

	private GroupGoodsId id;
	private Double goodsPrice;

	// Constructors

	/** default constructor */
	public GroupGoods() {
	}

	/** full constructor */
	public GroupGoods(GroupGoodsId id, Double goodsPrice) {
		this.id = id;
		this.goodsPrice = goodsPrice;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "parentId", column = @Column(name = "parent_id", nullable = false)),
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "adminId", column = @Column(name = "admin_id", nullable = false)) })
	public GroupGoodsId getId() {
		return this.id;
	}

	public void setId(GroupGoodsId id) {
		this.id = id;
	}

	@Column(name = "goods_price", nullable = false, precision = 10)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}