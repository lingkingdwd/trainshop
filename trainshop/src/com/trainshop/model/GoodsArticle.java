package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * GoodsArticle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_article", catalog = "trainshop")
public class GoodsArticle implements java.io.Serializable {

	// Fields

	private GoodsArticleId id;

	// Constructors

	/** default constructor */
	public GoodsArticle() {
	}

	/** full constructor */
	public GoodsArticle(GoodsArticleId id) {
		this.id = id;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "articleId", column = @Column(name = "article_id", nullable = false)),
			@AttributeOverride(name = "adminId", column = @Column(name = "admin_id", nullable = false)) })
	public GoodsArticleId getId() {
		return this.id;
	}

	public void setId(GoodsArticleId id) {
		this.id = id;
	}

}