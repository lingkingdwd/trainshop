package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AdsenseId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AdsenseId implements java.io.Serializable {

	// Fields

	private Short fromAd;
	private String referer;
	private Integer clicks;

	// Constructors

	/** default constructor */
	public AdsenseId() {
	}

	/** full constructor */
	public AdsenseId(Short fromAd, String referer, Integer clicks) {
		this.fromAd = fromAd;
		this.referer = referer;
		this.clicks = clicks;
	}

	// Property accessors

	@Column(name = "from_ad", nullable = false)
	public Short getFromAd() {
		return this.fromAd;
	}

	public void setFromAd(Short fromAd) {
		this.fromAd = fromAd;
	}

	@Column(name = "referer", nullable = false)
	public String getReferer() {
		return this.referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	@Column(name = "clicks", nullable = false)
	public Integer getClicks() {
		return this.clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdsenseId))
			return false;
		AdsenseId castOther = (AdsenseId) other;

		return ((this.getFromAd() == castOther.getFromAd()) || (this
				.getFromAd() != null && castOther.getFromAd() != null && this
				.getFromAd().equals(castOther.getFromAd())))
				&& ((this.getReferer() == castOther.getReferer()) || (this
						.getReferer() != null && castOther.getReferer() != null && this
						.getReferer().equals(castOther.getReferer())))
				&& ((this.getClicks() == castOther.getClicks()) || (this
						.getClicks() != null && castOther.getClicks() != null && this
						.getClicks().equals(castOther.getClicks())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFromAd() == null ? 0 : this.getFromAd().hashCode());
		result = 37 * result
				+ (getReferer() == null ? 0 : this.getReferer().hashCode());
		result = 37 * result
				+ (getClicks() == null ? 0 : this.getClicks().hashCode());
		return result;
	}

}