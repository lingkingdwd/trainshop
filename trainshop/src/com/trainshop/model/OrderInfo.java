package com.trainshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "order_info", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "order_sn"))
public class OrderInfo implements java.io.Serializable {

	// Fields

	private Long orderId;
	private String orderSn;
	private Long userId;
	private Boolean orderStatus;
	private Boolean shippingStatus;
	private Boolean payStatus;
	private String consignee;
	private Short country;
	private Short province;
	private Short city;
	private Short district;
	private String address;
	private String zipcode;
	private String tel;
	private String mobile;
	private String email;
	private String bestTime;
	private String signBuilding;
	private String postscript;
	private Short shippingId;
	private String shippingName;
	private Short payId;
	private String payName;
	private String howOos;
	private String howSurplus;
	private String packName;
	private String cardName;
	private String cardMessage;
	private String invPayee;
	private String invContent;
	private Double goodsAmount;
	private Double shippingFee;
	private Double insureFee;
	private Double payFee;
	private Double packFee;
	private Double cardFee;
	private Double moneyPaid;
	private Double surplus;
	private Integer integral;
	private Double integralMoney;
	private Double bonus;
	private Double orderAmount;
	private Short fromAd;
	private String referer;
	private Integer addTime;
	private Integer confirmTime;
	private Integer payTime;
	private Integer shippingTime;
	private Short packId;
	private Short cardId;
	private Integer bonusId;
	private String invoiceNo;
	private String extensionCode;
	private Integer extensionId;
	private String toBuyer;
	private String payNote;
	private Short agencyId;
	private String invType;
	private Double tax;
	private Boolean isSeparate;
	private Integer parentId;
	private Double discount;
	
	private List<OrderGoods> orderGoods;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** full constructor */
	public OrderInfo(String orderSn, Long userId, Boolean orderStatus,
			Boolean shippingStatus, Boolean payStatus, String consignee,
			Short country, Short province, Short city, Short district,
			String address, String zipcode, String tel, String mobile,
			String email, String bestTime, String signBuilding,
			String postscript, Short shippingId, String shippingName,
			Short payId, String payName, String howOos, String howSurplus,
			String packName, String cardName, String cardMessage,
			String invPayee, String invContent, Double goodsAmount,
			Double shippingFee, Double insureFee, Double payFee,
			Double packFee, Double cardFee, Double moneyPaid, Double surplus,
			Integer integral, Double integralMoney, Double bonus,
			Double orderAmount, Short fromAd, String referer, Integer addTime,
			Integer confirmTime, Integer payTime, Integer shippingTime,
			Short packId, Short cardId, Integer bonusId, String invoiceNo,
			String extensionCode, Integer extensionId, String toBuyer,
			String payNote, Short agencyId, String invType, Double tax,
			Boolean isSeparate, Integer parentId, Double discount) {
		this.orderSn = orderSn;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.shippingStatus = shippingStatus;
		this.payStatus = payStatus;
		this.consignee = consignee;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.address = address;
		this.zipcode = zipcode;
		this.tel = tel;
		this.mobile = mobile;
		this.email = email;
		this.bestTime = bestTime;
		this.signBuilding = signBuilding;
		this.postscript = postscript;
		this.shippingId = shippingId;
		this.shippingName = shippingName;
		this.payId = payId;
		this.payName = payName;
		this.howOos = howOos;
		this.howSurplus = howSurplus;
		this.packName = packName;
		this.cardName = cardName;
		this.cardMessage = cardMessage;
		this.invPayee = invPayee;
		this.invContent = invContent;
		this.goodsAmount = goodsAmount;
		this.shippingFee = shippingFee;
		this.insureFee = insureFee;
		this.payFee = payFee;
		this.packFee = packFee;
		this.cardFee = cardFee;
		this.moneyPaid = moneyPaid;
		this.surplus = surplus;
		this.integral = integral;
		this.integralMoney = integralMoney;
		this.bonus = bonus;
		this.orderAmount = orderAmount;
		this.fromAd = fromAd;
		this.referer = referer;
		this.addTime = addTime;
		this.confirmTime = confirmTime;
		this.payTime = payTime;
		this.shippingTime = shippingTime;
		this.packId = packId;
		this.cardId = cardId;
		this.bonusId = bonusId;
		this.invoiceNo = invoiceNo;
		this.extensionCode = extensionCode;
		this.extensionId = extensionId;
		this.toBuyer = toBuyer;
		this.payNote = payNote;
		this.agencyId = agencyId;
		this.invType = invType;
		this.tax = tax;
		this.isSeparate = isSeparate;
		this.parentId = parentId;
		this.discount = discount;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "order_id", unique = true, nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "order_sn", unique = true, nullable = false, length = 20)
	public String getOrderSn() {
		return this.orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "order_status", nullable = false)
	public Boolean getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "shipping_status", nullable = false)
	public Boolean getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(Boolean shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Column(name = "pay_status", nullable = false)
	public Boolean getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Boolean payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "consignee", nullable = false, length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "country", nullable = false)
	public Short getCountry() {
		return this.country;
	}

	public void setCountry(Short country) {
		this.country = country;
	}

	@Column(name = "province", nullable = false)
	public Short getProvince() {
		return this.province;
	}

	public void setProvince(Short province) {
		this.province = province;
	}

	@Column(name = "city", nullable = false)
	public Short getCity() {
		return this.city;
	}

	public void setCity(Short city) {
		this.city = city;
	}

	@Column(name = "district", nullable = false)
	public Short getDistrict() {
		return this.district;
	}

	public void setDistrict(Short district) {
		this.district = district;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", nullable = false, length = 60)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "tel", nullable = false, length = 60)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", nullable = false, length = 60)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "best_time", nullable = false, length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	@Column(name = "sign_building", nullable = false, length = 120)
	public String getSignBuilding() {
		return this.signBuilding;
	}

	public void setSignBuilding(String signBuilding) {
		this.signBuilding = signBuilding;
	}

	@Column(name = "postscript", nullable = false)
	public String getPostscript() {
		return this.postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	@Column(name = "shipping_id", nullable = false)
	public Short getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Short shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "shipping_name", nullable = false, length = 120)
	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name = "pay_id", nullable = false)
	public Short getPayId() {
		return this.payId;
	}

	public void setPayId(Short payId) {
		this.payId = payId;
	}

	@Column(name = "pay_name", nullable = false, length = 120)
	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	@Column(name = "how_oos", nullable = false, length = 120)
	public String getHowOos() {
		return this.howOos;
	}

	public void setHowOos(String howOos) {
		this.howOos = howOos;
	}

	@Column(name = "how_surplus", nullable = false, length = 120)
	public String getHowSurplus() {
		return this.howSurplus;
	}

	public void setHowSurplus(String howSurplus) {
		this.howSurplus = howSurplus;
	}

	@Column(name = "pack_name", nullable = false, length = 120)
	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	@Column(name = "card_name", nullable = false, length = 120)
	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Column(name = "card_message", nullable = false)
	public String getCardMessage() {
		return this.cardMessage;
	}

	public void setCardMessage(String cardMessage) {
		this.cardMessage = cardMessage;
	}

	@Column(name = "inv_payee", nullable = false, length = 120)
	public String getInvPayee() {
		return this.invPayee;
	}

	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}

	@Column(name = "inv_content", nullable = false, length = 120)
	public String getInvContent() {
		return this.invContent;
	}

	public void setInvContent(String invContent) {
		this.invContent = invContent;
	}

	@Column(name = "goods_amount", nullable = false, precision = 10)
	public Double getGoodsAmount() {
		return this.goodsAmount;
	}

	public void setGoodsAmount(Double goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	@Column(name = "shipping_fee", nullable = false, precision = 10)
	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "insure_fee", nullable = false, precision = 10)
	public Double getInsureFee() {
		return this.insureFee;
	}

	public void setInsureFee(Double insureFee) {
		this.insureFee = insureFee;
	}

	@Column(name = "pay_fee", nullable = false, precision = 10)
	public Double getPayFee() {
		return this.payFee;
	}

	public void setPayFee(Double payFee) {
		this.payFee = payFee;
	}

	@Column(name = "pack_fee", nullable = false, precision = 10)
	public Double getPackFee() {
		return this.packFee;
	}

	public void setPackFee(Double packFee) {
		this.packFee = packFee;
	}

	@Column(name = "card_fee", nullable = false, precision = 10)
	public Double getCardFee() {
		return this.cardFee;
	}

	public void setCardFee(Double cardFee) {
		this.cardFee = cardFee;
	}

	@Column(name = "money_paid", nullable = false, precision = 10)
	public Double getMoneyPaid() {
		return this.moneyPaid;
	}

	public void setMoneyPaid(Double moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	@Column(name = "surplus", nullable = false, precision = 10)
	public Double getSurplus() {
		return this.surplus;
	}

	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}

	@Column(name = "integral", nullable = false)
	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Column(name = "integral_money", nullable = false, precision = 10)
	public Double getIntegralMoney() {
		return this.integralMoney;
	}

	public void setIntegralMoney(Double integralMoney) {
		this.integralMoney = integralMoney;
	}

	@Column(name = "bonus", nullable = false, precision = 10)
	public Double getBonus() {
		return this.bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}

	@Column(name = "order_amount", nullable = false, precision = 10)
	public Double getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Column(name = "from_ad", nullable = false)
	public Short getFromAd() {
		return this.fromAd;
	}

	public void setFromAd(Short fromAd) {
		this.fromAd = fromAd;
	}

	@Column(name = "referer", nullable = false)
	public String getReferer() {
		return this.referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "confirm_time", nullable = false)
	public Integer getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Integer confirmTime) {
		this.confirmTime = confirmTime;
	}

	@Column(name = "pay_time", nullable = false)
	public Integer getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}

	@Column(name = "shipping_time", nullable = false)
	public Integer getShippingTime() {
		return this.shippingTime;
	}

	public void setShippingTime(Integer shippingTime) {
		this.shippingTime = shippingTime;
	}

	@Column(name = "pack_id", nullable = false)
	public Short getPackId() {
		return this.packId;
	}

	public void setPackId(Short packId) {
		this.packId = packId;
	}

	@Column(name = "card_id", nullable = false)
	public Short getCardId() {
		return this.cardId;
	}

	public void setCardId(Short cardId) {
		this.cardId = cardId;
	}

	@Column(name = "bonus_id", nullable = false)
	public Integer getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Integer bonusId) {
		this.bonusId = bonusId;
	}

	@Column(name = "invoice_no", nullable = false)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "extension_code", nullable = false, length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "extension_id", nullable = false)
	public Integer getExtensionId() {
		return this.extensionId;
	}

	public void setExtensionId(Integer extensionId) {
		this.extensionId = extensionId;
	}

	@Column(name = "to_buyer", nullable = false)
	public String getToBuyer() {
		return this.toBuyer;
	}

	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}

	@Column(name = "pay_note", nullable = false)
	public String getPayNote() {
		return this.payNote;
	}

	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

	@Column(name = "agency_id", nullable = false)
	public Short getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Short agencyId) {
		this.agencyId = agencyId;
	}

	@Column(name = "inv_type", nullable = false, length = 60)
	public String getInvType() {
		return this.invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	@Column(name = "tax", nullable = false, precision = 10)
	public Double getTax() {
		return this.tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@Column(name = "is_separate", nullable = false)
	public Boolean getIsSeparate() {
		return this.isSeparate;
	}

	public void setIsSeparate(Boolean isSeparate) {
		this.isSeparate = isSeparate;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "discount", nullable = false, precision = 10)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public List<OrderGoods> getOrderGoods() {
		return orderGoods;
	}

	public void setOrderGoods(List<OrderGoods> orderGoods) {
		this.orderGoods = orderGoods;
	}
}