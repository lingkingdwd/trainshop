package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CollectGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "collect_goods", catalog = "trainshop")
public class CollectGoods implements java.io.Serializable {

	// Fields

	private Integer recId;
	private Integer userId;
	private Integer goodsId;
	private Integer addTime;
	private Boolean isAttention;

	// Constructors

	/** default constructor */
	public CollectGoods() {
	}

	/** full constructor */
	public CollectGoods(Integer userId, Integer goodsId, Integer addTime,
			Boolean isAttention) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.addTime = addTime;
		this.isAttention = isAttention;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rec_id", unique = true, nullable = false)
	public Integer getRecId() {
		return this.recId;
	}

	public void setRecId(Integer recId) {
		this.recId = recId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "is_attention", nullable = false)
	public Boolean getIsAttention() {
		return this.isAttention;
	}

	public void setIsAttention(Boolean isAttention) {
		this.isAttention = isAttention;
	}

}