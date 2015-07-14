package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "brand", catalog = "trainshop")
public class Brand implements java.io.Serializable {

	// Fields

	private Long brandId;
	private String brandName;
	private String brandLogo;
	private String brandDesc;
	private String siteUrl;
	private Integer sortOrder;
	private Integer isShow;

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(String brandName, String brandLogo, String brandDesc,
			String siteUrl, Integer sortOrder, Integer isShow) {
		this.brandName = brandName;
		this.brandLogo = brandLogo;
		this.brandDesc = brandDesc;
		this.siteUrl = siteUrl;
		this.sortOrder = sortOrder;
		this.isShow = isShow;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "brand_id", unique = true, nullable = false)
	public Long getBrandId() {
		return this.brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	@Column(name = "brand_name", nullable = false, length = 60)
	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Column(name = "brand_logo", nullable = false, length = 80)
	public String getBrandLogo() {
		return this.brandLogo;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}

	@Column(name = "brand_desc", nullable = false, length = 65535)
	public String getBrandDesc() {
		return this.brandDesc;
	}

	public void setBrandDesc(String brandDesc) {
		this.brandDesc = brandDesc;
	}

	@Column(name = "site_url", nullable = false)
	public String getSiteUrl() {
		return this.siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	@Column(name = "sort_order", nullable = false)
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_show", nullable = false)
	public Integer getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

}