package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "trainshop")
public class Category implements java.io.Serializable {

	// Fields

	private Short catId;
	private String catName;
	private String keywords;
	private String catDesc;
	private Short parentId;
	private Boolean sortOrder;
	private String templateFile;
	private String measureUnit;
	private Boolean showInNav;
	private String style;
	private Boolean isShow;
	private Short grade;
	private String filterAttr;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String catName, String keywords, String catDesc,
			Short parentId, Boolean sortOrder, String templateFile,
			String measureUnit, Boolean showInNav, String style,
			Boolean isShow, Short grade, String filterAttr) {
		this.catName = catName;
		this.keywords = keywords;
		this.catDesc = catDesc;
		this.parentId = parentId;
		this.sortOrder = sortOrder;
		this.templateFile = templateFile;
		this.measureUnit = measureUnit;
		this.showInNav = showInNav;
		this.style = style;
		this.isShow = isShow;
		this.grade = grade;
		this.filterAttr = filterAttr;
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

	@Column(name = "cat_name", nullable = false, length = 90)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
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

	@Column(name = "parent_id", nullable = false)
	public Short getParentId() {
		return this.parentId;
	}

	public void setParentId(Short parentId) {
		this.parentId = parentId;
	}

	@Column(name = "sort_order", nullable = false)
	public Boolean getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "template_file", nullable = false, length = 50)
	public String getTemplateFile() {
		return this.templateFile;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}

	@Column(name = "measure_unit", nullable = false, length = 15)
	public String getMeasureUnit() {
		return this.measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	@Column(name = "show_in_nav", nullable = false)
	public Boolean getShowInNav() {
		return this.showInNav;
	}

	public void setShowInNav(Boolean showInNav) {
		this.showInNav = showInNav;
	}

	@Column(name = "style", nullable = false, length = 150)
	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "is_show", nullable = false)
	public Boolean getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	@Column(name = "grade", nullable = false)
	public Short getGrade() {
		return this.grade;
	}

	public void setGrade(Short grade) {
		this.grade = grade;
	}

	@Column(name = "filter_attr", nullable = false)
	public String getFilterAttr() {
		return this.filterAttr;
	}

	public void setFilterAttr(String filterAttr) {
		this.filterAttr = filterAttr;
	}

}