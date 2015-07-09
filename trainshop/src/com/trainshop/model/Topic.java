package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "topic", catalog = "trainshop")
public class Topic implements java.io.Serializable {

	// Fields

	private TopicId id;

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** full constructor */
	public Topic(TopicId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "topicId", column = @Column(name = "topic_id", nullable = false)),
			@AttributeOverride(name = "title", column = @Column(name = "title", nullable = false)),
			@AttributeOverride(name = "intro", column = @Column(name = "intro", nullable = false, length = 65535)),
			@AttributeOverride(name = "startTime", column = @Column(name = "start_time", nullable = false)),
			@AttributeOverride(name = "endTime", column = @Column(name = "end_time", nullable = false)),
			@AttributeOverride(name = "data", column = @Column(name = "data", nullable = false, length = 65535)),
			@AttributeOverride(name = "template", column = @Column(name = "template", nullable = false)),
			@AttributeOverride(name = "css", column = @Column(name = "css", nullable = false, length = 65535)),
			@AttributeOverride(name = "topicImg", column = @Column(name = "topic_img")),
			@AttributeOverride(name = "titlePic", column = @Column(name = "title_pic")),
			@AttributeOverride(name = "baseStyle", column = @Column(name = "base_style", length = 6)),
			@AttributeOverride(name = "htmls", column = @Column(name = "htmls", length = 16777215)),
			@AttributeOverride(name = "keywords", column = @Column(name = "keywords")),
			@AttributeOverride(name = "description", column = @Column(name = "description")) })
	public TopicId getId() {
		return this.id;
	}

	public void setId(TopicId id) {
		this.id = id;
	}

}