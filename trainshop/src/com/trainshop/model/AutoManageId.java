package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AutoManageId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class AutoManageId implements java.io.Serializable {

	// Fields

	private Long itemId;
	private String type;

	// Constructors

	/** default constructor */
	public AutoManageId() {
	}

	/** full constructor */
	public AutoManageId(Long itemId, String type) {
		this.itemId = itemId;
		this.type = type;
	}

	// Property accessors

	@Column(name = "item_id", nullable = false)
	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AutoManageId))
			return false;
		AutoManageId castOther = (AutoManageId) other;

		return ((this.getItemId() == castOther.getItemId()) || (this
				.getItemId() != null && castOther.getItemId() != null && this
				.getItemId().equals(castOther.getItemId())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}