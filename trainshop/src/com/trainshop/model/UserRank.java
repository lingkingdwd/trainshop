package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRank entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_rank", catalog = "trainshop")
public class UserRank implements java.io.Serializable {

	// Fields

	private Short rankId;
	private String rankName;
	private Integer minPoints;
	private Integer maxPoints;
	private Short discount;
	private Boolean showPrice;
	private Boolean specialRank;

	// Constructors

	/** default constructor */
	public UserRank() {
	}

	/** full constructor */
	public UserRank(String rankName, Integer minPoints, Integer maxPoints,
			Short discount, Boolean showPrice, Boolean specialRank) {
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
	public Short getRankId() {
		return this.rankId;
	}

	public void setRankId(Short rankId) {
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
	public Short getDiscount() {
		return this.discount;
	}

	public void setDiscount(Short discount) {
		this.discount = discount;
	}

	@Column(name = "show_price", nullable = false)
	public Boolean getShowPrice() {
		return this.showPrice;
	}

	public void setShowPrice(Boolean showPrice) {
		this.showPrice = showPrice;
	}

	@Column(name = "special_rank", nullable = false)
	public Boolean getSpecialRank() {
		return this.specialRank;
	}

	public void setSpecialRank(Boolean specialRank) {
		this.specialRank = specialRank;
	}

}