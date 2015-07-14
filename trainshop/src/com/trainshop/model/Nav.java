package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Nav entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "nav", catalog = "trainshop")
public class Nav implements java.io.Serializable {

	// Fields

	private Long id;
	private String ctype;
	private Short cid;
	private String name;
	private Boolean ifshow;
	private Boolean vieworder;
	private Boolean opennew;
	private String url;
	private String type;

	// Constructors

	/** default constructor */
	public Nav() {
	}

	/** minimal constructor */
	public Nav(String name, Boolean ifshow, Boolean vieworder, Boolean opennew,
			String url, String type) {
		this.name = name;
		this.ifshow = ifshow;
		this.vieworder = vieworder;
		this.opennew = opennew;
		this.url = url;
		this.type = type;
	}

	/** full constructor */
	public Nav(String ctype, Short cid, String name, Boolean ifshow,
			Boolean vieworder, Boolean opennew, String url, String type) {
		this.ctype = ctype;
		this.cid = cid;
		this.name = name;
		this.ifshow = ifshow;
		this.vieworder = vieworder;
		this.opennew = opennew;
		this.url = url;
		this.type = type;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ctype", length = 10)
	public String getCtype() {
		return this.ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Column(name = "cid")
	public Short getCid() {
		return this.cid;
	}

	public void setCid(Short cid) {
		this.cid = cid;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ifshow", nullable = false)
	public Boolean getIfshow() {
		return this.ifshow;
	}

	public void setIfshow(Boolean ifshow) {
		this.ifshow = ifshow;
	}

	@Column(name = "vieworder", nullable = false)
	public Boolean getVieworder() {
		return this.vieworder;
	}

	public void setVieworder(Boolean vieworder) {
		this.vieworder = vieworder;
	}

	@Column(name = "opennew", nullable = false)
	public Boolean getOpennew() {
		return this.opennew;
	}

	public void setOpennew(Boolean opennew) {
		this.opennew = opennew;
	}

	@Column(name = "url", nullable = false)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}