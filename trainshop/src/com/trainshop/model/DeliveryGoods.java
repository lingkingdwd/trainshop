package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DeliveryGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery_goods", catalog = "trainshop")
public class DeliveryGoods implements java.io.Serializable {

	// Fields

	private Long recId;
	private Long deliveryId;
	private Long goodsId;
	private Long productId;
	private String productSn;
	private String goodsName;
	private String brandName;
	private String goodsSn;
	private Integer isReal;
	private String extensionCode;
	private Long parentId;
	private Integer sendNumber;
	private String goodsAttr;

	// Constructors

	/** default constructor */
	public DeliveryGoods() {
	}

	/** minimal constructor */
	public DeliveryGoods(Long deliveryId, Long goodsId) {
		this.deliveryId = deliveryId;
		this.goodsId = goodsId;
	}

	/** full constructor */
	public DeliveryGoods(Long deliveryId, Long goodsId, Long productId,
			String productSn, String goodsName, String brandName,
			String goodsSn, Integer isReal, String extensionCode,
			Long parentId, Integer sendNumber, String goodsAttr) {
		this.deliveryId = deliveryId;
		this.goodsId = goodsId;
		this.productId = productId;
		this.productSn = productSn;
		this.goodsName = goodsName;
		this.brandName = brandName;
		this.goodsSn = goodsSn;
		this.isReal = isReal;
		this.extensionCode = extensionCode;
		this.parentId = parentId;
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

	@Column(name = "delivery_id", nullable = false)
	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "product_id")
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

	@Column(name = "extension_code", length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "parent_id")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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