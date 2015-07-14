package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DeliveryOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "delivery_order", catalog = "trainshop")
public class DeliveryOrder implements java.io.Serializable {

	// Fields

	private Long deliveryId;
	private String deliverySn;
	private String orderSn;
	private Long orderId;
	private String invoiceNo;
	private Long addTime;
	private Integer shippingId;
	private String shippingName;
	private Integer userId;
	private String actionUser;
	private String consignee;
	private String address;
	private Integer country;
	private Integer province;
	private Integer city;
	private Integer district;
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
	private Integer updateTime;
	private Integer suppliersId;
	private Integer status;
	private Integer agencyId;

	// Constructors

	/** default constructor */
	public DeliveryOrder() {
	}

	/** minimal constructor */
	public DeliveryOrder(String deliverySn, String orderSn, Long orderId,
			Integer status) {
		this.deliverySn = deliverySn;
		this.orderSn = orderSn;
		this.orderId = orderId;
		this.status = status;
	}

	/** full constructor */
	public DeliveryOrder(String deliverySn, String orderSn, Long orderId,
			String invoiceNo, Long addTime, Integer shippingId,
			String shippingName, Integer userId, String actionUser,
			String consignee, String address, Integer country,
			Integer province, Integer city, Integer district,
			String signBuilding, String email, String zipcode, String tel,
			String mobile, String bestTime, String postscript, String howOos,
			Double insureFee, Double shippingFee, Integer updateTime,
			Integer suppliersId, Integer status, Integer agencyId) {
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
		this.agencyId = agencyId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "delivery_id", unique = true, nullable = false)
	public Long getDeliveryId() {
		return this.deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
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
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
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
	public Integer getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "suppliers_id")
	public Integer getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Integer suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "agency_id")
	public Integer getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Integer agencyId) {
		this.agencyId = agencyId;
	}

}