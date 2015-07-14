package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Pack entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pack", catalog = "trainshop")
public class Pack implements java.io.Serializable {

	// Fields

	private Long packId;
	private String packName;
	private String packImg;
	private Double packFee;
	private Short freeMoney;
	private String packDesc;

	// Constructors

	/** default constructor */
	public Pack() {
	}

	/** full constructor */
	public Pack(String packName, String packImg, Double packFee,
			Short freeMoney, String packDesc) {
		this.packName = packName;
		this.packImg = packImg;
		this.packFee = packFee;
		this.freeMoney = freeMoney;
		this.packDesc = packDesc;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "pack_id", unique = true, nullable = false)
	public Long getPackId() {
		return this.packId;
	}

	public void setPackId(Long packId) {
		this.packId = packId;
	}

	@Column(name = "pack_name", nullable = false, length = 120)
	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	@Column(name = "pack_img", nullable = false)
	public String getPackImg() {
		return this.packImg;
	}

	public void setPackImg(String packImg) {
		this.packImg = packImg;
	}

	@Column(name = "pack_fee", nullable = false, precision = 6)
	public Double getPackFee() {
		return this.packFee;
	}

	public void setPackFee(Double packFee) {
		this.packFee = packFee;
	}

	@Column(name = "free_money", nullable = false)
	public Short getFreeMoney() {
		return this.freeMoney;
	}

	public void setFreeMoney(Short freeMoney) {
		this.freeMoney = freeMoney;
	}

	@Column(name = "pack_desc", nullable = false)
	public String getPackDesc() {
		return this.packDesc;
	}

	public void setPackDesc(String packDesc) {
		this.packDesc = packDesc;
	}

}