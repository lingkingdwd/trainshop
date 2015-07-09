package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsActivity entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "goods_activity", catalog = "trainshop")
public class GoodsActivity implements java.io.Serializable {

	// Fields

	private Integer actId;
	private String actName;
	private String actDesc;
	private Short actType;
	private Integer goodsId;
	private Integer productId;
	private String goodsName;
	private Integer startTime;
	private Integer endTime;
	private Short isFinished;
	private String extInfo;

	// Constructors

	/** default constructor */
	public GoodsActivity() {
	}

	/** full constructor */
	public GoodsActivity(String actName, String actDesc, Short actType,
			Integer goodsId, Integer productId, String goodsName,
			Integer startTime, Integer endTime, Short isFinished, String extInfo) {
		this.actName = actName;
		this.actDesc = actDesc;
		this.actType = actType;
		this.goodsId = goodsId;
		this.productId = productId;
		this.goodsName = goodsName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isFinished = isFinished;
		this.extInfo = extInfo;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "act_id", unique = true, nullable = false)
	public Integer getActId() {
		return this.actId;
	}

	public void setActId(Integer actId) {
		this.actId = actId;
	}

	@Column(name = "act_name", nullable = false)
	public String getActName() {
		return this.actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	@Column(name = "act_desc", nullable = false, length = 65535)
	public String getActDesc() {
		return this.actDesc;
	}

	public void setActDesc(String actDesc) {
		this.actDesc = actDesc;
	}

	@Column(name = "act_type", nullable = false)
	public Short getActType() {
		return this.actType;
	}

	public void setActType(Short actType) {
		this.actType = actType;
	}

	@Column(name = "goods_id", nullable = false)
	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Column(name = "product_id", nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "goods_name", nullable = false)
	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Column(name = "start_time", nullable = false)
	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Column(name = "is_finished", nullable = false)
	public Short getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(Short isFinished) {
		this.isFinished = isFinished;
	}

	@Column(name = "ext_info", nullable = false, length = 65535)
	public String getExtInfo() {
		return this.extInfo;
	}

	public void setExtInfo(String extInfo) {
		this.extInfo = extInfo;
	}

}