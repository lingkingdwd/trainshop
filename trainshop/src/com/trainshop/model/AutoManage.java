package com.trainshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AutoManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "auto_manage", catalog = "trainshop")
public class AutoManage implements java.io.Serializable {

	// Fields

	private AutoManageId id;
	private Integer starttime;
	private Integer endtime;

	// Constructors

	/** default constructor */
	public AutoManage() {
	}

	/** full constructor */
	public AutoManage(AutoManageId id, Integer starttime, Integer endtime) {
		this.id = id;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "itemId", column = @Column(name = "item_id", nullable = false)),
			@AttributeOverride(name = "type", column = @Column(name = "type", nullable = false, length = 10)) })
	public AutoManageId getId() {
		return this.id;
	}

	public void setId(AutoManageId id) {
		this.id = id;
	}

	@Column(name = "starttime", nullable = false)
	public Integer getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Integer starttime) {
		this.starttime = starttime;
	}

	@Column(name = "endtime", nullable = false)
	public Integer getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Integer endtime) {
		this.endtime = endtime;
	}

}