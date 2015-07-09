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

	private Integer goodsId;
	private Short catId;
	private String goodsSn;
	private String goodsName;
	private String goodsNameStyle;
	private Integer clickCount;
	private Short brandId;
	private String providerName;
	private Short goodsNumber;
	private Double goodsWeight;
	private Double marketPrice;
	private Double shopPrice;
	private Double promotePrice;
	private Integer promoteStartDate;
	private Integer promoteEndDate;
	private Short warnNumber;
	private String keywords;
	private String goodsBrief;
	private String goodsDesc;
	private String goodsThumb;
	private String goodsImg;
	private String originalImg;
	private Short isReal;
	private String extensionCode;
	private Boolean isOnSale;
	private Boolean isAloneSale;
	private Boolean isShipping;
	private Integer integral;
	private Integer addTime;
	private Short sortOrder;
	private Boolean isDelete;
	private Boolean isBest;
	private Boolean isNew;
	private Boolean isHot;
	private Boolean isPromote;
	private Short bonusTypeId;
	private Integer lastUpdate;
	private Short goodsType;
	private String sellerNote;
	private Integer giveIntegral;
	private Integer rankIntegral;
	private Short suppliersId;
	private Boolean isCheck;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Short catId, String goodsSn, String goodsName,
			String goodsNameStyle, Integer clickCount, Short brandId,
			String providerName, Short goodsNumber, Double goodsWeight,
			Double marketPrice, Double shopPrice, Double promotePrice,
			Integer promoteStartDate, Integer promoteEndDate, Short warnNumber,
			String keywords, String goodsBrief, String goodsDesc,
			String goodsThumb, String goodsImg, String originalImg,
			Short isReal, String extensionCode, Boolean isOnSale,
			Boolean isAloneSale, Boolean isShipping, Integer integral,
			Integer addTime, Short sortOrder, Boolean isDelete, Boolean isBest,
			Boolean isNew, Boolean isHot, Boolean isPromote, Short bonusTypeId,
			Integer lastUpdate, Short goodsType, String sellerNote,
			Integer giveIntegral, Integer rankIntegral) {
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
	}

	/** full constructor */
	public Goods(Short catId, String goodsSn, String goodsName,
			String goodsNameStyle, Integer clickCount, Short brandId,
			String providerName, Short goodsNumber, Double goodsWeight,
			Double marketPrice, Double shopPrice, Double promotePrice,
			Integer promoteStartDate, Integer promoteEndDate, Short warnNumber,
			String keywords, String goodsBrief, String goodsDesc,
			String goodsThumb, String goodsImg, String originalImg,
			Short isReal, String extensionCode, Boolean isOnSale,
			Boolean isAloneSale, Boolean isShipping, Integer integral,
			Integer addTime, Short sortOrder, Boolean isDelete, Boolean isBest,
			Boolean isNew, Boolean isHot, Boolean isPromote, Short bonusTypeId,
			Integer lastUpdate, Short goodsType, String sellerNote,
			Integer giveIntegral, Integer rankIntegral, Short suppliersId,
			Boolean isCheck) {
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
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "cat_id", nullable = false)
	public Short getCatId() {
		return this.catId;
	}

	public void setCatId(Short catId) {
		this.catId = catId;
	}

	@Column(name = "goods_sn", nullable = false, length = 60)
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

	@Column(name = "goods_name_style", nullable = false, length = 60)
	public String getGoodsNameStyle() {
		return this.goodsNameStyle;
	}

	public void setGoodsNameStyle(String goodsNameStyle) {
		this.goodsNameStyle = goodsNameStyle;
	}

	@Column(name = "click_count", nullable = false)
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "brand_id", nullable = false)
	public Short getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Short brandId) {
		this.brandId = brandId;
	}

	@Column(name = "provider_name", nullable = false, length = 100)
	public String getProviderName() {
		return this.providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "goods_weight", nullable = false, precision = 10, scale = 3)
	public Double getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setGoodsWeight(Double goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	@Column(name = "market_price", nullable = false, precision = 10)
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

	@Column(name = "promote_price", nullable = false, precision = 10)
	public Double getPromotePrice() {
		return this.promotePrice;
	}

	public void setPromotePrice(Double promotePrice) {
		this.promotePrice = promotePrice;
	}

	@Column(name = "promote_start_date", nullable = false)
	public Integer getPromoteStartDate() {
		return this.promoteStartDate;
	}

	public void setPromoteStartDate(Integer promoteStartDate) {
		this.promoteStartDate = promoteStartDate;
	}

	@Column(name = "promote_end_date", nullable = false)
	public Integer getPromoteEndDate() {
		return this.promoteEndDate;
	}

	public void setPromoteEndDate(Integer promoteEndDate) {
		this.promoteEndDate = promoteEndDate;
	}

	@Column(name = "warn_number", nullable = false)
	public Short getWarnNumber() {
		return this.warnNumber;
	}

	public void setWarnNumber(Short warnNumber) {
		this.warnNumber = warnNumber;
	}

	@Column(name = "keywords", nullable = false)
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

	@Column(name = "is_real", nullable = false)
	public Short getIsReal() {
		return this.isReal;
	}

	public void setIsReal(Short isReal) {
		this.isReal = isReal;
	}

	@Column(name = "extension_code", nullable = false, length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "is_on_sale", nullable = false)
	public Boolean getIsOnSale() {
		return this.isOnSale;
	}

	public void setIsOnSale(Boolean isOnSale) {
		this.isOnSale = isOnSale;
	}

	@Column(name = "is_alone_sale", nullable = false)
	public Boolean getIsAloneSale() {
		return this.isAloneSale;
	}

	public void setIsAloneSale(Boolean isAloneSale) {
		this.isAloneSale = isAloneSale;
	}

	@Column(name = "is_shipping", nullable = false)
	public Boolean getIsShipping() {
		return this.isShipping;
	}

	public void setIsShipping(Boolean isShipping) {
		this.isShipping = isShipping;
	}

	@Column(name = "integral", nullable = false)
	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_delete", nullable = false)
	public Boolean getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Column(name = "is_best", nullable = false)
	public Boolean getIsBest() {
		return this.isBest;
	}

	public void setIsBest(Boolean isBest) {
		this.isBest = isBest;
	}

	@Column(name = "is_new", nullable = false)
	public Boolean getIsNew() {
		return this.isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	@Column(name = "is_hot", nullable = false)
	public Boolean getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	@Column(name = "is_promote", nullable = false)
	public Boolean getIsPromote() {
		return this.isPromote;
	}

	public void setIsPromote(Boolean isPromote) {
		this.isPromote = isPromote;
	}

	@Column(name = "bonus_type_id", nullable = false)
	public Short getBonusTypeId() {
		return this.bonusTypeId;
	}

	public void setBonusTypeId(Short bonusTypeId) {
		this.bonusTypeId = bonusTypeId;
	}

	@Column(name = "last_update", nullable = false)
	public Integer getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Integer lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "goods_type", nullable = false)
	public Short getGoodsType() {
		return this.goodsType;
	}

	public void setGoodsType(Short goodsType) {
		this.goodsType = goodsType;
	}

	@Column(name = "seller_note", nullable = false)
	public String getSellerNote() {
		return this.sellerNote;
	}

	public void setSellerNote(String sellerNote) {
		this.sellerNote = sellerNote;
	}

	@Column(name = "give_integral", nullable = false)
	public Integer getGiveIntegral() {
		return this.giveIntegral;
	}

	public void setGiveIntegral(Integer giveIntegral) {
		this.giveIntegral = giveIntegral;
	}

	@Column(name = "rank_integral", nullable = false)
	public Integer getRankIntegral() {
		return this.rankIntegral;
	}

	public void setRankIntegral(Integer rankIntegral) {
		this.rankIntegral = rankIntegral;
	}

	@Column(name = "suppliers_id")
	public Short getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Short suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "is_check")
	public Boolean getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

}