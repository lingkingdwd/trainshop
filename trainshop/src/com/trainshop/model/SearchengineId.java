package com.trainshop.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SearchengineId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SearchengineId implements java.io.Serializable {

	// Fields

	private Date date;
	private String searchengine;

	// Constructors

	/** default constructor */
	public SearchengineId() {
	}

	/** full constructor */
	public SearchengineId(Date date, String searchengine) {
		this.date = date;
		this.searchengine = searchengine;
	}

	// Property accessors
	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "searchengine", nullable = false, length = 20)
	public String getSearchengine() {
		return this.searchengine;
	}

	public void setSearchengine(String searchengine) {
		this.searchengine = searchengine;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SearchengineId))
			return false;
		SearchengineId castOther = (SearchengineId) other;

		return ((this.getDate() == castOther.getDate()) || (this.getDate() != null
				&& castOther.getDate() != null && this.getDate().equals(
				castOther.getDate())))
				&& ((this.getSearchengine() == castOther.getSearchengine()) || (this
						.getSearchengine() != null
						&& castOther.getSearchengine() != null && this
						.getSearchengine().equals(castOther.getSearchengine())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37
				* result
				+ (getSearchengine() == null ? 0 : this.getSearchengine()
						.hashCode());
		return result;
	}

}