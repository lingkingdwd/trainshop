package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ArticleCat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article_cat", catalog = "trainshop")
public class ArticleCat implements java.io.Serializable {

	// Fields

	private Short catId;
	private String catName;
	private Boolean catType;
	private String keywords;
	private String catDesc;
	private Short sortOrder;
	private Boolean showInNav;
	private Short parentId;

	// Constructors

	/** default constructor */
	public ArticleCat() {
	}

	/** full constructor */
	public ArticleCat(String catName, Boolean catType, String keywords,
			String catDesc, Short sortOrder, Boolean showInNav, Short parentId) {
		this.catName = catName;
		this.catType = catType;
		this.keywords = keywords;
		this.catDesc = catDesc;
		this.sortOrder = sortOrder;
		this.showInNav = showInNav;
		this.parentId = parentId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cat_id", unique = true, nullable = false)
	public Short getCatId() {
		return this.catId;
	}

	public void setCatId(Short catId) {
		this.catId = catId;
	}

	@Column(name = "cat_name", nullable = false)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "cat_type", nullable = false)
	public Boolean getCatType() {
		return this.catType;
	}

	public void setCatType(Boolean catType) {
		this.catType = catType;
	}

	@Column(name = "keywords", nullable = false)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "cat_desc", nullable = false)
	public String getCatDesc() {
		return this.catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "show_in_nav", nullable = false)
	public Boolean getShowInNav() {
		return this.showInNav;
	}

	public void setShowInNav(Boolean showInNav) {
		this.showInNav = showInNav;
	}

	@Column(name = "parent_id", nullable = false)
	public Short getParentId() {
		return this.parentId;
	}

	public void setParentId(Short parentId) {
		this.parentId = parentId;
	}

}