package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Plugins entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "plugins", catalog = "trainshop")
public class Plugins implements java.io.Serializable {

	// Fields

	private String code;
	private String version;
	private String library;
	private Boolean assign;
	private Integer installDate;

	// Constructors

	/** default constructor */
	public Plugins() {
	}

	/** full constructor */
	public Plugins(String code, String version, String library, Boolean assign,
			Integer installDate) {
		this.code = code;
		this.version = version;
		this.library = library;
		this.assign = assign;
		this.installDate = installDate;
	}

	// Property accessors
	@Id
	@Column(name = "code", unique = true, nullable = false, length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "version", nullable = false, length = 10)
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Column(name = "library", nullable = false)
	public String getLibrary() {
		return this.library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	@Column(name = "assign", nullable = false)
	public Boolean getAssign() {
		return this.assign;
	}

	public void setAssign(Boolean assign) {
		this.assign = assign;
	}

	@Column(name = "install_date", nullable = false)
	public Integer getInstallDate() {
		return this.installDate;
	}

	public void setInstallDate(Integer installDate) {
		this.installDate = installDate;
	}

}