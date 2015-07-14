package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdPosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ad_position", catalog = "trainshop")
public class AdPosition implements java.io.Serializable {

	// Fields

	private Integer positionId;
	private String positionName;
	private Integer adWidth;
	private Integer adHeight;
	private String positionDesc;
	private String positionStyle;

	// Constructors

	/** default constructor */
	public AdPosition() {
	}

	/** full constructor */
	public AdPosition(String positionName, Integer adWidth, Integer adHeight,
			String positionDesc, String positionStyle) {
		this.positionName = positionName;
		this.adWidth = adWidth;
		this.adHeight = adHeight;
		this.positionDesc = positionDesc;
		this.positionStyle = positionStyle;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "position_id", unique = true, nullable = false)
	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	@Column(name = "position_name", nullable = false, length = 60)
	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Column(name = "ad_width", nullable = false)
	public Integer getAdWidth() {
		return this.adWidth;
	}

	public void setAdWidth(Integer adWidth) {
		this.adWidth = adWidth;
	}

	@Column(name = "ad_height", nullable = false)
	public Integer getAdHeight() {
		return this.adHeight;
	}

	public void setAdHeight(Integer adHeight) {
		this.adHeight = adHeight;
	}

	@Column(name = "position_desc", nullable = false)
	public String getPositionDesc() {
		return this.positionDesc;
	}

	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}

	@Column(name = "position_style", nullable = false, length = 65535)
	public String getPositionStyle() {
		return this.positionStyle;
	}

	public void setPositionStyle(String positionStyle) {
		this.positionStyle = positionStyle;
	}

}