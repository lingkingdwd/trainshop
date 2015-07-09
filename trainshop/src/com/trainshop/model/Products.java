package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Products entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "products", catalog = "trainshop")
public class Products implements java.io.Serializable {

	// Fields

	private Integer productId;
	private Integer goodsId;
	private String goodsAttr;
	private String productSn;
	private Short productNumber;

	// Constructors

	/** default constructor */
	public Products() {
	}

	/** minimal constructor */
	public Products(Integer goodsId) {
		this.goodsId = goodsId;
	}

	/** full constructor */
	public Products(Integer goodsId, String goodsAttr, String productSn,
			Short productNumber) {
		this.goodsId = goodsId;
		this.goodsAttr = goodsAttr;
		this.productSn = productSn;
		this.productNumber = productNumber;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_attr", length = 50)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	@Column(name = "product_sn", length = 60)
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	@Column(name = "product_number")
	public Short getProductNumber() {
		return this.productNumber;
	}

	public void setProductNumber(Short productNumber) {
		this.productNumber = productNumber;
	}

}