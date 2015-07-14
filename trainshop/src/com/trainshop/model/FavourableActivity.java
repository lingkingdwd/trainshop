package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FavourableActivity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "favourable_activity", catalog = "trainshop")
public class FavourableActivity implements java.io.Serializable {

	// Fields

	private Long actId;
	private String actName;
	private Integer startTime;
	private Integer endTime;
	private String userRank;
	private Short actRange;
	private String actRangeExt;
	private Double minAmount;
	private Double maxAmount;
	private Short actType;
	private Double actTypeExt;
	private String gift;
	private Short sortOrder;

	// Constructors

	/** default constructor */
	public FavourableActivity() {
	}

	/** full constructor */
	public FavourableActivity(String actName, Integer startTime,
			Integer endTime, String userRank, Short actRange,
			String actRangeExt, Double minAmount, Double maxAmount,
			Short actType, Double actTypeExt, String gift, Short sortOrder) {
		this.actName = actName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userRank = userRank;
		this.actRange = actRange;
		this.actRangeExt = actRangeExt;
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.actType = actType;
		this.actTypeExt = actTypeExt;
		this.gift = gift;
		this.sortOrder = sortOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "act_id", unique = true, nullable = false)
	public Long getActId() {
		return this.actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	@Column(name = "act_name", nullable = false)
	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	@Column(name = "start_time", nullable = false)
	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Column(name = "user_rank", nullable = false)
	public String getUserRank() {
		return this.userRank;
	}

	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}

	@Column(name = "act_range", nullable = false)
	public Short getActRange() {
		return this.actRange;
	}

	public void setActRange(Short actRange) {
		this.actRange = actRange;
	}

	@Column(name = "act_range_ext", nullable = false)
	public String getActRangeExt() {
		return this.actRangeExt;
	}

	public void setActRangeExt(String actRangeExt) {
		this.actRangeExt = actRangeExt;
	}

	@Column(name = "min_amount", nullable = false, precision = 10)
	public Double getMinAmount() {
		return this.minAmount;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	@Column(name = "max_amount", nullable = false, precision = 10)
	public Double getMaxAmount() {
		return this.maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	@Column(name = "act_type", nullable = false)
	public Short getActType() {
		return this.actType;
	}

	public void setActType(Short actType) {
		this.actType = actType;
	}

	@Column(name = "act_type_ext", nullable = false, precision = 10)
	public Double getActTypeExt() {
		return this.actTypeExt;
	}

	public void setActTypeExt(Double actTypeExt) {
		this.actTypeExt = actTypeExt;
	}

	@Column(name = "gift", nullable = false, length = 65535)
	public String getGift() {
		return this.gift;
	}

	public void setGift(String gift) {
		this.gift = gift;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

}