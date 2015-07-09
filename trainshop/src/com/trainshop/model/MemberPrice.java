package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MemberPrice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_price", catalog = "trainshop")
public class MemberPrice implements java.io.Serializable {

	// Fields

	private Integer priceId;
	private Integer goodsId;
	private Short userRank;
	private Double userPrice;

	// Constructors

	/** default constructor */
	public MemberPrice() {
	}

	/** full constructor */
	public MemberPrice(Integer goodsId, Short userRank, Double userPrice) {
		this.goodsId = goodsId;
		this.userRank = userRank;
		this.userPrice = userPrice;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "price_id", unique = true, nullable = false)
	public Integer getPriceId() {
		return this.priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "user_rank", nullable = false)
	public Short getUserRank() {
		return this.userRank;
	}

	public void setUserRank(Short userRank) {
		this.userRank = userRank;
	}

	@Column(name = "user_price", nullable = false, precision = 10)
	public Double getUserPrice() {
		return this.userPrice;
	}

	public void setUserPrice(Double userPrice) {
		this.userPrice = userPrice;
	}

}