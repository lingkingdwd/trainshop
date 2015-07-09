package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PackageGoods entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "package_goods", catalog = "trainshop")
public class PackageGoods implements java.io.Serializable {

	// Fields

	private PackageGoodsId id;
	private Short goodsNumber;

	// Constructors

	/** default constructor */
	public PackageGoods() {
	}

	/** full constructor */
	public PackageGoods(PackageGoodsId id, Short goodsNumber) {
		this.id = id;
		this.goodsNumber = goodsNumber;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "packageId", column = @Column(name = "package_id", nullable = false)),
			@AttributeOverride(name = "goodsId", column = @Column(name = "goods_id", nullable = false)),
			@AttributeOverride(name = "adminId", column = @Column(name = "admin_id", nullable = false)),
			@AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false)) })
	public PackageGoodsId getId() {
		return this.id;
	}

	public void setId(PackageGoodsId id) {
		this.id = id;
	}

	@Column(name = "goods_number", nullable = false)
	public Short getGoodsNumber() {
		return this.goodsNumber;
	}

	public void setGoodsNumber(Short goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

}