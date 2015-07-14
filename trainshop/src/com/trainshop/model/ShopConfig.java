package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ShopConfig entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop_config", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class ShopConfig implements java.io.Serializable {

	// Fields

	private Long id;
	private Long parentId;
	private String code;
	private String type;
	private String storeRange;
	private String storeDir;
	private String value;
	private Short sortOrder;

	// Constructors

	/** default constructor */
	public ShopConfig() {
	}

	/** full constructor */
	public ShopConfig(Long parentId, String code, String type,
			String storeRange, String storeDir, String value, Short sortOrder) {
		this.parentId = parentId;
		this.code = code;
		this.type = type;
		this.storeRange = storeRange;
		this.storeDir = storeDir;
		this.value = value;
		this.sortOrder = sortOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "parent_id", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "code", unique = true, nullable = false, length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "store_range", nullable = false)
	public String getStoreRange() {
		return this.storeRange;
	}

	public void setStoreRange(String storeRange) {
		this.storeRange = storeRange;
	}

	@Column(name = "store_dir", nullable = false)
	public String getStoreDir() {
		return this.storeDir;
	}

	public void setStoreDir(String storeDir) {
		this.storeDir = storeDir;
	}

	@Column(name = "value", nullable = false, length = 65535)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "sort_order", nullable = false)
	public Short getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Short sortOrder) {
		this.sortOrder = sortOrder;
	}

}