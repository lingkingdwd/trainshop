package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Suppliers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "suppliers", catalog = "trainshop")
public class Suppliers implements java.io.Serializable {

	// Fields

	private Short suppliersId;
	private String suppliersName;
	private String suppliersDesc;
	private Boolean isCheck;

	// Constructors

	/** default constructor */
	public Suppliers() {
	}

	/** minimal constructor */
	public Suppliers(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	/** full constructor */
	public Suppliers(String suppliersName, String suppliersDesc, Boolean isCheck) {
		this.suppliersName = suppliersName;
		this.suppliersDesc = suppliersDesc;
		this.isCheck = isCheck;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "suppliers_id", unique = true, nullable = false)
	public Short getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Short suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "suppliers_name")
	public String getSuppliersName() {
		return this.suppliersName;
	}

	public void setSuppliersName(String suppliersName) {
		this.suppliersName = suppliersName;
	}

	@Column(name = "suppliers_desc", length = 16777215)
	public String getSuppliersDesc() {
		return this.suppliersDesc;
	}

	public void setSuppliersDesc(String suppliersDesc) {
		this.suppliersDesc = suppliersDesc;
	}

	@Column(name = "is_check", nullable = false)
	public Boolean getIsCheck() {
		return this.isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

}