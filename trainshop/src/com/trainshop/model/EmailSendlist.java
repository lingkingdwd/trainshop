package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailSendlist entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email_sendlist", catalog = "trainshop")
public class EmailSendlist implements java.io.Serializable {

	// Fields

	private Long id;
	private String email;
	private Long templateId;
	private String emailContent;
	private Boolean error;
	private Short pri;
	private Integer lastSend;

	// Constructors

	/** default constructor */
	public EmailSendlist() {
	}

	/** full constructor */
	public EmailSendlist(String email, Long templateId, String emailContent,
			Boolean error, Short pri, Integer lastSend) {
		this.email = email;
		this.templateId = templateId;
		this.emailContent = emailContent;
		this.error = error;
		this.pri = pri;
		this.lastSend = lastSend;
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

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "template_id", nullable = false)
	public Long getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	@Column(name = "email_content", nullable = false, length = 65535)
	public String getEmailContent() {
		return this.emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	@Column(name = "error", nullable = false)
	public Boolean getError() {
		return this.error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	@Column(name = "pri", nullable = false)
	public Short getPri() {
		return this.pri;
	}

	public void setPri(Short pri) {
		this.pri = pri;
	}

	@Column(name = "last_send", nullable = false)
	public Integer getLastSend() {
		return this.lastSend;
	}

	public void setLastSend(Integer lastSend) {
		this.lastSend = lastSend;
	}

}