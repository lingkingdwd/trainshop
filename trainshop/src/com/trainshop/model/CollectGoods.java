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

	private Long recId;
	private Long userId;
	private Long goodsId;
	private Integer addTime;
	private Integer isAttention;

	// Constructors

	/** default constructor */
	public CollectGoods() {
	}

	/** full constructor */
	public CollectGoods(Long userId, Long goodsId, Integer addTime,
			Integer isAttention) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.addTime = addTime;
		this.isAttention = isAttention;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rec_id", unique = true, nullable = false)
	public Long getRecId() {
		return this.recId;
	}

	public void setRecId(Long recId) {
		this.recId = recId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
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
	public Integer getIsAttention() {
		return this.isAttention;
	}

	public void setIsAttention(Integer isAttention) {
		this.isAttention = isAttention;
	}

}