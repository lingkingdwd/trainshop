package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ExchangeGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exchange_goods", catalog = "trainshop")
public class ExchangeGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Integer exchangeIntegral;
	private Boolean isExchange;
	private Boolean isHot;

	// Constructors

	/** default constructor */
	public ExchangeGoods() {
	}

	/** full constructor */
	public ExchangeGoods(Integer goodsId, Integer exchangeIntegral,
			Boolean isExchange, Boolean isHot) {
		this.goodsId = goodsId;
		this.exchangeIntegral = exchangeIntegral;
		this.isExchange = isExchange;
		this.isHot = isHot;
	}

	// Property accessors
	@Id
	@Column(name = "goods_id", unique = true, nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "exchange_integral", nullable = false)
	public Integer getExchangeIntegral() {
		return this.exchangeIntegral;
	}

	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}

	@Column(name = "is_exchange", nullable = false)
	public Boolean getIsExchange() {
		return this.isExchange;
	}

	public void setIsExchange(Boolean isExchange) {
		this.isExchange = isExchange;
	}

	@Column(name = "is_hot", nullable = false)
	public Boolean getIsHot() {
		return this.isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

}