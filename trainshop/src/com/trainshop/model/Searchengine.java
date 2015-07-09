package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Searchengine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "searchengine", catalog = "trainshop")
public class Searchengine implements java.io.Serializable {

	// Fields

	private SearchengineId id;
	private Integer count;

	// Constructors

	/** default constructor */
	public Searchengine() {
	}

	/** full constructor */
	public Searchengine(SearchengineId id, Integer count) {
		this.id = id;
		this.count = count;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "date", column = @Column(name = "date", nullable = false, length = 10)),
			@AttributeOverride(name = "searchengine", column = @Column(name = "searchengine", nullable = false, length = 20)) })
	public SearchengineId getId() {
		return this.id;
	}

	public void setId(SearchengineId id) {
		this.id = id;
	}

	@Column(name = "count", nullable = false)
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}