package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Agency entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "agency", catalog = "trainshop")
public class Agency implements java.io.Serializable {

	// Fields

	private Long agencyId;
	private String agencyName;
	private String agencyDesc;

	// Constructors

	/** default constructor */
	public Agency() {
	}

	/** full constructor */
	public Agency(String agencyName, String agencyDesc) {
		this.agencyName = agencyName;
		this.agencyDesc = agencyDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "agency_id", unique = true, nullable = false)
	public Long getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Long agencyId) {
		this.agencyId = agencyId;
	}

	@Column(name = "agency_name", nullable = false)
	public String getAgencyName() {
		return this.agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	@Column(name = "agency_desc", nullable = false, length = 65535)
	public String getAgencyDesc() {
		return this.agencyDesc;
	}

	public void setAgencyDesc(String agencyDesc) {
		this.agencyDesc = agencyDesc;
	}

}