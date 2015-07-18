package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods", catalog = "trainshop")
public class Goods implements java.io.Serializable {

	// Fields

	private Long goodsId;
	private Integer catId;
	private String goodsSn;
	private String goodsName;
	private String goodsNameStyle;
	private Integer clickCount;
	private Long brandId;
	private String providerName;
	private Integer goodsNumber;
	private Double goodsWeight;
	private Double marketPrice;
	private Double shopPrice;
	private Double promotePrice;
	private Long promoteStartDate;
	private Long promoteEndDate;
	private Integer warnNumber;
	private String keywords;
	private String goodsBrief;
	private String goodsDesc;
	private String goodsThumb;
	private String goodsImg;
	private String originalImg;
	private Integer isReal;
	private String extensionCode;
	private Integer isOnSale;
	private Integer isAloneSale;
	private Integer isShipping;
	private Integer integral;
	private Long addTime;
	private Integer sortOrder;
	private Integer isDelete;
	private Integer isBest;
	private Integer isNew;
	private Integer isHot;
	private Integer isPromote;
	private Integer bonusTypeId;
	private Long lastUpdate;
	private Integer goodsType;
	private String sellerNote;
	private Integer giveIntegral;
	private Integer rankIntegral;
	private Integer suppliersId;
	private Integer isCheck;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Integer catId,
			String goodsName, Integer goodsNumber, Double shopPrice,
			String goodsBrief, String goodsDesc, String goodsThumb,
			String goodsImg, String originalImg, Integer isDelete) {
//		this.startTime = startTime;
		this.catId = catId;
		this.goodsName = goodsName;
		this.goodsNumber = goodsNumber;
		this.shopPrice = shopPrice;
		this.goodsBrief = goodsBrief;
		this.goodsDesc = goodsDesc;
		this.goodsThumb = goodsThumb;
		this.goodsImg = goodsImg;
		this.originalImg = originalImg;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public Goods(Integer catId,
			String goodsSn, String goodsName, String goodsNameStyle,
			Integer clickCount, Long brandId, String providerName,
			Integer goodsNumber, Double goodsWeight, Double marketPrice,
			Double shopPrice, Double promotePrice, Long promoteStartDate,
			Long promoteEndDate, Integer warnNumber, String keywords,
			String goodsBrief, String goodsDesc, String goodsThumb,
			String goodsImg, String originalImg, Integer isReal,
			String extensionCode, Integer isOnSale, Integer isAloneSale,
			Integer isShipping, Integer integral, Long addTime,
			Integer sortOrder, Integer isDelete, Integer isBest, Integer isNew,
			Integer isHot, Integer isPromote, Integer bonusTypeId,
			Long lastUpdate, Integer goodsType, String sellerNote,
			Integer giveIntegral, Integer rankIntegral, Integer suppliersId,
			Integer isCheck) {
		this.catId = catId;
		this.goodsSn = goodsSn;
		this.goodsName = goodsName;
		this.goodsNameStyle = goodsNameStyle;
		this.clickCount = clickCount;
		this.brandId = brandId;
		this.providerName = providerName;
		this.goodsNumber = goodsNumber;
		this.goodsWeight = goodsWeight;
		this.marketPrice = marketPrice;
		this.shopPrice = shopPrice;
		this.promotePrice = promotePrice;
		this.promoteStartDate = promoteStartDate;
		this.promoteEndDate = promoteEndDate;
		this.warnNumber = warnNumber;
		this.keywords = keywords;
		this.goodsBrief = goodsBrief;
		this.goodsDesc = goodsDesc;
		this.goodsThumb = goodsThumb;
		this.goodsImg = goodsImg;
		this.originalImg = originalImg;
		this.isReal = isReal;
		this.extensionCode = extensionCode;
		this.isOnSale = isOnSale;
		this.isAloneSale = isAloneSale;
		this.isShipping = isShipping;
		this.integral = integral;
		this.addTime = addTime;
		this.sortOrder = sortOrder;
		this.isDelete = isDelete;
		this.isBest = isBest;
		this.isNew = isNew;
		this.isHot = isHot;
		this.isPromote = isPromote;
		this.bonusTypeId = bonusTypeId;
		this.lastUpdate = lastUpdate;
		this.goodsType = goodsType;
		this.sellerNote = sellerNote;
		this.giveIntegral = giveIntegral;
		this.rankIntegral = rankIntegral;
		this.suppliersId = suppliersId;
		this.isCheck = isCheck;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "goods_id", unique = true, nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "cat_id", nullable = false)
	public Integer getCatId() {
		return this.catId;
	}

	public void setCatId(Integer catId) {
		this.catId = catId;
	}

	@Column(name = "goods_sn", length = 60)
	public String getGoodsSn() {
		return this.goodsSn;
	}

	public void setGoodsSn(String goodsSn) {
		this.goodsSn = goodsSn;
	}

	@Column(name = "goods_name", nullable = false, length = 120)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "goods_name_style", length = 60)
	public String getGoodsNameStyle() {
		return this.goodsNameStyle;
	}

	public void setGoodsNameStyle(String goodsNameStyle) {
		this.goodsNameStyle = goodsNameStyle;
	}

	@Column(name = "click_count")
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "brand_id")
	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	@Column(name = "provider_name", length = 100)
	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Column(name = "goods_number", nullable = false)
	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "goods_weight", precision = 10, scale = 3)
	public Double getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setGoodsWeight(Double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	@Column(name = "market_price", precision = 10)
	public Double getMarketPrice() {
		return this.marketPrice;
	}

	public void setMarketPrice(Double marketPrice) {
		this.marketPrice = marketPrice;
	}

	@Column(name = "shop_price", nullable = false, precision = 10)
	public Double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	@Column(name = "promote_price", precision = 10)
	public Double getPromotePrice() {
		return this.promotePrice;
	}

	public void setPromotePrice(Double promotePrice) {
		this.promotePrice = promotePrice;
	}

	@Column(name = "promote_start_date")
	public Long getPromoteStartDate() {
		return this.promoteStartDate;
	}

	public void setPromoteStartDate(Long promoteStartDate) {
		this.promoteStartDate = promoteStartDate;
	}

	@Column(name = "promote_end_date")
	public Long getPromoteEndDate() {
		return this.promoteEndDate;
	}

	public void setPromoteEndDate(Long promoteEndDate) {
		this.promoteEndDate = promoteEndDate;
	}

	@Column(name = "warn_number")
	public Integer getWarnNumber() {
		return this.warnNumber;
	}

	public void setWarnNumber(Integer warnNumber) {
		this.warnNumber = warnNumber;
	}

	@Column(name = "keywords")
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "goods_brief", nullable = false)
	public String getGoodsBrief() {
		return this.goodsBrief;
	}

	public void setGoodsBrief(String goodsBrief) {
		this.goodsBrief = goodsBrief;
	}

	@Column(name = "goods_desc", nullable = false, length = 65535)
	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	@Column(name = "goods_thumb", nullable = false)
	public String getGoodsThumb() {
		return this.goodsThumb;
	}

	public void setGoodsThumb(String goodsThumb) {
		this.goodsThumb = goodsThumb;
	}

	@Column(name = "goods_img", nullable = false)
	public String getGoodsImg() {
		return this.goodsImg;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	@Column(name = "original_img", nullable = false)
	public String getOriginalImg() {
		return this.originalImg;
	}

	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
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

	@Column(name = "is_on_sale")
	public Integer getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Integer isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Column(name = "is_alone_sale")
	public Integer getIsAloneSale() {
		return this.isAloneSale;
	}

	public void setIsAloneSale(Integer isAloneSale) {
		this.isAloneSale = isAloneSale;
	}

	@Column(name = "is_shipping")
	public Integer getIsShipping() {
		return this.isShipping;
	}

	public void setIsShipping(Integer isShipping) {
		this.isShipping = isShipping;
	}

	@Column(name = "integral")
	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Column(name = "add_time")
	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	@Column(name = "sort_order")
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_delete", nullable = false)
	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "is_best")
	public Integer getIsBest() {
		return this.isBest;
	}

	public void setIsBest(Integer isBest) {
		this.isBest = isBest;
	}

	@Column(name = "is_new")
	public Integer getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	@Column(name = "is_hot")
	public Integer getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	@Column(name = "is_promote")
	public Integer getIsPromote() {
		return this.isPromote;
	}

	public void setIsPromote(Integer isPromote) {
		this.isPromote = isPromote;
	}

	@Column(name = "bonus_type_id")
	public Integer getBonusTypeId() {
		return this.bonusTypeId;
	}

	public void setBonusTypeId(Integer bonusTypeId) {
		this.bonusTypeId = bonusTypeId;
	}

	@Column(name = "last_update")
	public Long getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Long lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "goods_type")
	public Integer getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	@Column(name = "seller_note")
	public String getSellerNote() {
		return this.sellerNote;
	}

	public void setSellerNote(String sellerNote) {
		this.sellerNote = sellerNote;
	}

	@Column(name = "give_integral")
	public Integer getGiveIntegral() {
		return this.giveIntegral;
	}

	public void setGiveIntegral(Integer giveIntegral) {
		this.giveIntegral = giveIntegral;
	}

	@Column(name = "rank_integral")
	public Integer getRankIntegral() {
		return this.rankIntegral;
	}

	public void setRankIntegral(Integer rankIntegral) {
		this.rankIntegral = rankIntegral;
	}

	@Column(name = "suppliers_id")
	public Integer getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Integer suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "is_check")
	public Integer getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}

}