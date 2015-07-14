package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FriendLink entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "friend_link", catalog = "trainshop")
public class FriendLink implements java.io.Serializable {

	// Fields

	private Long linkId;
	private String linkName;
	private String linkUrl;
	private String linkLogo;
	private Short showOrder;

	// Constructors

	/** default constructor */
	public FriendLink() {
	}

	/** full constructor */
	public FriendLink(String linkName, String linkUrl, String linkLogo,
			Short showOrder) {
		this.linkName = linkName;
		this.linkUrl = linkUrl;
		this.linkLogo = linkLogo;
		this.showOrder = showOrder;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "link_id", unique = true, nullable = false)
	public Long getLinkId() {
		return this.linkId;
	}

	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}

	@Column(name = "link_name", nullable = false)
	public String getLinkName() {
		return this.linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	@Column(name = "link_url", nullable = false)
	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Column(name = "link_logo", nullable = false)
	public String getLinkLogo() {
		return this.linkLogo;
	}

	public void setLinkLogo(String linkLogo) {
		this.linkLogo = linkLogo;
	}

	@Column(name = "show_order", nullable = false)
	public Short getShowOrder() {
		return this.showOrder;
	}

	public void setShowOrder(Short showOrder) {
		this.showOrder = showOrder;
	}

}