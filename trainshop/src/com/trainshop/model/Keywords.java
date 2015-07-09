package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Keywords entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "keywords", catalog = "trainshop")
public class Keywords implements java.io.Serializable {

	// Fields

	private KeywordsId id;
	private Integer count;

	// Constructors

	/** default constructor */
	public Keywords() {
	}

	/** full constructor */
	public Keywords(KeywordsId id, Integer count) {
		this.id = id;
		this.count = count;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "date", column = @Column(name = "date", nullable = false, length = 10)),
			@AttributeOverride(name = "searchengine", column = @Column(name = "searchengine", nullable = false, length = 20)),
			@AttributeOverride(name = "keyword", column = @Column(name = "keyword", nullable = false, length = 90)) })
	public KeywordsId getId() {
		return this.id;
	}

	public void setId(KeywordsId id) {
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