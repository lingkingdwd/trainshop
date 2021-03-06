package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BackOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "back_order", catalog = "trainshop")
public class BackOrder implements java.io.Serializable {

	// Fields

	private Long backId;
	private String deliverySn;
	private String orderSn;
	private Long orderId;
	private String invoiceNo;
	private Long addTime;
	private Integer shippingId;
	private String shippingName;
	private Long userId;
	private String actionUser;
	private String consignee;
	private String address;
	private Long country;
	private Long province;
	private Long city;
	private Long district;
	private String signBuilding;
	private String email;
	private String zipcode;
	private String tel;
	private String mobile;
	private String bestTime;
	private String postscript;
	private String howOos;
	private Double insureFee;
	private Double shippingFee;
	private Long updateTime;
	private Long suppliersId;
	private Integer status;
	private Integer returnTime;
	private Integer agencyId;

	// Constructors

	/** default constructor */
	public BackOrder() {
	}

	/** minimal constructor */
	public BackOrder(String deliverySn, String orderSn, Long orderId,
			Integer status) {
		this.deliverySn = deliverySn;
		this.orderSn = orderSn;
		this.orderId = orderId;
		this.status = status;
	}

	/** full constructor */
	public BackOrder(String deliverySn, String orderSn, Long orderId,
			String invoiceNo, Long addTime, Integer shippingId,
			String shippingName, Long userId, String actionUser,
			String consignee, String address, Long country, Long province,
			Long city, Long district, String signBuilding, String email,
			String zipcode, String tel, String mobile, String bestTime,
			String postscript, String howOos, Double insureFee,
			Double shippingFee, Long updateTime, Long suppliersId,
			Integer status, Integer returnTime, Integer agencyId) {
		this.deliverySn = deliverySn;
		this.orderSn = orderSn;
		this.orderId = orderId;
		this.invoiceNo = invoiceNo;
		this.addTime = addTime;
		this.shippingId = shippingId;
		this.shippingName = shippingName;
		this.userId = userId;
		this.actionUser = actionUser;
		this.consignee = consignee;
		this.address = address;
		this.country = country;
		this.province = province;
		this.city = city;
		this.district = district;
		this.signBuilding = signBuilding;
		this.email = email;
		this.zipcode = zipcode;
		this.tel = tel;
		this.mobile = mobile;
		this.bestTime = bestTime;
		this.postscript = postscript;
		this.howOos = howOos;
		this.insureFee = insureFee;
		this.shippingFee = shippingFee;
		this.updateTime = updateTime;
		this.suppliersId = suppliersId;
		this.status = status;
		this.returnTime = returnTime;
		this.agencyId = agencyId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "back_id", unique = true, nullable = false)
	public Long getBackId() {
		return this.backId;
	}

	public void setBackId(Long backId) {
		this.backId = backId;
	}

	@Column(name = "delivery_sn", nullable = false, length = 20)
	public String getDeliverySn() {
		return this.deliverySn;
	}

	public void setDeliverySn(String deliverySn) {
		this.deliverySn = deliverySn;
	}

	@Column(name = "order_sn", nullable = false, length = 20)
	public String getOrderSn() {
		return this.orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "invoice_no", length = 50)
	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "add_time")
	public Long getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Long addTime) {
		this.addTime = addTime;
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

	@Column(name = "user_id")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "action_user", length = 30)
	public String getActionUser() {
		return this.actionUser;
	}

	public void setActionUser(String actionUser) {
		this.actionUser = actionUser;
	}

	@Column(name = "consignee", length = 60)
	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Column(name = "address", length = 250)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "country")
	public Long getCountry() {
		return this.country;
	}

	public void setCountry(Long country) {
		this.country = country;
	}

	@Column(name = "province")
	public Long getProvince() {
		return this.province;
	}

	public void setProvince(Long province) {
		this.province = province;
	}

	@Column(name = "city")
	public Long getCity() {
		return this.city;
	}

	public void setCity(Long city) {
		this.city = city;
	}

	@Column(name = "district")
	public Long getDistrict() {
		return this.district;
	}

	public void setDistrict(Long district) {
		this.district = district;
	}

	@Column(name = "sign_building", length = 120)
	public String getSignBuilding() {
		return this.signBuilding;
	}

	public void setSignBuilding(String signBuilding) {
		this.signBuilding = signBuilding;
	}

	@Column(name = "email", length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "zipcode", length = 60)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	@Column(name = "best_time", length = 120)
	public String getBestTime() {
		return this.bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	@Column(name = "postscript")
	public String getPostscript() {
		return this.postscript;
	}

	public void setPostscript(String postscript) {
		this.postscript = postscript;
	}

	@Column(name = "how_oos", length = 120)
	public String getHowOos() {
		return this.howOos;
	}

	public void setHowOos(String howOos) {
		this.howOos = howOos;
	}

	@Column(name = "insure_fee", precision = 10)
	public Double getInsureFee() {
		return this.insureFee;
	}

	public void setInsureFee(Double insureFee) {
		this.insureFee = insureFee;
	}

	@Column(name = "shipping_fee", precision = 10)
	public Double getShippingFee() {
		return this.shippingFee;
	}

	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}

	@Column(name = "update_time")
	public Long getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "suppliers_id")
	public Long getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Long suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "return_time")
	public Integer getReturnTime() {
		return this.returnTime;
	}

	public void setReturnTime(Integer returnTime) {
		this.returnTime = returnTime;
	}

	@Column(name = "agency_id")
	public Integer getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

}