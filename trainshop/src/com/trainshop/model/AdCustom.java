package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdCustom entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ad_custom", catalog = "trainshop")
public class AdCustom implements java.io.Serializable {

	// Fields

	private Long adId;
	private Integer adType;
	private String adName;
	private Integer addTime;
	private String content;
	private String url;
	private Integer adStatus;

	// Constructors

	/** default constructor */
	public AdCustom() {
	}

	/** minimal constructor */
	public AdCustom(Integer adType, Integer addTime, Integer adStatus) {
		this.adType = adType;
		this.addTime = addTime;
		this.adStatus = adStatus;
	}

	/** full constructor */
	public AdCustom(Integer adType, String adName, Integer addTime,
			String content, String url, Integer adStatus) {
		this.adType = adType;
		this.adName = adName;
		this.addTime = addTime;
		this.content = content;
		this.url = url;
		this.adStatus = adStatus;
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

	@Column(name = "ad_type", nullable = false)
	public Integer getAdType() {
		return this.adType;
	}

	public void setAdType(Integer adType) {
		this.adType = adType;
	}

	@Column(name = "ad_name", length = 60)
	public String getAdName() {
		return this.adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "content", length = 16777215)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "url")
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "ad_status", nullable = false)
	public Integer getAdStatus() {
		return this.adStatus;
	}

	public void setAdStatus(Integer adStatus) {
		this.adStatus = adStatus;
	}

}