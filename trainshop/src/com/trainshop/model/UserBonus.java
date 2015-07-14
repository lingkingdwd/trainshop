package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserBonus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_bonus", catalog = "trainshop")
public class UserBonus implements java.io.Serializable {

	// Fields

	private Long bonusId;
	private Short bonusTypeId;
	private Long bonusSn;
	private Long userId;
	private Long usedTime;
	private Long orderId;
	private Short emailed;

	// Constructors

	/** default constructor */
	public UserBonus() {
	}

	/** full constructor */
	public UserBonus(Short bonusTypeId, Long bonusSn, Long userId,
			Long usedTime, Long orderId, Short emailed) {
		this.bonusTypeId = bonusTypeId;
		this.bonusSn = bonusSn;
		this.userId = userId;
		this.usedTime = usedTime;
		this.orderId = orderId;
		this.emailed = emailed;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "bonus_id", unique = true, nullable = false)
	public Long getBonusId() {
		return this.bonusId;
	}

	public void setBonusId(Long bonusId) {
		this.bonusId = bonusId;
	}

	@Column(name = "bonus_type_id", nullable = false)
	public Short getBonusTypeId() {
		return this.bonusTypeId;
	}

	public void setBonusTypeId(Short bonusTypeId) {
		this.bonusTypeId = bonusTypeId;
	}

	@Column(name = "bonus_sn", nullable = false)
	public Long getBonusSn() {
		return this.bonusSn;
	}

	public void setBonusSn(Long bonusSn) {
		this.bonusSn = bonusSn;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "used_time", nullable = false)
	public Long getUsedTime() {
		return this.usedTime;
	}

	public void setUsedTime(Long usedTime) {
		this.usedTime = usedTime;
	}

	@Column(name = "order_id", nullable = false)
	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@Column(name = "emailed", nullable = false)
	public Short getEmailed() {
		return this.emailed;
	}

	public void setEmailed(Short emailed) {
		this.emailed = emailed;
	}

}