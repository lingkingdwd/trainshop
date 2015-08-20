package com.trainshop.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_rank", catalog = "trainshop")
public class UserRank implements java.io.Serializable {

	// Fields

	private Long rankId;
	private String rankName;
	private Integer minPoints;
	private Integer maxPoints;
	private Integer discount;
	private Integer showPrice;
	private Integer specialRank;

	// Constructors

	/** default constructor */
	public UserRank() {
	}

	/** full constructor */
	public UserRank(Long rankId, String rankName, Integer minPoints,
			Integer maxPoints, Integer discount, Integer showPrice,
			Integer specialRank) {
		this.rankId = rankId;
		this.rankName = rankName;
		this.minPoints = minPoints;
		this.maxPoints = maxPoints;
		this.discount = discount;
		this.showPrice = showPrice;
		this.specialRank = specialRank;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rank_id", unique = true, nullable = false)
	public Long getRankId() {
		return this.rankId;
	}

	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}

	@Column(name = "rank_name", nullable = false, length = 30)
	public String getRankName() {
		return this.rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	@Column(name = "min_points", nullable = false)
	public Integer getMinPoints() {
		return this.minPoints;
	}

	public void setMinPoints(Integer minPoints) {
		this.minPoints = minPoints;
	}

	@Column(name = "max_points", nullable = false)
	public Integer getMaxPoints() {
		return this.maxPoints;
	}

	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}

	@Column(name = "discount", nullable = false)
	public Integer getDiscount() {
		return this.discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Column(name = "show_price", nullable = false)
	public Integer getShowPrice() {
		return this.showPrice;
	}

	public void setShowPrice(Integer showPrice) {
		this.showPrice = showPrice;
	}

	@Column(name = "special_rank", nullable = false)
	public Integer getSpecialRank() {
		return this.specialRank;
	}

	public void setSpecialRank(Integer specialRank) {
		this.specialRank = specialRank;
	}

}