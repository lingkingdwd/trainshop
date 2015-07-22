package com.trainshop.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TrainGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "train_goods", catalog = "trainshop")
public class TrainGoods implements java.io.Serializable {

	// Fields

	private Long pkid;
	private Long goodsId;
	private Long trainId;
	private Integer goodsNumber;
	private Double shopPrice;
	private Double promotePrice;
	private Long promoteStartDate;
	private Long promoteEndDate;
	private Integer warnNumber;
	private String remark;
//	private Set<Goods> goods;
//
//	// Constructors
//    @OneToMany
//    @JoinColumn(name="GOODS_ID")
//	public Set<Goods> getGoods() {
//		return goods;
//	}
//
//	public void setGoods(Set<Goods> goods) {
//		this.goods = goods;
//	}

	/** default constructor */
	public TrainGoods() {
	}

	/** minimal constructor */
	public TrainGoods(Long pkid, Integer goodsNumber, Double shopPrice) {
		this.pkid = pkid;
		this.goodsNumber = goodsNumber;
		this.shopPrice = shopPrice;
	}

	/** full constructor */
	public TrainGoods(Long pkid, Long goodsId, Long trainId,
			Integer goodsNumber, Double shopPrice, Double promotePrice,
			Long promoteStartDate, Long promoteEndDate, Integer warnNumber,
			String remark) {
		this.pkid = pkid;
		this.goodsId = goodsId;
		this.trainId = trainId;
		this.goodsNumber = goodsNumber;
		this.shopPrice = shopPrice;
		this.promotePrice = promotePrice;
		this.promoteStartDate = promoteStartDate;
		this.promoteEndDate = promoteEndDate;
		this.warnNumber = warnNumber;
		this.remark = remark;
	}

	// Property accessors
	@Id
	@Column(name = "PKID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getPkid() {
		return this.pkid;
	}

	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}

	@Column(name = "goods_id")
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "train_ID")
	public Long getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	@Column(name = "goods_number", nullable = false)
	public Integer getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Integer goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	@Column(name = "shop_price", nullable = false, precision = 10)
	public Double getShopPrice() {
		return this.shopPrice;
	}

	public void setShopPrice(Double shopPrice) {
		this.shopPrice = shopPrice;
	}

	@Column(name = "promote_price", precision = 10)
	public Double getPromotePrice() {
		return this.promotePrice;
	}

	public void setPromotePrice(Double promotePrice) {
		this.promotePrice = promotePrice;
	}

	@Column(name = "promote_start_date")
	public Long getPromoteStartDate() {
		return this.promoteStartDate;
	}

	public void setPromoteStartDate(Long promoteStartDate) {
		this.promoteStartDate = promoteStartDate;
	}

	@Column(name = "promote_end_date")
	public Long getPromoteEndDate() {
		return this.promoteEndDate;
	}

	public void setPromoteEndDate(Long promoteEndDate) {
		this.promoteEndDate = promoteEndDate;
	}

	@Column(name = "warn_number")
	public Integer getWarnNumber() {
		return this.warnNumber;
	}

	public void setWarnNumber(Integer warnNumber) {
		this.warnNumber = warnNumber;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
