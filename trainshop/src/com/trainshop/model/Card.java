package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Card entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "card", catalog = "trainshop")
public class Card implements java.io.Serializable {

	// Fields

	private Short cardId;
	private String cardName;
	private String cardImg;
	private Double cardFee;
	private Double freeMoney;
	private String cardDesc;

	// Constructors

	/** default constructor */
	public Card() {
	}

	/** full constructor */
	public Card(String cardName, String cardImg, Double cardFee,
			Double freeMoney, String cardDesc) {
		this.cardName = cardName;
		this.cardImg = cardImg;
		this.cardFee = cardFee;
		this.freeMoney = freeMoney;
		this.cardDesc = cardDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "card_id", unique = true, nullable = false)
	public Short getCardId() {
		return this.cardId;
	}

	public void setCardId(Short cardId) {
		this.cardId = cardId;
	}

	@Column(name = "card_name", nullable = false, length = 120)
	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Column(name = "card_img", nullable = false)
	public String getCardImg() {
		return this.cardImg;
	}

	public void setCardImg(String cardImg) {
		this.cardImg = cardImg;
	}

	@Column(name = "card_fee", nullable = false, precision = 6)
	public Double getCardFee() {
		return this.cardFee;
	}

	public void setCardFee(Double cardFee) {
		this.cardFee = cardFee;
	}

	@Column(name = "free_money", nullable = false, precision = 6)
	public Double getFreeMoney() {
		return this.freeMoney;
	}

	public void setFreeMoney(Double freeMoney) {
		this.freeMoney = freeMoney;
	}

	@Column(name = "card_desc", nullable = false)
	public String getCardDesc() {
		return this.cardDesc;
	}

	public void setCardDesc(String cardDesc) {
		this.cardDesc = cardDesc;
	}

}