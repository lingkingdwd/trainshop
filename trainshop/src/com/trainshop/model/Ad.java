package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ad entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ad", catalog = "trainshop")
public class Ad implements java.io.Serializable {

	// Fields

	private Long adId;
	private Long positionId;
	private Integer mediaType;
	private String adName;
	private String adLink;
	private String adCode;
	private Integer startTime;
	private Integer endTime;
	private String linkMan;
	private String linkEmail;
	private String linkPhone;
	private Integer clickCount;
	private Integer enabled;

	// Constructors

	/** default constructor */
	public Ad() {
	}

	/** full constructor */
	public Ad(Long positionId, Integer mediaType, String adName, String adLink,
			String adCode, Integer startTime, Integer endTime, String linkMan,
			String linkEmail, String linkPhone, Integer clickCount,
			Integer enabled) {
		this.positionId = positionId;
		this.mediaType = mediaType;
		this.adName = adName;
		this.adLink = adLink;
		this.adCode = adCode;
		this.startTime = startTime;
		this.endTime = endTime;
		this.linkMan = linkMan;
		this.linkEmail = linkEmail;
		this.linkPhone = linkPhone;
		this.clickCount = clickCount;
		this.enabled = enabled;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ad_id", unique = true, nullable = false)
	public Long getAdId() {
		return this.adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	@Column(name = "position_id", nullable = false)
	public Long getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Long positionId) {
		this.positionId = positionId;
	}

	@Column(name = "media_type", nullable = false)
	public Integer getMediaType() {
		return this.mediaType;
	}

	public void setMediaType(Integer mediaType) {
		this.mediaType = mediaType;
	}

	@Column(name = "ad_name", nullable = false, length = 60)
	public String getAdName() {
		return this.adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	@Column(name = "ad_link", nullable = false)
	public String getAdLink() {
		return this.adLink;
	}

	public void setAdLink(String adLink) {
		this.adLink = adLink;
	}

	@Column(name = "ad_code", nullable = false, length = 65535)
	public String getAdCode() {
		return this.adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
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

	@Column(name = "link_man", nullable = false, length = 60)
	public String getLinkMan() {
		return this.linkMan;
	}

	public void setLinkMan(String linkMan) {
		this.linkMan = linkMan;
	}

	@Column(name = "link_email", nullable = false, length = 60)
	public String getLinkEmail() {
		return this.linkEmail;
	}

	public void setLinkEmail(String linkEmail) {
		this.linkEmail = linkEmail;
	}

	@Column(name = "link_phone", nullable = false, length = 60)
	public String getLinkPhone() {
		return this.linkPhone;
	}

	public void setLinkPhone(String linkPhone) {
		this.linkPhone = linkPhone;
	}

	@Column(name = "click_count", nullable = false)
	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	@Column(name = "enabled", nullable = false)
	public Integer getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

}