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

	private Integer tagId;
	private Integer userId;
	private Integer goodsId;
	private String tagWords;

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** full constructor */
	public Tag(Integer userId, Integer goodsId, String tagWords) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.tagWords = tagWords;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "tag_id", unique = true, nullable = false)
	public Integer getTagId() {
		return this.tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	@Column(name = "user_id", nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
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