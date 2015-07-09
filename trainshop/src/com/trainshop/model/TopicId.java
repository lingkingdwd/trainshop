package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TopicId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class TopicId implements java.io.Serializable {

	// Fields

	private Integer topicId;
	private String title;
	private String intro;
	private Integer startTime;
	private Integer endTime;
	private String data;
	private String template;
	private String css;
	private String topicImg;
	private String titlePic;
	private String baseStyle;
	private String htmls;
	private String keywords;
	private String description;

	// Constructors

	/** default constructor */
	public TopicId() {
	}

	/** minimal constructor */
	public TopicId(Integer topicId, String title, String intro,
			Integer startTime, Integer endTime, String data, String template,
			String css) {
		this.topicId = topicId;
		this.title = title;
		this.intro = intro;
		this.startTime = startTime;
		this.endTime = endTime;
		this.data = data;
		this.template = template;
		this.css = css;
	}

	/** full constructor */
	public TopicId(Integer topicId, String title, String intro,
			Integer startTime, Integer endTime, String data, String template,
			String css, String topicImg, String titlePic, String baseStyle,
			String htmls, String keywords, String description) {
		this.topicId = topicId;
		this.title = title;
		this.intro = intro;
		this.startTime = startTime;
		this.endTime = endTime;
		this.data = data;
		this.template = template;
		this.css = css;
		this.topicImg = topicImg;
		this.titlePic = titlePic;
		this.baseStyle = baseStyle;
		this.htmls = htmls;
		this.keywords = keywords;
		this.description = description;
	}

	// Property accessors

	@Column(name = "topic_id", nullable = false)
	public Integer getTopicId() {
		return this.topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "intro", nullable = false, length = 65535)
	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Column(name = "start_time", nullable = false)
	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	@Column(name = "end_time", nullable = false)
	public Integer getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	@Column(name = "data", nullable = false, length = 65535)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "template", nullable = false)
	public String getTemplate() {
		return this.template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Column(name = "css", nullable = false, length = 65535)
	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	@Column(name = "topic_img")
	public String getTopicImg() {
		return this.topicImg;
	}

	public void setTopicImg(String topicImg) {
		this.topicImg = topicImg;
	}

	@Column(name = "title_pic")
	public String getTitlePic() {
		return this.titlePic;
	}

	public void setTitlePic(String titlePic) {
		this.titlePic = titlePic;
	}

	@Column(name = "base_style", length = 6)
	public String getBaseStyle() {
		return this.baseStyle;
	}

	public void setBaseStyle(String baseStyle) {
		this.baseStyle = baseStyle;
	}

	@Column(name = "htmls", length = 16777215)
	public String getHtmls() {
		return this.htmls;
	}

	public void setHtmls(String htmls) {
		this.htmls = htmls;
	}

	@Column(name = "keywords")
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TopicId))
			return false;
		TopicId castOther = (TopicId) other;

		return ((this.getTopicId() == castOther.getTopicId()) || (this
				.getTopicId() != null && castOther.getTopicId() != null && this
				.getTopicId().equals(castOther.getTopicId())))
				&& ((this.getTitle() == castOther.getTitle()) || (this
						.getTitle() != null && castOther.getTitle() != null && this
						.getTitle().equals(castOther.getTitle())))
				&& ((this.getIntro() == castOther.getIntro()) || (this
						.getIntro() != null && castOther.getIntro() != null && this
						.getIntro().equals(castOther.getIntro())))
				&& ((this.getStartTime() == castOther.getStartTime()) || (this
						.getStartTime() != null
						&& castOther.getStartTime() != null && this
						.getStartTime().equals(castOther.getStartTime())))
				&& ((this.getEndTime() == castOther.getEndTime()) || (this
						.getEndTime() != null && castOther.getEndTime() != null && this
						.getEndTime().equals(castOther.getEndTime())))
				&& ((this.getData() == castOther.getData()) || (this.getData() != null
						&& castOther.getData() != null && this.getData()
						.equals(castOther.getData())))
				&& ((this.getTemplate() == castOther.getTemplate()) || (this
						.getTemplate() != null
						&& castOther.getTemplate() != null && this
						.getTemplate().equals(castOther.getTemplate())))
				&& ((this.getCss() == castOther.getCss()) || (this.getCss() != null
						&& castOther.getCss() != null && this.getCss().equals(
						castOther.getCss())))
				&& ((this.getTopicImg() == castOther.getTopicImg()) || (this
						.getTopicImg() != null
						&& castOther.getTopicImg() != null && this
						.getTopicImg().equals(castOther.getTopicImg())))
				&& ((this.getTitlePic() == castOther.getTitlePic()) || (this
						.getTitlePic() != null
						&& castOther.getTitlePic() != null && this
						.getTitlePic().equals(castOther.getTitlePic())))
				&& ((this.getBaseStyle() == castOther.getBaseStyle()) || (this
						.getBaseStyle() != null
						&& castOther.getBaseStyle() != null && this
						.getBaseStyle().equals(castOther.getBaseStyle())))
				&& ((this.getHtmls() == castOther.getHtmls()) || (this
						.getHtmls() != null && castOther.getHtmls() != null && this
						.getHtmls().equals(castOther.getHtmls())))
				&& ((this.getKeywords() == castOther.getKeywords()) || (this
						.getKeywords() != null
						&& castOther.getKeywords() != null && this
						.getKeywords().equals(castOther.getKeywords())))
				&& ((this.getDescription() == castOther.getDescription()) || (this
						.getDescription() != null
						&& castOther.getDescription() != null && this
						.getDescription().equals(castOther.getDescription())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getTopicId() == null ? 0 : this.getTopicId().hashCode());
		result = 37 * result
				+ (getTitle() == null ? 0 : this.getTitle().hashCode());
		result = 37 * result
				+ (getIntro() == null ? 0 : this.getIntro().hashCode());
		result = 37 * result
				+ (getStartTime() == null ? 0 : this.getStartTime().hashCode());
		result = 37 * result
				+ (getEndTime() == null ? 0 : this.getEndTime().hashCode());
		result = 37 * result
				+ (getData() == null ? 0 : this.getData().hashCode());
		result = 37 * result
				+ (getTemplate() == null ? 0 : this.getTemplate().hashCode());
		result = 37 * result
				+ (getCss() == null ? 0 : this.getCss().hashCode());
		result = 37 * result
				+ (getTopicImg() == null ? 0 : this.getTopicImg().hashCode());
		result = 37 * result
				+ (getTitlePic() == null ? 0 : this.getTitlePic().hashCode());
		result = 37 * result
				+ (getBaseStyle() == null ? 0 : this.getBaseStyle().hashCode());
		result = 37 * result
				+ (getHtmls() == null ? 0 : this.getHtmls().hashCode());
		result = 37 * result
				+ (getKeywords() == null ? 0 : this.getKeywords().hashCode());
		result = 37
				* result
				+ (getDescription() == null ? 0 : this.getDescription()
						.hashCode());
		return result;
	}

}