package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cart", catalog = "trainshop")
public class Cart implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer userId;
	private String sessionId;
	private Integer goodsId;
	private String goodsSn;
	private Integer productId;
	private String goodsName;
	private Double marketPrice;
	private Double goodsPrice;
	private Short goodsNumber;
	private String goodsAttr;
	private Boolean isReal;
	private String extensionCode;
	private Integer parentId;
	private Boolean recType;
	private Short isGift;
	private Boolean isShipping;
	private Short canHandsel;
	private String goodsAttrId;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Integer userId, String sessionId, Integer goodsId,
			String goodsSn, Integer productId, String goodsName,
			Double marketPrice, Double goodsPrice, Short goodsNumber,
			String goodsAttr, Boolean isReal, String extensionCode,
			Integer parentId, Boolean recType, Short isGift,
			Boolean isShipping, Short canHandsel, String goodsAttrId) {
		this.userId = userId;
		this.sessionId = sessionId;
		this.goodsId = goodsId;
		this.goodsSn = goodsSn;
		this.productId = productId;
		this.goodsName = goodsName;
		this.marketPrice = marketPrice;
		this.goodsPrice = goodsPrice;
		this.goodsNumber = goodsNumber;
		this.goodsAttr = goodsAttr;
		this.isReal = isReal;
		this.extensionCode = extensionCode;
		this.parentId = parentId;
		this.recType = recType;
		this.isGift = isGift;
		this.isShipping = isShipping;
		this.canHandsel = canHandsel;
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

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "session_id", nullable = false, length = 32)
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
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

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "goods_attr", nullable = false, length = 65535)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
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

	@Column(name = "rec_type", nullable = false)
	public Boolean getRecType() {
		return this.recType;
	}

	public void setRecType(Boolean recType) {
		this.recType = recType;
	}

	@Column(name = "is_gift", nullable = false)
	public Short getIsGift() {
		return this.isGift;
	}

	public void setIsGift(Short isGift) {
		this.isGift = isGift;
	}

	@Column(name = "is_shipping", nullable = false)
	public Boolean getIsShipping() {
		return this.isShipping;
	}

	public void setIsShipping(Boolean isShipping) {
		this.isShipping = isShipping;
	}

	@Column(name = "can_handsel", nullable = false)
	public Short getCanHandsel() {
		return this.canHandsel;
	}

	public void setCanHandsel(Short canHandsel) {
		this.canHandsel = canHandsel;
	}

	@Column(name = "goods_attr_id", nullable = false)
	public String getGoodsAttrId() {
		return this.goodsAttrId;
	}

	public void setGoodsAttrId(String goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

}