package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Org entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "org", catalog = "trainshop")
public class Org implements java.io.Serializable {

	// Fields

	private Long orgId;
	private String cnname;
	private String orgcode;
	private String enname;
	private String contact;
	private String orggrade;
	private String orgprop;
	private Integer orglevel;
	private Integer serialindex;
	private String memo;
	private Long parentorgid;
	private Integer status;
	private String orglevelcode;
	private Integer sequenceno;
	private Integer deltag;
	private Long createtime;
	private Long createuser;
	private Long updateuser;
	private Long updatetime;

	// Constructors

	/** default constructor */
	public Org() {
	}

	/** minimal constructor */
	public Org(String cnname, Integer deltag) {
		this.cnname = cnname;
		this.deltag = deltag;
	}

	/** full constructor */
	public Org(String cnname, String orgcode, String enname, String contact,
			String orggrade, String orgprop, Integer orglevel,
			Integer serialindex, String memo, Long parentorgid,
			Integer status, String orglevelcode, Integer sequenceno,
			Integer deltag, Long createtime, Long createuser, Long updateuser,
			Long updatetime) {
		this.cnname = cnname;
		this.orgcode = orgcode;
		this.enname = enname;
		this.contact = contact;
		this.orggrade = orggrade;
		this.orgprop = orgprop;
		this.orglevel = orglevel;
		this.serialindex = serialindex;
		this.memo = memo;
		this.parentorgid = parentorgid;
		this.status = status;
		this.orglevelcode = orglevelcode;
		this.sequenceno = sequenceno;
		this.deltag = deltag;
		this.createtime = createtime;
		this.createuser = createuser;
		this.updateuser = updateuser;
		this.updatetime = updatetime;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ORG_ID", unique = true, nullable = false)
	public Long getOrgId() {
		return this.orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	@Column(name = "CNNAME", nullable = false, length = 120)
	public String getCnname() {
		return this.cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	@Column(name = "ORGCODE", length = 30)
	public String getOrgcode() {
		return this.orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	@Column(name = "ENNAME", length = 120)
	public String getEnname() {
		return this.enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}

	@Column(name = "CONTACT", length = 300)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "ORGGRADE", length = 120)
	public String getOrggrade() {
		return this.orggrade;
	}

	public void setOrggrade(String orggrade) {
		this.orggrade = orggrade;
	}

	@Column(name = "ORGPROP", length = 20)
	public String getOrgprop() {
		return this.orgprop;
	}

	public void setOrgprop(String orgprop) {
		this.orgprop = orgprop;
	}

	@Column(name = "ORGLEVEL")
	public Integer getOrglevel() {
		return this.orglevel;
	}

	public void setOrglevel(Integer orglevel) {
		this.orglevel = orglevel;
	}

	@Column(name = "SERIALINDEX")
	public Integer getSerialindex() {
		return this.serialindex;
	}

	public void setSerialindex(Integer serialindex) {
		this.serialindex = serialindex;
	}

	@Column(name = "MEMO", length = 100)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "PARENTORGID")
	public Long getParentorgid() {
		return this.parentorgid;
	}

	public void setParentorgid(Long parentorgid) {
		this.parentorgid = parentorgid;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "ORGLEVELCODE")
	public String getOrglevelcode() {
		return this.orglevelcode;
	}

	public void setOrglevelcode(String orglevelcode) {
		this.orglevelcode = orglevelcode;
	}

	@Column(name = "SEQUENCENO")
	public Integer getSequenceno() {
		return this.sequenceno;
	}

	public void setSequenceno(Integer sequenceno) {
		this.sequenceno = sequenceno;
	}

	@Column(name = "DELTAG", nullable = false)
	public Integer getDeltag() {
		return this.deltag;
	}

	public void setDeltag(Integer deltag) {
		this.deltag = deltag;
	}

	@Column(name = "CREATETIME")
	public Long getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	@Column(name = "CREATEUSER")
	public Long getCreateuser() {
		return this.createuser;
	}

	public void setCreateuser(Long createuser) {
		this.createuser = createuser;
	}

	@Column(name = "UPDATEUSER")
	public Long getUpdateuser() {
		return this.updateuser;
	}

	public void setUpdateuser(Long updateuser) {
		this.updateuser = updateuser;
	}

	@Column(name = "UPDATETIME")
	public Long getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Long updatetime) {
		this.updatetime = updatetime;
	}

}