package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BackGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "back_goods", catalog = "trainshop")
public class BackGoods implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer backId;
	private Integer goodsId;
	private Integer productId;
	private String productSn;
	private String goodsName;
	private String brandName;
	private String goodsSn;
	private Boolean isReal;
	private Short sendNumber;
	private String goodsAttr;

	// Constructors

	/** default constructor */
	public BackGoods() {
	}

	/** minimal constructor */
	public BackGoods(Integer goodsId, Integer productId) {
		this.goodsId = goodsId;
		this.productId = productId;
	}

	/** full constructor */
	public BackGoods(Integer backId, Integer goodsId, Integer productId,
			String productSn, String goodsName, String brandName,
			String goodsSn, Boolean isReal, Short sendNumber, String goodsAttr) {
		this.backId = backId;
		this.goodsId = goodsId;
		this.productId = productId;
		this.productSn = productSn;
		this.goodsName = goodsName;
		this.brandName = brandName;
		this.goodsSn = goodsSn;
		this.isReal = isReal;
		this.sendNumber = sendNumber;
		this.goodsAttr = goodsAttr;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rec_id", unique = true, nullable = false)
	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	@Column(name = "back_id")
	public Integer getBackId() {
		return this.backId;
	}

	public void setBackId(Integer backId) {
		this.backId = backId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "product_id", nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "product_sn", length = 60)
	public String getProductSn() {
		return this.productSn;
	}

	public void setProductSn(String productSn) {
		this.productSn = productSn;
	}

	@Column(name = "goods_name", length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "brand_name", length = 60)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "goods_sn", length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "is_real")
	public Boolean getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Boolean isReal) {
		this.isReal = isReal;
	}

	@Column(name = "send_number")
	public Short getSendNumber() {
		return this.sendNumber;
	}

	public void setSendNumber(Short sendNumber) {
		this.sendNumber = sendNumber;
	}

	@Column(name = "goods_attr", length = 65535)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

}