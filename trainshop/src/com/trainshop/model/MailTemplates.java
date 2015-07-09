package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * MailTemplates entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "mail_templates", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "template_code"))
public class MailTemplates implements java.io.Serializable {

	// Fields

	private Boolean templateId;
	private String templateCode;
	private Boolean isHtml;
	private String templateSubject;
	private String templateContent;
	private Integer lastModify;
	private Integer lastSend;
	private String type;

	// Constructors

	/** default constructor */
	public MailTemplates() {
	}

	/** full constructor */
	public MailTemplates(String templateCode, Boolean isHtml,
			String templateSubject, String templateContent, Integer lastModify,
			Integer lastSend, String type) {
		this.templateCode = templateCode;
		this.isHtml = isHtml;
		this.templateSubject = templateSubject;
		this.templateContent = templateContent;
		this.lastModify = lastModify;
		this.lastSend = lastSend;
		this.type = type;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "template_id", unique = true, nullable = false)
	public Boolean getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(Boolean templateId) {
		this.templateId = templateId;
	}

	@Column(name = "template_code", unique = true, nullable = false, length = 30)
	public String getTemplateCode() {
		return this.templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	@Column(name = "is_html", nullable = false)
	public Boolean getIsHtml() {
		return this.isHtml;
	}

	public void setIsHtml(Boolean isHtml) {
		this.isHtml = isHtml;
	}

	@Column(name = "template_subject", nullable = false, length = 200)
	public String getTemplateSubject() {
		return this.templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}

	@Column(name = "template_content", nullable = false, length = 65535)
	public String getTemplateContent() {
		return this.templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	@Column(name = "last_modify", nullable = false)
	public Integer getLastModify() {
		return this.lastModify;
	}

	public void setLastModify(Integer lastModify) {
		this.lastModify = lastModify;
	}

	@Column(name = "last_send", nullable = false)
	public Integer getLastSend() {
		return this.lastSend;
	}

	public void setLastSend(Integer lastSend) {
		this.lastSend = lastSend;
	}

	@Column(name = "type", nullable = false, length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}