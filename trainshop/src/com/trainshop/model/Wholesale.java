package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Wholesale entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "wholesale", catalog = "trainshop")
public class Wholesale implements java.io.Serializable {

	// Fields

	private Integer actId;
	private Integer goodsId;
	private String goodsName;
	private String rankIds;
	private String prices;
	private Short enabled;

	// Constructors

	/** default constructor */
	public Wholesale() {
	}

	/** full constructor */
	public Wholesale(Integer goodsId, String goodsName, String rankIds,
			String prices, Short enabled) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.rankIds = rankIds;
		this.prices = prices;
		this.enabled = enabled;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "act_id", unique = true, nullable = false)
	public Integer getActId() {
		return this.actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "goods_name", nullable = false)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "rank_ids", nullable = false)
	public String getRankIds() {
		return this.rankIds;
	}

	public void setRankIds(String rankIds) {
		this.rankIds = rankIds;
	}

	@Column(name = "prices", nullable = false, length = 65535)
	public String getPrices() {
		return this.prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	@Column(name = "enabled", nullable = false)
	public Short getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Short enabled) {
		this.enabled = enabled;
	}

}