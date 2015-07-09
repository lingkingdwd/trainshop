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

	private Short positionId;
	private String positionName;
	private Short adWidth;
	private Short adHeight;
	private String positionDesc;
	private String positionStyle;

	// Constructors

	/** default constructor */
	public AdPosition() {
	}

	/** full constructor */
	public AdPosition(String positionName, Short adWidth, Short adHeight,
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
	public Short getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Short positionId) {
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
	public Short getAdWidth() {
		return this.adWidth;
	}

	public void setAdWidth(Short adWidth) {
		this.adWidth = adWidth;
	}

	@Column(name = "ad_height", nullable = false)
	public Short getAdHeight() {
		return this.adHeight;
	}

	public void setAdHeight(Short adHeight) {
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