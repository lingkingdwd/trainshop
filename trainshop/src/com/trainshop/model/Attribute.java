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

	private Long attrId;
	private Long catId;
	private String attrName;
	private Integer attrInputType;
	private Integer attrType;
	private String attrValues;
	private Integer attrIndex;
	private Integer sortOrder;
	private Integer isLinked;
	private Integer attrGroup;

	// Constructors

	/** default constructor */
	public Attribute() {
	}

	/** full constructor */
	public Attribute(Long catId, String attrName, Integer attrInputType,
			Integer attrType, String attrValues, Integer attrIndex,
			Integer sortOrder, Integer isLinked, Integer attrGroup) {
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
	public Long getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	@Column(name = "cat_id", nullable = false)
	public Long getCatId() {
		return this.catId;
	}

	public void setCatId(Long catId) {
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
	public Integer getAttrInputType() {
		return this.attrInputType;
	}

	public void setAttrInputType(Integer attrInputType) {
		this.attrInputType = attrInputType;
	}

	@Column(name = "attr_type", nullable = false)
	public Integer getAttrType() {
		return this.attrType;
	}

	public void setAttrType(Integer attrType) {
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
	public Integer getAttrIndex() {
		return this.attrIndex;
	}

	public void setAttrIndex(Integer attrIndex) {
		this.attrIndex = attrIndex;
	}

	@Column(name = "sort_order", nullable = false)
	public Integer getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "is_linked", nullable = false)
	public Integer getIsLinked() {
		return this.isLinked;
	}

	public void setIsLinked(Integer isLinked) {
		this.isLinked = isLinked;
	}

	@Column(name = "attr_group", nullable = false)
	public Integer getAttrGroup() {
		return this.attrGroup;
	}

	public void setAttrGroup(Integer attrGroup) {
		this.attrGroup = attrGroup;
	}

}