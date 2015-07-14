package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsAttr entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_attr", catalog = "trainshop")
public class GoodsAttr implements java.io.Serializable {

	// Fields

	private Long goodsAttrId;
	private Integer goodsId;
	private Short attrId;
	private String attrValue;
	private String attrPrice;

	// Constructors

	/** default constructor */
	public GoodsAttr() {
	}

	/** full constructor */
	public GoodsAttr(Integer goodsId, Short attrId, String attrValue,
			String attrPrice) {
		this.goodsId = goodsId;
		this.attrId = attrId;
		this.attrValue = attrValue;
		this.attrPrice = attrPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_attr_id", unique = true, nullable = false)
	public Long getGoodsAttrId() {
		return this.goodsAttrId;
	}

	public void setGoodsAttrId(Long goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "attr_id", nullable = false)
	public Short getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Short attrId) {
		this.attrId = attrId;
	}

	@Column(name = "attr_value", nullable = false, length = 65535)
	public String getAttrValue() {
		return this.attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	@Column(name = "attr_price", nullable = false)
	public String getAttrPrice() {
		return this.attrPrice;
	}

	public void setAttrPrice(String attrPrice) {
		this.attrPrice = attrPrice;
	}

}