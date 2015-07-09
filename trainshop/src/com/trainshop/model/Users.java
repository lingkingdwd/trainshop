package com.trainshop.model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class Users implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String email;
	private String userName;
	private String password;
	private String question;
	private String answer;
	private Boolean sex;
	private Date birthday;
	private Double userMoney;
	private Double frozenMoney;
	private Integer payPoints;
	private Integer rankPoints;
	private Integer addressId;
	private Integer regTime;
	private Integer lastLogin;
	private Timestamp lastTime;
	private String lastIp;
	private Short visitCount;
	private Short userRank;
	private Short isSpecial;
	private String ecSalt;
	private String salt;
	private Integer parentId;
	private Short flag;
	private String alias;
	private String msn;
	private String qq;
	private String officePhone;
	private String homePhone;
	private String mobilePhone;
	private Short isValidated;
	private Double creditLine;
	private String passwdQuestion;
	private String passwdAnswer;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String email, String userName, String password,
			String question, String answer, Boolean sex, Date birthday,
			Double userMoney, Double frozenMoney, Integer payPoints,
			Integer rankPoints, Integer addressId, Integer regTime,
			Integer lastLogin, Timestamp lastTime, String lastIp,
			Short visitCount, Short userRank, Short isSpecial, String salt,
			Integer parentId, Short flag, String alias, String msn, String qq,
			String officePhone, String homePhone, String mobilePhone,
			Short isValidated, Double creditLine) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.sex = sex;
		this.birthday = birthday;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.payPoints = payPoints;
		this.rankPoints = rankPoints;
		this.addressId = addressId;
		this.regTime = regTime;
		this.lastLogin = lastLogin;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.visitCount = visitCount;
		this.userRank = userRank;
		this.isSpecial = isSpecial;
		this.salt = salt;
		this.parentId = parentId;
		this.flag = flag;
		this.alias = alias;
		this.msn = msn;
		this.qq = qq;
		this.officePhone = officePhone;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.isValidated = isValidated;
		this.creditLine = creditLine;
	}

	/** full constructor */
	public Users(String email, String userName, String password,
			String question, String answer, Boolean sex, Date birthday,
			Double userMoney, Double frozenMoney, Integer payPoints,
			Integer rankPoints, Integer addressId, Integer regTime,
			Integer lastLogin, Timestamp lastTime, String lastIp,
			Short visitCount, Short userRank, Short isSpecial, String ecSalt,
			String salt, Integer parentId, Short flag, String alias,
			String msn, String qq, String officePhone, String homePhone,
			String mobilePhone, Short isValidated, Double creditLine,
			String passwdQuestion, String passwdAnswer) {
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.sex = sex;
		this.birthday = birthday;
		this.userMoney = userMoney;
		this.frozenMoney = frozenMoney;
		this.payPoints = payPoints;
		this.rankPoints = rankPoints;
		this.addressId = addressId;
		this.regTime = regTime;
		this.lastLogin = lastLogin;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.visitCount = visitCount;
		this.userRank = userRank;
		this.isSpecial = isSpecial;
		this.ecSalt = ecSalt;
		this.salt = salt;
		this.parentId = parentId;
		this.flag = flag;
		this.alias = alias;
		this.msn = msn;
		this.qq = qq;
		this.officePhone = officePhone;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.isValidated = isValidated;
		this.creditLine = creditLine;
		this.passwdQuestion = passwdQuestion;
		this.passwdAnswer = passwdAnswer;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "question", nullable = false)
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "answer", nullable = false)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "sex", nullable = false)
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", nullable = false, length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "user_money", nullable = false, precision = 10)
	public Double getUserMoney() {
		return this.userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	@Column(name = "frozen_money", nullable = false, precision = 10)
	public Double getFrozenMoney() {
		return this.frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	@Column(name = "pay_points", nullable = false)
	public Integer getPayPoints() {
		return this.payPoints;
	}

	public void setPayPoints(Integer payPoints) {
		this.payPoints = payPoints;
	}

	@Column(name = "rank_points", nullable = false)
	public Integer getRankPoints() {
		return this.rankPoints;
	}

	public void setRankPoints(Integer rankPoints) {
		this.rankPoints = rankPoints;
	}

	@Column(name = "address_id", nullable = false)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "reg_time", nullable = false)
	public Integer getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Integer regTime) {
		this.regTime = regTime;
	}

	@Column(name = "last_login", nullable = false)
	public Integer getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Integer lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "last_time", nullable = false, length = 19)
	public Timestamp getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "last_ip", nullable = false, length = 15)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "visit_count", nullable = false)
	public Short getVisitCount() {
		return this.visitCount;
	}

	public void setVisitCount(Short visitCount) {
		this.visitCount = visitCount;
	}

	@Column(name = "user_rank", nullable = false)
	public Short getUserRank() {
		return this.userRank;
	}

	public void setUserRank(Short userRank) {
		this.userRank = userRank;
	}

	@Column(name = "is_special", nullable = false)
	public Short getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Short isSpecial) {
		this.isSpecial = isSpecial;
	}

	@Column(name = "ec_salt", length = 10)
	public String getEcSalt() {
		return this.ecSalt;
	}

	public void setEcSalt(String ecSalt) {
		this.ecSalt = ecSalt;
	}

	@Column(name = "salt", nullable = false, length = 10)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "parent_id", nullable = false)
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "flag", nullable = false)
	public Short getFlag() {
		return this.flag;
	}

	public void setFlag(Short flag) {
		this.flag = flag;
	}

	@Column(name = "alias", nullable = false, length = 60)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(name = "msn", nullable = false, length = 60)
	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column(name = "qq", nullable = false, length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "office_phone", nullable = false, length = 20)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "home_phone", nullable = false, length = 20)
	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	@Column(name = "mobile_phone", nullable = false, length = 20)
	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	@Column(name = "is_validated", nullable = false)
	public Short getIsValidated() {
		return this.isValidated;
	}

	public void setIsValidated(Short isValidated) {
		this.isValidated = isValidated;
	}

	@Column(name = "credit_line", nullable = false, precision = 10)
	public Double getCreditLine() {
		return this.creditLine;
	}

	public void setCreditLine(Double creditLine) {
		this.creditLine = creditLine;
	}

	@Column(name = "passwd_question", length = 50)
	public String getPasswdQuestion() {
		return this.passwdQuestion;
	}

	public void setPasswdQuestion(String passwdQuestion) {
		this.passwdQuestion = passwdQuestion;
	}

	@Column(name = "passwd_answer")
	public String getPasswdAnswer() {
		return this.passwdAnswer;
	}

	public void setPasswdAnswer(String passwdAnswer) {
		this.passwdAnswer = passwdAnswer;
	}

}