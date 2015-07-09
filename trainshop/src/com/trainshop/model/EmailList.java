package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailList entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email_list", catalog = "trainshop")
public class EmailList implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private Boolean stat;
	private String hash;

	// Constructors

	/** default constructor */
	public EmailList() {
	}

	/** full constructor */
	public EmailList(String email, Boolean stat, String hash) {
		this.email = email;
		this.stat = stat;
		this.hash = hash;
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

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "stat", nullable = false)
	public Boolean getStat() {
		return this.stat;
	}

	public void setStat(Boolean stat) {
		this.stat = stat;
	}

	@Column(name = "hash", nullable = false, length = 10)
	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}