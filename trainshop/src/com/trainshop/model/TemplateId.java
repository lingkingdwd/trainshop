package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TemplateId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TemplateId implements java.io.Serializable {

	// Fields

	private String filename;
	private String region;
	private String library;
	private Boolean sortOrder;
	private Short id;
	private Boolean number;
	private Boolean type;
	private String theme;
	private String remarks;

	// Constructors

	/** default constructor */
	public TemplateId() {
	}

	/** full constructor */
	public TemplateId(String filename, String region, String library,
			Boolean sortOrder, Short id, Boolean number, Boolean type,
			String theme, String remarks) {
		this.filename = filename;
		this.region = region;
		this.library = library;
		this.sortOrder = sortOrder;
		this.id = id;
		this.number = number;
		this.type = type;
		this.theme = theme;
		this.remarks = remarks;
	}

	// Property accessors

	@Column(name = "filename", nullable = false, length = 30)
	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	@Column(name = "region", nullable = false, length = 40)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "library", nullable = false, length = 40)
	public String getLibrary() {
		return this.library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	@Column(name = "sort_order", nullable = false)
	public Boolean getSortOrder() {
		return this.sortOrder;
	}

	public void setSortOrder(Boolean sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Column(name = "id", nullable = false)
	public Short getId() {
		return this.id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	@Column(name = "number", nullable = false)
	public Boolean getNumber() {
		return this.number;
	}

	public void setNumber(Boolean number) {
		this.number = number;
	}

	@Column(name = "type", nullable = false)
	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	@Column(name = "theme", nullable = false, length = 60)
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Column(name = "remarks", nullable = false, length = 30)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TemplateId))
			return false;
		TemplateId castOther = (TemplateId) other;

		return ((this.getFilename() == castOther.getFilename()) || (this
				.getFilename() != null && castOther.getFilename() != null && this
				.getFilename().equals(castOther.getFilename())))
				&& ((this.getRegion() == castOther.getRegion()) || (this
						.getRegion() != null && castOther.getRegion() != null && this
						.getRegion().equals(castOther.getRegion())))
				&& ((this.getLibrary() == castOther.getLibrary()) || (this
						.getLibrary() != null && castOther.getLibrary() != null && this
						.getLibrary().equals(castOther.getLibrary())))
				&& ((this.getSortOrder() == castOther.getSortOrder()) || (this
						.getSortOrder() != null
						&& castOther.getSortOrder() != null && this
						.getSortOrder().equals(castOther.getSortOrder())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())))
				&& ((this.getNumber() == castOther.getNumber()) || (this
						.getNumber() != null && castOther.getNumber() != null && this
						.getNumber().equals(castOther.getNumber())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())))
				&& ((this.getTheme() == castOther.getTheme()) || (this
						.getTheme() != null && castOther.getTheme() != null && this
						.getTheme().equals(castOther.getTheme())))
				&& ((this.getRemarks() == castOther.getRemarks()) || (this
						.getRemarks() != null && castOther.getRemarks() != null && this
						.getRemarks().equals(castOther.getRemarks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFilename() == null ? 0 : this.getFilename().hashCode());
		result = 37 * result
				+ (getRegion() == null ? 0 : this.getRegion().hashCode());
		result = 37 * result
				+ (getLibrary() == null ? 0 : this.getLibrary().hashCode());
		result = 37 * result
				+ (getSortOrder() == null ? 0 : this.getSortOrder().hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getTheme() == null ? 0 : this.getTheme().hashCode());
		result = 37 * result
				+ (getRemarks() == null ? 0 : this.getRemarks().hashCode());
		return result;
	}

}