package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "trainshop")
public class Article implements java.io.Serializable {

	// Fields

	private Integer articleId;
	private Short catId;
	private String title;
	private String content;
	private String author;
	private String authorEmail;
	private String keywords;
	private Boolean articleType;
	private Boolean isOpen;
	private Integer addTime;
	private String fileUrl;
	private Boolean openType;
	private String link;
	private String description;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Short catId, String title, String content, String author,
			String authorEmail, String keywords, Boolean articleType,
			Boolean isOpen, Integer addTime, String fileUrl, Boolean openType,
			String link) {
		this.catId = catId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.authorEmail = authorEmail;
		this.keywords = keywords;
		this.articleType = articleType;
		this.isOpen = isOpen;
		this.addTime = addTime;
		this.fileUrl = fileUrl;
		this.openType = openType;
		this.link = link;
	}

	/** full constructor */
	public Article(Short catId, String title, String content, String author,
			String authorEmail, String keywords, Boolean articleType,
			Boolean isOpen, Integer addTime, String fileUrl, Boolean openType,
			String link, String description) {
		this.catId = catId;
		this.title = title;
		this.content = content;
		this.author = author;
		this.authorEmail = authorEmail;
		this.keywords = keywords;
		this.articleType = articleType;
		this.isOpen = isOpen;
		this.addTime = addTime;
		this.fileUrl = fileUrl;
		this.openType = openType;
		this.link = link;
		this.description = description;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "article_id", unique = true, nullable = false)
	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	@Column(name = "cat_id", nullable = false)
	public Short getCatId() {
		return this.catId;
	}

	public void setCatId(Short catId) {
		this.catId = catId;
	}

	@Column(name = "title", nullable = false, length = 150)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "author", nullable = false, length = 30)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "author_email", nullable = false, length = 60)
	public String getAuthorEmail() {
		return this.authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	@Column(name = "keywords", nullable = false)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "article_type", nullable = false)
	public Boolean getArticleType() {
		return this.articleType;
	}

	public void setArticleType(Boolean articleType) {
		this.articleType = articleType;
	}

	@Column(name = "is_open", nullable = false)
	public Boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "file_url", nullable = false)
	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	@Column(name = "open_type", nullable = false)
	public Boolean getOpenType() {
		return this.openType;
	}

	public void setOpenType(Boolean openType) {
		this.openType = openType;
	}

	@Column(name = "link", nullable = false)
	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}