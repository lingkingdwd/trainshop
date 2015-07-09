package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Crons entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "crons", catalog = "trainshop")
public class Crons implements java.io.Serializable {

	// Fields

	private Short cronId;
	private String cronCode;
	private String cronName;
	private String cronDesc;
	private Short cronOrder;
	private String cronConfig;
	private Integer thistime;
	private Integer nextime;
	private Short day;
	private String week;
	private String hour;
	private String minute;
	private Boolean enable;
	private Boolean runOnce;
	private String allowIp;
	private String alowFiles;

	// Constructors

	/** default constructor */
	public Crons() {
	}

	/** minimal constructor */
	public Crons(String cronCode, String cronName, Short cronOrder,
			String cronConfig, Integer thistime, Integer nextime, Short day,
			String week, String hour, String minute, Boolean enable,
			Boolean runOnce, String allowIp, String alowFiles) {
		this.cronCode = cronCode;
		this.cronName = cronName;
		this.cronOrder = cronOrder;
		this.cronConfig = cronConfig;
		this.thistime = thistime;
		this.nextime = nextime;
		this.day = day;
		this.week = week;
		this.hour = hour;
		this.minute = minute;
		this.enable = enable;
		this.runOnce = runOnce;
		this.allowIp = allowIp;
		this.alowFiles = alowFiles;
	}

	/** full constructor */
	public Crons(String cronCode, String cronName, String cronDesc,
			Short cronOrder, String cronConfig, Integer thistime,
			Integer nextime, Short day, String week, String hour,
			String minute, Boolean enable, Boolean runOnce, String allowIp,
			String alowFiles) {
		this.cronCode = cronCode;
		this.cronName = cronName;
		this.cronDesc = cronDesc;
		this.cronOrder = cronOrder;
		this.cronConfig = cronConfig;
		this.thistime = thistime;
		this.nextime = nextime;
		this.day = day;
		this.week = week;
		this.hour = hour;
		this.minute = minute;
		this.enable = enable;
		this.runOnce = runOnce;
		this.allowIp = allowIp;
		this.alowFiles = alowFiles;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "cron_id", unique = true, nullable = false)
	public Short getCronId() {
		return this.cronId;
	}

	public void setCronId(Short cronId) {
		this.cronId = cronId;
	}

	@Column(name = "cron_code", nullable = false, length = 20)
	public String getCronCode() {
		return this.cronCode;
	}

	public void setCronCode(String cronCode) {
		this.cronCode = cronCode;
	}

	@Column(name = "cron_name", nullable = false, length = 120)
	public String getCronName() {
		return this.cronName;
	}

	public void setCronName(String cronName) {
		this.cronName = cronName;
	}

	@Column(name = "cron_desc", length = 65535)
	public String getCronDesc() {
		return this.cronDesc;
	}

	public void setCronDesc(String cronDesc) {
		this.cronDesc = cronDesc;
	}

	@Column(name = "cron_order", nullable = false)
	public Short getCronOrder() {
		return this.cronOrder;
	}

	public void setCronOrder(Short cronOrder) {
		this.cronOrder = cronOrder;
	}

	@Column(name = "cron_config", nullable = false, length = 65535)
	public String getCronConfig() {
		return this.cronConfig;
	}

	public void setCronConfig(String cronConfig) {
		this.cronConfig = cronConfig;
	}

	@Column(name = "thistime", nullable = false)
	public Integer getThistime() {
		return this.thistime;
	}

	public void setThistime(Integer thistime) {
		this.thistime = thistime;
	}

	@Column(name = "nextime", nullable = false)
	public Integer getNextime() {
		return this.nextime;
	}

	public void setNextime(Integer nextime) {
		this.nextime = nextime;
	}

	@Column(name = "day", nullable = false)
	public Short getDay() {
		return this.day;
	}

	public void setDay(Short day) {
		this.day = day;
	}

	@Column(name = "week", nullable = false, length = 1)
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "hour", nullable = false, length = 2)
	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	@Column(name = "minute", nullable = false)
	public String getMinute() {
		return this.minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Column(name = "enable", nullable = false)
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Column(name = "run_once", nullable = false)
	public Boolean getRunOnce() {
		return this.runOnce;
	}

	public void setRunOnce(Boolean runOnce) {
		this.runOnce = runOnce;
	}

	@Column(name = "allow_ip", nullable = false, length = 100)
	public String getAllowIp() {
		return this.allowIp;
	}

	public void setAllowIp(String allowIp) {
		this.allowIp = allowIp;
	}

	@Column(name = "alow_files", nullable = false)
	public String getAlowFiles() {
		return this.alowFiles;
	}

	public void setAlowFiles(String alowFiles) {
		this.alowFiles = alowFiles;
	}

}