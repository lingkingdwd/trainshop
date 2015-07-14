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

	private Long catId;
	private String catName;
	private String keywords;
	private String catDesc;
	private Integer parentId;
	private Integer sortOrder;
	private String templateFile;
	private String measureUnit;
	private Integer showInNav;
	private String style;
	private Integer isShow;
	private Integer grade;
	private String filterAttr;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String catName, String keywords, String catDesc,
			Integer parentId, Integer sortOrder, Integer isShow) {
		this.catName = catName;
		this.keywords = keywords;
		this.catDesc = catDesc;
		this.parentId = parentId;
		this.sortOrder = sortOrder;
		this.isShow = isShow;
	}

	/** full constructor */
	public Category(String catName, String keywords, String catDesc,
			Integer parentId, Integer sortOrder, String templateFile,
			String measureUnit, Integer showInNav, String style,
			Integer isShow, Integer grade, String filterAttr) {
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
	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
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
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "sort_order", nullable = false)
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "template_file", length = 50)
	public String getTemplateFile() {
		return this.templateFile;
	}

	public void setTemplateFile(String templateFile) {
		this.templateFile = templateFile;
	}

	@Column(name = "measure_unit", length = 15)
	public String getMeasureUnit() {
		return this.measureUnit;
	}

	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}

	@Column(name = "show_in_nav")
	public Integer getShowInNav() {
		return this.showInNav;
	}

	public void setShowInNav(Integer showInNav) {
		this.showInNav = showInNav;
	}

	@Column(name = "style", length = 150)
	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Column(name = "is_show", nullable = false)
	public Integer getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	@Column(name = "grade")
	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Column(name = "filter_attr")
	public String getFilterAttr() {
		return this.filterAttr;
	}

	public void setFilterAttr(String filterAttr) {
		this.filterAttr = filterAttr;
	}

}