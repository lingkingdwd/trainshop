package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OrderGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_goods", catalog = "trainshop")
public class OrderGoods implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer orderId;
	private Integer goodsId;
	private String goodsName;
	private String goodsSn;
	private Integer productId;
	private Short goodsNumber;
	private Double marketPrice;
	private Double goodsPrice;
	private String goodsAttr;
	private Short sendNumber;
	private Boolean isReal;
	private String extensionCode;
	private Integer parentId;
	private Short isGift;
	private String goodsAttrId;

	// Constructors

	/** default constructor */
	public OrderGoods() {
	}

	/** full constructor */
	public OrderGoods(Integer orderId, Integer goodsId, String goodsName,
			String goodsSn, Integer productId, Short goodsNumber,
			Double marketPrice, Double goodsPrice, String goodsAttr,
			Short sendNumber, Boolean isReal, String extensionCode,
			Integer parentId, Short isGift, String goodsAttrId) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsSn = goodsSn;
		this.productId = productId;
		this.goodsNumber = goodsNumber;
		this.marketPrice = marketPrice;
		this.goodsPrice = goodsPrice;
		this.goodsAttr = goodsAttr;
		this.sendNumber = sendNumber;
		this.isReal = isReal;
		this.extensionCode = extensionCode;
		this.parentId = parentId;
		this.isGift = isGift;
		this.goodsAttrId = goodsAttrId;
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

	@Column(name = "order_id", nullable = false)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_sn", nullable = false, length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "product_id", nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "market_price", nullable = false, precision = 10)
	public Double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Column(name = "goods_price", nullable = false, precision = 10)
	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	@Column(name = "goods_attr", nullable = false, length = 65535)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	@Column(name = "send_number", nullable = false)
	public Short getSendNumber() {
		return this.sendNumber;
	}

	public void setSendNumber(Short sendNumber) {
		this.sendNumber = sendNumber;
	}

	@Column(name = "is_real", nullable = false)
	public Boolean getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Boolean isReal) {
		this.isReal = isReal;
	}

	@Column(name = "extension_code", nullable = false, length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "is_gift", nullable = false)
	public Short getIsGift() {
		return this.isGift;
	}

	public void setIsGift(Short isGift) {
		this.isGift = isGift;
	}

	@Column(name = "goods_attr_id", nullable = false)
	public String getGoodsAttrId() {
		return this.goodsAttrId;
	}

	public void setGoodsAttrId(String goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

}