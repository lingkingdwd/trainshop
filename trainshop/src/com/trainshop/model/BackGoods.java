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

	private Long recId;
	private Long backId;
	private Long goodsId;
	private Long productId;
	private String productSn;
	private String goodsName;
	private String brandName;
	private String goodsSn;
	private Integer isReal;
	private Integer sendNumber;
	private String goodsAttr;

	// Constructors

	/** default constructor */
	public BackGoods() {
	}

	/** minimal constructor */
	public BackGoods(Long goodsId, Long productId) {
		this.goodsId = goodsId;
		this.productId = productId;
	}

	/** full constructor */
	public BackGoods(Long backId, Long goodsId, Long productId,
			String productSn, String goodsName, String brandName,
			String goodsSn, Integer isReal, Integer sendNumber, String goodsAttr) {
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
	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	@Column(name = "back_id")
	public Long getBackId() {
		return this.backId;
	}

	public void setBackId(Long backId) {
		this.backId = backId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "product_id", nullable = false)
	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
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
	public Integer getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Integer isReal) {
		this.isReal = isReal;
	}

	@Column(name = "send_number")
	public Integer getSendNumber() {
		return this.sendNumber;
	}

	public void setSendNumber(Integer sendNumber) {
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