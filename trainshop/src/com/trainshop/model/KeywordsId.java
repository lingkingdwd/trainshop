package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * KeywordsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class KeywordsId implements java.io.Serializable {

	// Fields

	private Long date;
	private String searchengine;
	private String keyword;

	// Constructors

	/** default constructor */
	public KeywordsId() {
	}

	/** full constructor */
	public KeywordsId(Long date, String searchengine, String keyword) {
		this.date = date;
		this.searchengine = searchengine;
		this.keyword = keyword;
	}

	// Property accessors

	@Column(name = "date", nullable = false)
	public Long getDate() {
		return this.date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	@Column(name = "searchengine", nullable = false, length = 20)
	public String getSearchengine() {
		return this.searchengine;
	}

	public void setSearchengine(String searchengine) {
		this.searchengine = searchengine;
	}

	@Column(name = "keyword", nullable = false, length = 90)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof KeywordsId))
			return false;
		KeywordsId castOther = (KeywordsId) other;

		return ((this.getDate() == castOther.getDate()) || (this.getDate() != null
				&& castOther.getDate() != null && this.getDate().equals(
				castOther.getDate())))
				&& ((this.getSearchengine() == castOther.getSearchengine()) || (this
						.getSearchengine() != null
						&& castOther.getSearchengine() != null && this
						.getSearchengine().equals(castOther.getSearchengine())))
				&& ((this.getKeyword() == castOther.getKeyword()) || (this
						.getKeyword() != null && castOther.getKeyword() != null && this
						.getKeyword().equals(castOther.getKeyword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDate() == null ? 0 : this.getDate().hashCode());
		result = 37
				* result
				+ (getSearchengine() == null ? 0 : this.getSearchengine()
						.hashCode());
		result = 37 * result
				+ (getKeyword() == null ? 0 : this.getKeyword().hashCode());
		return result;
	}

}