package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

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

	private Long recId;
	private Long orderId;
	private Long goodsId;
	private String goodsName;
	private String goodsSn;
	private Integer productId;
	private Integer goodsNumber;
	private Double marketPrice;
	private Double goodsPrice;
	private String goodsAttr;
	private Integer sendNumber;
	private Integer isReal;
	private String extensionCode;
	private Integer parentId;
	private Integer isGift;
	private String goodsAttrId;
	
	private String goodsThumb;
	private String goodsImg;
	private String originalImg;
	private String goodsBrief;
	private String goodsDesc;
	
	@Transient
	public String getGoodsThumb() {
		return goodsThumb;
	}

	@Transient
	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = goodsThumb;
	}

	@Transient
	public String getGoodsImg() {
		return goodsImg;
	}

	@Transient
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	@Transient
	public String getOriginalImg() {
		return originalImg;
	}

	@Transient
	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
	}

	@Transient
	public String getGoodsBrief() {
		return goodsBrief;
	}

	@Transient
	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}

	@Transient
	public String getGoodsDesc() {
		return goodsDesc;
	}

	@Transient
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	
	public OrderGoods(Long orderId, Long goodsId, String goodsName,
			String goodsSn, Integer productId, Integer goodsNumber,
			Double marketPrice, Double goodsPrice, String goodsAttr,
			Integer sendNumber, Integer isReal, String extensionCode,
			Integer parentId, Integer isGift, String goodsAttrId, 
			String goodsThumb, String goodsImg, String originalImg,
			String goodsBrief, String goodsDesc) {
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
		
		this.goodsThumb = goodsThumb;
		this.goodsImg = goodsImg;
		this.originalImg = originalImg;
		this.goodsBrief = goodsBrief;
		this.goodsDesc = goodsDesc;
	}

	// Constructors

	/** default constructor */
	public OrderGoods() {
	}

	/** minimal constructor */
	public OrderGoods(Long orderId, Long goodsId, String goodsName,
			Integer goodsNumber, Double goodsPrice) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNumber = goodsNumber;
		this.goodsPrice = goodsPrice;
	}

	/** full constructor */
	public OrderGoods(Long orderId, Long goodsId, String goodsName,
			String goodsSn, Integer productId, Integer goodsNumber,
			Double marketPrice, Double goodsPrice, String goodsAttr,
			Integer sendNumber, Integer isReal, String extensionCode,
			Integer parentId, Integer isGift, String goodsAttrId) {
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
	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_sn", length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "product_id")
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "goods_number", nullable = false)
	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "market_price", precision = 10)
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

	@Column(name = "goods_attr", length = 65535)
	public String getGoodsAttr() {
		return this.goodsAttr;
	}

	public void setGoodsAttr(String goodsAttr) {
		this.goodsAttr = goodsAttr;
	}

	@Column(name = "send_number")
	public Integer getSendNumber() {
		return this.sendNumber;
	}

	public void setSendNumber(Integer sendNumber) {
		this.sendNumber = sendNumber;
	}

	@Column(name = "is_real")
	public Integer getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Integer isReal) {
		this.isReal = isReal;
	}

	@Column(name = "extension_code", length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "is_gift")
	public Integer getIsGift() {
		return this.isGift;
	}

	public void setIsGift(Integer isGift) {
		this.isGift = isGift;
	}

	@Column(name = "goods_attr_id")
	public String getGoodsAttrId() {
		return this.goodsAttrId;
	}

	public void setGoodsAttrId(String goodsAttrId) {
		this.goodsAttrId = goodsAttrId;
	}

}