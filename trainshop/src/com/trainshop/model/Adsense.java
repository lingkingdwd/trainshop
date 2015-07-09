package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Adsense entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adsense", catalog = "trainshop")
public class Adsense implements java.io.Serializable {

	// Fields

	private AdsenseId id;

	// Constructors

	/** default constructor */
	public Adsense() {
	}

	/** full constructor */
	public Adsense(AdsenseId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "fromAd", column = @Column(name = "from_ad", nullable = false)),
			@AttributeOverride(name = "referer", column = @Column(name = "referer", nullable = false)),
			@AttributeOverride(name = "clicks", column = @Column(name = "clicks", nullable = false)) })
	public AdsenseId getId() {
		return this.id;
	}

	public void setId(AdsenseId id) {
		this.id = id;
	}

}