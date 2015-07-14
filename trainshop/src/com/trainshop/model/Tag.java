package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tag", catalog = "trainshop")
public class Tag implements java.io.Serializable {

	// Fields

	private Long tagId;
	private Long userId;
	private Long goodsId;
	private String tagWords;

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** full constructor */
	public Tag(Long userId, Long goodsId, String tagWords) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.tagWords = tagWords;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	@Column(name = "user_id", nullable = false)
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "tag_words", nullable = false)
	public String getTagWords() {
		return this.tagWords;
	}

	public void setTagWords(String tagWords) {
		this.tagWords = tagWords;
	}

}