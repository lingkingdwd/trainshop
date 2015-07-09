package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Template entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "template", catalog = "trainshop")
public class Template implements java.io.Serializable {

	// Fields

	private TemplateId id;

	// Constructors

	/** default constructor */
	public Template() {
	}

	/** full constructor */
	public Template(TemplateId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "filename", column = @Column(name = "filename", nullable = false, length = 30)),
			@AttributeOverride(name = "region", column = @Column(name = "region", nullable = false, length = 40)),
			@AttributeOverride(name = "library", column = @Column(name = "library", nullable = false, length = 40)),
			@AttributeOverride(name = "sortOrder", column = @Column(name = "sort_order", nullable = false)),
			@AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "number", column = @Column(name = "number", nullable = false)),
			@AttributeOverride(name = "type", column = @Column(name = "type", nullable = false)),
			@AttributeOverride(name = "theme", column = @Column(name = "theme", nullable = false, length = 60)),
			@AttributeOverride(name = "remarks", column = @Column(name = "remarks", nullable = false, length = 30)) })
	public TemplateId getId() {
		return this.id;
	}

	public void setId(TemplateId id) {
		this.id = id;
	}

}