package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VirtualCard entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "virtual_card", catalog = "trainshop")
public class VirtualCard implements java.io.Serializable {

	// Fields

	private Integer cardId;
	private Integer goodsId;
	private String cardSn;
	private String cardPassword;
	private Integer addDate;
	private Integer endDate;
	private Boolean isSaled;
	private String orderSn;
	private String crc32;

	// Constructors

	/** default constructor */
	public VirtualCard() {
	}

	/** full constructor */
	public VirtualCard(Integer goodsId, String cardSn, String cardPassword,
			Integer addDate, Integer endDate, Boolean isSaled, String orderSn,
			String crc32) {
		this.goodsId = goodsId;
		this.cardSn = cardSn;
		this.cardPassword = cardPassword;
		this.addDate = addDate;
		this.endDate = endDate;
		this.isSaled = isSaled;
		this.orderSn = orderSn;
		this.crc32 = crc32;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "card_id", unique = true, nullable = false)
	public Integer getCardId() {
		return this.cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "card_sn", nullable = false, length = 60)
	public String getCardSn() {
		return this.cardSn;
	}

	public void setCardSn(String cardSn) {
		this.cardSn = cardSn;
	}

	@Column(name = "card_password", nullable = false, length = 60)
	public String getCardPassword() {
		return this.cardPassword;
	}

	public void setCardPassword(String cardPassword) {
		this.cardPassword = cardPassword;
	}

	@Column(name = "add_date", nullable = false)
	public Integer getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Integer addDate) {
		this.addDate = addDate;
	}

	@Column(name = "end_date", nullable = false)
	public Integer getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Integer endDate) {
		this.endDate = endDate;
	}

	@Column(name = "is_saled", nullable = false)
	public Boolean getIsSaled() {
		return this.isSaled;
	}

	public void setIsSaled(Boolean isSaled) {
		this.isSaled = isSaled;
	}

	@Column(name = "order_sn", nullable = false, length = 20)
	public String getOrderSn() {
		return this.orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}

	@Column(name = "crc32", nullable = false, length = 12)
	public String getCrc32() {
		return this.crc32;
	}

	public void setCrc32(String crc32) {
		this.crc32 = crc32;
	}

}