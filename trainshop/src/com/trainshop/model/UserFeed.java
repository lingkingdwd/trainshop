package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserFeed entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_feed", catalog = "trainshop")
public class UserFeed implements java.io.Serializable {

	// Fields

	private Integer feedId;
	private Integer userId;
	private Integer valueId;
	private Integer goodsId;
	private Boolean feedType;
	private Boolean isFeed;

	// Constructors

	/** default constructor */
	public UserFeed() {
	}

	/** full constructor */
	public UserFeed(Integer userId, Integer valueId, Integer goodsId,
			Boolean feedType, Boolean isFeed) {
		this.userId = userId;
		this.valueId = valueId;
		this.goodsId = goodsId;
		this.feedType = feedType;
		this.isFeed = isFeed;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "feed_id", unique = true, nullable = false)
	public Integer getFeedId() {
		return this.feedId;
	}

	public void setFeedId(Integer feedId) {
		this.feedId = feedId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "value_id", nullable = false)
	public Integer getValueId() {
		return this.valueId;
	}

	public void setValueId(Integer valueId) {
		this.valueId = valueId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "feed_type", nullable = false)
	public Boolean getFeedType() {
		return this.feedType;
	}

	public void setFeedType(Boolean feedType) {
		this.feedType = feedType;
	}

	@Column(name = "is_feed", nullable = false)
	public Boolean getIsFeed() {
		return this.isFeed;
	}

	public void setIsFeed(Boolean isFeed) {
		this.isFeed = isFeed;
	}

}