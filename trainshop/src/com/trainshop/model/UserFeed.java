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

	private Long feedId;
	private Long userId;
	private Long valueId;
	private Long goodsId;
	private Boolean feedType;
	private Boolean isFeed;

	// Constructors

	/** default constructor */
	public UserFeed() {
	}

	/** full constructor */
	public UserFeed(Long userId, Long valueId, Long goodsId, Boolean feedType,
			Boolean isFeed) {
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
	public Long getFeedId() {
		return this.feedId;
	}

	public void setFeedId(Long feedId) {
		this.feedId = feedId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "value_id", nullable = false)
	public Long getValueId() {
		return this.valueId;
	}

	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
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