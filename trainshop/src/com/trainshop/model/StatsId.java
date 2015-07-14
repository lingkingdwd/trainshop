package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StatsId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class StatsId implements java.io.Serializable {

	// Fields

	private Long accessTime;
	private String ipAddress;
	private Short visitTimes;
	private String browser;
	private String system;
	private String language;
	private String area;
	private String refererDomain;
	private String refererPath;
	private String accessUrl;

	// Constructors

	/** default constructor */
	public StatsId() {
	}

	/** full constructor */
	public StatsId(Long accessTime, String ipAddress, Short visitTimes,
			String browser, String system, String language, String area,
			String refererDomain, String refererPath, String accessUrl) {
		this.accessTime = accessTime;
		this.ipAddress = ipAddress;
		this.visitTimes = visitTimes;
		this.browser = browser;
		this.system = system;
		this.language = language;
		this.area = area;
		this.refererDomain = refererDomain;
		this.refererPath = refererPath;
		this.accessUrl = accessUrl;
	}

	// Property accessors

	@Column(name = "access_time", nullable = false)
	public Long getAccessTime() {
		return this.accessTime;
	}

	public void setAccessTime(Long accessTime) {
		this.accessTime = accessTime;
	}

	@Column(name = "ip_address", nullable = false, length = 15)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "visit_times", nullable = false)
	public Short getVisitTimes() {
		return this.visitTimes;
	}

	public void setVisitTimes(Short visitTimes) {
		this.visitTimes = visitTimes;
	}

	@Column(name = "browser", nullable = false, length = 60)
	public String getBrowser() {
		return this.browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(name = "system", nullable = false, length = 20)
	public String getSystem() {
		return this.system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	@Column(name = "language", nullable = false, length = 20)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "area", nullable = false, length = 30)
	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "referer_domain", nullable = false, length = 100)
	public String getRefererDomain() {
		return this.refererDomain;
	}

	public void setRefererDomain(String refererDomain) {
		this.refererDomain = refererDomain;
	}

	@Column(name = "referer_path", nullable = false, length = 200)
	public String getRefererPath() {
		return this.refererPath;
	}

	public void setRefererPath(String refererPath) {
		this.refererPath = refererPath;
	}

	@Column(name = "access_url", nullable = false)
	public String getAccessUrl() {
		return this.accessUrl;
	}

	public void setAccessUrl(String accessUrl) {
		this.accessUrl = accessUrl;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StatsId))
			return false;
		StatsId castOther = (StatsId) other;

		return ((this.getAccessTime() == castOther.getAccessTime()) || (this
				.getAccessTime() != null && castOther.getAccessTime() != null && this
				.getAccessTime().equals(castOther.getAccessTime())))
				&& ((this.getIpAddress() == castOther.getIpAddress()) || (this
						.getIpAddress() != null
						&& castOther.getIpAddress() != null && this
						.getIpAddress().equals(castOther.getIpAddress())))
				&& ((this.getVisitTimes() == castOther.getVisitTimes()) || (this
						.getVisitTimes() != null
						&& castOther.getVisitTimes() != null && this
						.getVisitTimes().equals(castOther.getVisitTimes())))
				&& ((this.getBrowser() == castOther.getBrowser()) || (this
						.getBrowser() != null && castOther.getBrowser() != null && this
						.getBrowser().equals(castOther.getBrowser())))
				&& ((this.getSystem() == castOther.getSystem()) || (this
						.getSystem() != null && castOther.getSystem() != null && this
						.getSystem().equals(castOther.getSystem())))
				&& ((this.getLanguage() == castOther.getLanguage()) || (this
						.getLanguage() != null
						&& castOther.getLanguage() != null && this
						.getLanguage().equals(castOther.getLanguage())))
				&& ((this.getArea() == castOther.getArea()) || (this.getArea() != null
						&& castOther.getArea() != null && this.getArea()
						.equals(castOther.getArea())))
				&& ((this.getRefererDomain() == castOther.getRefererDomain()) || (this
						.getRefererDomain() != null
						&& castOther.getRefererDomain() != null && this
						.getRefererDomain()
						.equals(castOther.getRefererDomain())))
				&& ((this.getRefererPath() == castOther.getRefererPath()) || (this
						.getRefererPath() != null
						&& castOther.getRefererPath() != null && this
						.getRefererPath().equals(castOther.getRefererPath())))
				&& ((this.getAccessUrl() == castOther.getAccessUrl()) || (this
						.getAccessUrl() != null
						&& castOther.getAccessUrl() != null && this
						.getAccessUrl().equals(castOther.getAccessUrl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getAccessTime() == null ? 0 : this.getAccessTime()
						.hashCode());
		result = 37 * result
				+ (getIpAddress() == null ? 0 : this.getIpAddress().hashCode());
		result = 37
				* result
				+ (getVisitTimes() == null ? 0 : this.getVisitTimes()
						.hashCode());
		result = 37 * result
				+ (getBrowser() == null ? 0 : this.getBrowser().hashCode());
		result = 37 * result
				+ (getSystem() == null ? 0 : this.getSystem().hashCode());
		result = 37 * result
				+ (getLanguage() == null ? 0 : this.getLanguage().hashCode());
		result = 37 * result
				+ (getArea() == null ? 0 : this.getArea().hashCode());
		result = 37
				* result
				+ (getRefererDomain() == null ? 0 : this.getRefererDomain()
						.hashCode());
		result = 37
				* result
				+ (getRefererPath() == null ? 0 : this.getRefererPath()
						.hashCode());
		result = 37 * result
				+ (getAccessUrl() == null ? 0 : this.getAccessUrl().hashCode());
		return result;
	}

}