package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "attribute", catalog = "trainshop")
public class Attribute implements java.io.Serializable {

	// Fields

	private Short attrId;
	private Short catId;
	private String attrName;
	private Boolean attrInputType;
	private Boolean attrType;
	private String attrValues;
	private Boolean attrIndex;
	private Short sortOrder;
	private Boolean isLinked;
	private Boolean attrGroup;

	// Constructors

	/** default constructor */
	public Attribute() {
	}

	/** full constructor */
	public Attribute(Short catId, String attrName, Boolean attrInputType,
			Boolean attrType, String attrValues, Boolean attrIndex,
			Short sortOrder, Boolean isLinked, Boolean attrGroup) {
		this.catId = catId;
		this.attrName = attrName;
		this.attrInputType = attrInputType;
		this.attrType = attrType;
		this.attrValues = attrValues;
		this.attrIndex = attrIndex;
		this.sortOrder = sortOrder;
		this.isLinked = isLinked;
		this.attrGroup = attrGroup;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "attr_id", unique = true, nullable = false)
	public Short getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Short attrId) {
		this.attrId = attrId;
	}

	@Column(name = "cat_id", nullable = false)
	public Short getCatId() {
		return this.catId;
	}

	public void setCatId(Short catId) {
		this.catId = catId;
	}

	@Column(name = "attr_name", nullable = false, length = 60)
	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	@Column(name = "attr_input_type", nullable = false)
	public Boolean getAttrInputType() {
		return this.attrInputType;
	}

	public void setAttrInputType(Boolean attrInputType) {
		this.attrInputType = attrInputType;
	}

	@Column(name = "attr_type", nullable = false)
	public Boolean getAttrType() {
		return this.attrType;
	}

	public void setAttrType(Boolean attrType) {
		this.attrType = attrType;
	}

	@Column(name = "attr_values", nullable = false, length = 65535)
	public String getAttrValues() {
		return this.attrValues;
	}

	public void setAttrValues(String attrValues) {
		this.attrValues = attrValues;
	}

	@Column(name = "attr_index", nullable = false)
	public Boolean getAttrIndex() {
		return this.attrIndex;
	}

	public void setAttrIndex(Boolean attrIndex) {
		this.attrIndex = attrIndex;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_linked", nullable = false)
	public Boolean getIsLinked() {
		return this.isLinked;
	}

	public void setIsLinked(Boolean isLinked) {
		this.isLinked = isLinked;
	}

	@Column(name = "attr_group", nullable = false)
	public Boolean getAttrGroup() {
		return this.attrGroup;
	}

	public void setAttrGroup(Boolean attrGroup) {
		this.attrGroup = attrGroup;
	}

}