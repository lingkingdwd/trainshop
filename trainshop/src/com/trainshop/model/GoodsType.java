package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_type", catalog = "trainshop")
public class GoodsType implements java.io.Serializable {

	// Fields

	private Short catId;
	private String catName;
	private Boolean enabled;
	private String attrGroup;

	// Constructors

	/** default constructor */
	public GoodsType() {
	}

	/** full constructor */
	public GoodsType(String catName, Boolean enabled, String attrGroup) {
		this.catName = catName;
		this.enabled = enabled;
		this.attrGroup = attrGroup;
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

	@Column(name = "cat_name", nullable = false, length = 60)
	public String getCatName() {
		return this.catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "attr_group", nullable = false)
	public String getAttrGroup() {
		return this.attrGroup;
	}

	public void setAttrGroup(String attrGroup) {
		this.attrGroup = attrGroup;
	}

}