package com.trainshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;

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
	private Integer orderStatus;
	private Integer shippingStatus;
	private Integer payStatus;
	private String consignee;
	private Integer country;
	private Integer province;
	private Integer city;
	private Integer district;
	private String address;
	private String zipcode;
	private String trainNumber;
	private String carriage;
	private String seatNumber;
	private String startTime;
	private String tel;
	private String mobile;
	private String email;
	private String bestTime;
	private String signBuilding;
	private String postscript;
	private Integer shippingId;
	private String shippingName;
	private Integer payId;
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
	private Integer fromAd;
	private String referer;
	private Long addTime;
	private Long confirmTime;
	private Long payTime;
	private Long shippingTime;
	private Integer packId;
	private Integer cardId;
	private Integer bonusId;
	private String invoiceNo;
	private String extensionCode;
	private Integer extensionId;
	private String toBuyer;
	private String payNote;
	private Integer agencyId;
	private String invType;
	private Double tax;
	private Integer isSeparate;
	private Integer parentId;
	private Double discount;

	private List<OrderGoods> orderGoods;

	private int start = 0;
	private int limit = 10;

	@Transient
	public List<OrderGoods> getOrderGoods() {
		return orderGoods;
	}

	@Transient
	public void setOrderGoods(List<OrderGoods> orderGoods) {
		this.orderGoods = orderGoods;
	}

	@Transient
	public int getStart() {
		return start;
	}

	@Transient
	public void setStart(int start) {
		this.start = start;
	}

	@Transient
	public int getLimit() {
		return limit;
	}

	@Transient
	public void setLimit(int limit) {
		this.limit = limit;
	}

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(String orderSn, Long userId, Integer orderStatus,
			Integer shippingStatus, Integer payStatus, Double goodsAmount,
			Double shippingFee, Double orderAmount, Long addTime,
			Integer isSeparate) {
		this.orderSn = orderSn;
		this.userId = userId;
		this.orderStatus = orderStatus;
		this.shippingStatus = shippingStatus;
		this.payStatus = payStatus;
		this.goodsAmount = goodsAmount;
		this.shippingFee = shippingFee;
		this.orderAmount = orderAmount;
		this.addTime = addTime;
		this.isSeparate = isSeparate;
	}

	/** full constructor */
	public OrderInfo(String orderSn, Long userId, Integer orderStatus,
			Integer shippingStatus, Integer payStatus, String consignee,
			Integer country, Integer province, Integer city, Integer district,
			String address, String zipcode, String trainNumber,
			String carriage, String seatNumber, String startTime, String tel,
			String mobile, String email, String bestTime, String signBuilding,
			String postscript, Integer shippingId, String shippingName,
			Integer payId, String payName, String howOos, String howSurplus,
			String packName, String cardName, String cardMessage,
			String invPayee, String invContent, Double goodsAmount,
			Double shippingFee, Double insureFee, Double payFee,
			Double packFee, Double cardFee, Double moneyPaid, Double surplus,
			Integer integral, Double integralMoney, Double bonus,
			Double orderAmount, Integer fromAd, String referer, Long addTime,
			Long confirmTime, Long payTime, Long shippingTime, Integer packId,
			Integer cardId, Integer bonusId, String invoiceNo,
			String extensionCode, Integer extensionId, String toBuyer,
			String payNote, Integer agencyId, String invType, Double tax,
			Integer isSeparate, Integer parentId, Double discount) {
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
		this.trainNumber = trainNumber;
		this.carriage = carriage;
		this.seatNumber = seatNumber;
		this.startTime = startTime;
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

	@Column(name = "order_sn", unique = true, nullable = false, length = 60)
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
	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "shipping_status", nullable = false)
	public Integer getShippingStatus() {
		return this.shippingStatus;
	}

	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	@Column(name = "pay_status", nullable = false)
	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	@Column(name = "consignee", length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "country")
	public Integer getCountry() {
		return this.country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	@Column(name = "province")
	public Integer getProvince() {
		return this.province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	@Column(name = "city")
	public Integer getCity() {
		return this.city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	@Column(name = "district")
	public Integer getDistrict() {
		return this.district;
	}

	public void setDistrict(Integer district) {
		this.district = district;
	}

	@Column(name = "address")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", length = 60)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "train_number", length = 30)
	public String getTrainNumber() {
		return this.trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	@Column(name = "carriage", length = 20)
	public String getCarriage() {
		return this.carriage;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}

	@Column(name = "Seat_Number", length = 20)
	public String getSeatNumber() {
		return this.seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Column(name = "start_time", length = 20)
	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "tel", length = 60)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "mobile", length = 60)
	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "best_time", length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	@Column(name = "sign_building", length = 120)
	public String getSignBuilding() {
		return this.signBuilding;
	}

	public void setSignBuilding(String signBuilding) {
		this.signBuilding = signBuilding;
	}

	@Column(name = "postscript")
	public String getPostscript() {
		return this.postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	@Column(name = "shipping_id")
	public Integer getShippingId() {
		return this.shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	@Column(name = "shipping_name", length = 120)
	public String getShippingName() {
		return this.shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	@Column(name = "pay_id")
	public Integer getPayId() {
		return this.payId;
	}

	public void setPayId(Integer payId) {
		this.payId = payId;
	}

	@Column(name = "pay_name", length = 120)
	public String getPayName() {
		return this.payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	@Column(name = "how_oos", length = 120)
	public String getHowOos() {
		return this.howOos;
	}

	public void setHowOos(String howOos) {
		this.howOos = howOos;
	}

	@Column(name = "how_surplus", length = 120)
	public String getHowSurplus() {
		return this.howSurplus;
	}

	public void setHowSurplus(String howSurplus) {
		this.howSurplus = howSurplus;
	}

	@Column(name = "pack_name", length = 120)
	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	@Column(name = "card_name", length = 120)
	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Column(name = "card_message")
	public String getCardMessage() {
		return this.cardMessage;
	}

	public void setCardMessage(String cardMessage) {
		this.cardMessage = cardMessage;
	}

	@Column(name = "inv_payee", length = 120)
	public String getInvPayee() {
		return this.invPayee;
	}

	public void setInvPayee(String invPayee) {
		this.invPayee = invPayee;
	}

	@Column(name = "inv_content", length = 120)
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

	@Column(name = "insure_fee", precision = 10)
	public Double getInsureFee() {
		return this.insureFee;
	}

	public void setInsureFee(Double insureFee) {
		this.insureFee = insureFee;
	}

	@Column(name = "pay_fee", precision = 10)
	public Double getPayFee() {
		return this.payFee;
	}

	public void setPayFee(Double payFee) {
		this.payFee = payFee;
	}

	@Column(name = "pack_fee", precision = 10)
	public Double getPackFee() {
		return this.packFee;
	}

	public void setPackFee(Double packFee) {
		this.packFee = packFee;
	}

	@Column(name = "card_fee", precision = 10)
	public Double getCardFee() {
		return this.cardFee;
	}

	public void setCardFee(Double cardFee) {
		this.cardFee = cardFee;
	}

	@Column(name = "money_paid", precision = 10)
	public Double getMoneyPaid() {
		return this.moneyPaid;
	}

	public void setMoneyPaid(Double moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	@Column(name = "surplus", precision = 10)
	public Double getSurplus() {
		return this.surplus;
	}

	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}

	@Column(name = "integral")
	public Integer getIntegral() {
		return this.integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	@Column(name = "integral_money", precision = 10)
	public Double getIntegralMoney() {
		return this.integralMoney;
	}

	public void setIntegralMoney(Double integralMoney) {
		this.integralMoney = integralMoney;
	}

	@Column(name = "bonus", precision = 10)
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

	@Column(name = "from_ad")
	public Integer getFromAd() {
		return this.fromAd;
	}

	public void setFromAd(Integer fromAd) {
		this.fromAd = fromAd;
	}

	@Column(name = "referer")
	public String getReferer() {
		return this.referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Column(name = "add_time", nullable = false)
	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
	}

	@Column(name = "confirm_time")
	public Long getConfirmTime() {
		return this.confirmTime;
	}

	public void setConfirmTime(Long confirmTime) {
		this.confirmTime = confirmTime;
	}

	@Column(name = "pay_time")
	public Long getPayTime() {
		return this.payTime;
	}

	public void setPayTime(Long payTime) {
		this.payTime = payTime;
	}

	@Column(name = "shipping_time")
	public Long getShippingTime() {
		return this.shippingTime;
	}

	public void setShippingTime(Long shippingTime) {
		this.shippingTime = shippingTime;
	}

	@Column(name = "pack_id")
	public Integer getPackId() {
		return this.packId;
	}

	public void setPackId(Integer packId) {
		this.packId = packId;
	}

	@Column(name = "card_id")
	public Integer getCardId() {
		return this.cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	@Column(name = "bonus_id")
	public Integer getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Integer bonusId) {
		this.bonusId = bonusId;
	}

	@Column(name = "invoice_no")
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "extension_code", length = 30)
	public String getExtensionCode() {
		return this.extensionCode;
	}

	public void setExtensionCode(String extensionCode) {
		this.extensionCode = extensionCode;
	}

	@Column(name = "extension_id")
	public Integer getExtensionId() {
		return this.extensionId;
	}

	public void setExtensionId(Integer extensionId) {
		this.extensionId = extensionId;
	}

	@Column(name = "to_buyer")
	public String getToBuyer() {
		return this.toBuyer;
	}

	public void setToBuyer(String toBuyer) {
		this.toBuyer = toBuyer;
	}

	@Column(name = "pay_note")
	public String getPayNote() {
		return this.payNote;
	}

	public void setPayNote(String payNote) {
		this.payNote = payNote;
	}

	@Column(name = "agency_id")
	public Integer getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

	@Column(name = "inv_type", length = 60)
	public String getInvType() {
		return this.invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}

	@Column(name = "tax", precision = 10)
	public Double getTax() {
		return this.tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	@Column(name = "is_separate", nullable = false)
	public Integer getIsSeparate() {
		return this.isSeparate;
	}

	public void setIsSeparate(Integer isSeparate) {
		this.isSeparate = isSeparate;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "discount", precision = 10)
	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
}