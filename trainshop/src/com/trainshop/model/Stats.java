package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Stats entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stats", catalog = "trainshop")
public class Stats implements java.io.Serializable {

	// Fields

	private StatsId id;

	// Constructors

	/** default constructor */
	public Stats() {
	}

	/** full constructor */
	public Stats(StatsId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "accessTime", column = @Column(name = "access_time", nullable = false)),
			@AttributeOverride(name = "ipAddress", column = @Column(name = "ip_address", nullable = false, length = 15)),
			@AttributeOverride(name = "visitTimes", column = @Column(name = "visit_times", nullable = false)),
			@AttributeOverride(name = "browser", column = @Column(name = "browser", nullable = false, length = 60)),
			@AttributeOverride(name = "system", column = @Column(name = "system", nullable = false, length = 20)),
			@AttributeOverride(name = "language", column = @Column(name = "language", nullable = false, length = 20)),
			@AttributeOverride(name = "area", column = @Column(name = "area", nullable = false, length = 30)),
			@AttributeOverride(name = "refererDomain", column = @Column(name = "referer_domain", nullable = false, length = 100)),
			@AttributeOverride(name = "refererPath", column = @Column(name = "referer_path", nullable = false, length = 200)),
			@AttributeOverride(name = "accessUrl", column = @Column(name = "access_url", nullable = false)) })
	public StatsId getId() {
		return this.id;
	}

	public void setId(StatsId id) {
		this.id = id;
	}

}