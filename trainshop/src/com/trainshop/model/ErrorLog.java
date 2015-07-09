package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ErrorLog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "error_log", catalog = "trainshop")
public class ErrorLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private String info;
	private String file;
	private Integer time;

	// Constructors

	/** default constructor */
	public ErrorLog() {
	}

	/** full constructor */
	public ErrorLog(String info, String file, Integer time) {
		this.info = info;
		this.file = file;
		this.time = time;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "info", nullable = false)
	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "file", nullable = false, length = 100)
	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Column(name = "time", nullable = false)
	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

}