package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsGallery entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_gallery", catalog = "trainshop")
public class GoodsGallery implements java.io.Serializable {

	// Fields

	private Long imgId;
	private Long goodsId;
	private String imgUrl;
	private String imgDesc;
	private String thumbUrl;
	private String imgOriginal;

	// Constructors

	/** default constructor */
	public GoodsGallery() {
	}

	/** full constructor */
	public GoodsGallery(Long goodsId, String imgUrl, String imgDesc,
			String thumbUrl, String imgOriginal) {
		this.goodsId = goodsId;
		this.imgUrl = imgUrl;
		this.imgDesc = imgDesc;
		this.thumbUrl = thumbUrl;
		this.imgOriginal = imgOriginal;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "img_id", unique = true, nullable = false)
	public Long getImgId() {
		return this.imgId;
	}

	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}

	@Column(name = "goods_id", nullable = false)
	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "img_url", nullable = false)
	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Column(name = "img_desc", nullable = false)
	public String getImgDesc() {
		return this.imgDesc;
	}

	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}

	@Column(name = "thumb_url", nullable = false)
	public String getThumbUrl() {
		return this.thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	@Column(name = "img_original", nullable = false)
	public String getImgOriginal() {
		return this.imgOriginal;
	}

	public void setImgOriginal(String imgOriginal) {
		this.imgOriginal = imgOriginal;
	}

}