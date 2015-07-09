package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RegFields entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reg_fields", catalog = "trainshop")
public class RegFields implements java.io.Serializable {

	// Fields

	private Short id;
	private String regFieldName;
	private Short disOrder;
	private Boolean display;
	private Boolean type;
	private Boolean isNeed;

	// Constructors

	/** default constructor */
	public RegFields() {
	}

	/** full constructor */
	public RegFields(String regFieldName, Short disOrder, Boolean display,
			Boolean type, Boolean isNeed) {
		this.regFieldName = regFieldName;
		this.disOrder = disOrder;
		this.display = display;
		this.type = type;
		this.isNeed = isNeed;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Column(name = "reg_field_name", nullable = false, length = 60)
	public String getRegFieldName() {
		return this.regFieldName;
	}

	public void setRegFieldName(String regFieldName) {
		this.regFieldName = regFieldName;
	}

	@Column(name = "dis_order", nullable = false)
	public Short getDisOrder() {
		return this.disOrder;
	}

	public void setDisOrder(Short disOrder) {
		this.disOrder = disOrder;
	}

	@Column(name = "display", nullable = false)
	public Boolean getDisplay() {
		return this.display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	@Column(name = "type", nullable = false)
	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	@Column(name = "is_need", nullable = false)
	public Boolean getIsNeed() {
		return this.isNeed;
	}

	public void setIsNeed(Boolean isNeed) {
		this.isNeed = isNeed;
	}

}