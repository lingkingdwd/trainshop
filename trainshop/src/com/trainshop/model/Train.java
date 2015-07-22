package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Train entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "train", catalog = "trainshop")
public class Train implements java.io.Serializable {

	// Fields

	private Long trainId;
	private Long orgId;
	private String trainNumber;
	private String startStation;
	private String endStation;
	private String startTime;
	private String endTime;
	private Long createtime;
	private Long createuser;
	private Long updateuser;
	private Long updatetime;

	// Constructors

	/** default constructor */
	public Train() {
	}

	/** minimal constructor */
	public Train(Long trainId, String trainNumber, String startStation,
			String endStation, String startTime, String endTime) {
		this.trainId = trainId;
		this.trainNumber = trainNumber;
		this.startStation = startStation;
		this.endStation = endStation;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Train(Long trainId, Long orgId, String trainNumber,
			String startStation, String endStation, String startTime,
			String endTime, Long createtime, Long createuser, Long updateuser,
			Long updatetime) {
		this.trainId = trainId;
		this.orgId = orgId;
		this.trainNumber = trainNumber;
		this.startStation = startStation;
		this.endStation = endStation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updateuser = updateuser;
		this.updatetime = updatetime;
	}

	// Property accessors
	@Id
	@Column(name = "train_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getTrainId() {
		return this.trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	@Column(name = "ORG_ID")
	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(name = "train_number", nullable = false, length = 30)
	public String getTrainNumber() {
		return this.trainNumber;
	}

	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}

	@Column(name = "start_station", nullable = false, length = 100)
	public String getStartStation() {
		return this.startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	@Column(name = "end_station", nullable = false, length = 100)
	public String getEndStation() {
		return this.endStation;
	}

	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	@Column(name = "start_time", nullable = false)
	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Column(name = "CREATETIME")
	public Long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	@Column(name = "CREATEUSER")
	public Long getCreateuser() {
		return this.createuser;
	}

	public void setCreateuser(Long createuser) {
		this.createuser = createuser;
	}

	@Column(name = "UPDATEUSER")
	public Long getUpdateuser() {
		return this.updateuser;
	}

	public void setUpdateuser(Long updateuser) {
		this.updateuser = updateuser;
	}

	@Column(name = "UPDATETIME")
	public Long getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

}