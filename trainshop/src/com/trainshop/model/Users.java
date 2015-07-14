package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "users", catalog = "trainshop", uniqueConstraints = @UniqueConstraint(columnNames = "user_name"))
public class Users implements java.io.Serializable {

	// Fields

	private Long userId;
	private String email;
	private String userName;
	private String password;
	private String question;
	private String answer;
	private Integer sex;
	private Long birthday;
	private Double userMoney;
	private Double frozenMoney;
	private Integer payPoints;
	private Integer rankPoints;
	private Integer addressId;
	private Long regTime;
	private Long lastLogin;
	private Long lastTime;
	private String lastIp;
	private Integer visitCount;
	private Integer userRank;
	private Integer isSpecial;
	private String ecSalt;
	private String salt;
	private Integer parentId;
	private Integer flag;
	private String alias;
	private String msn;
	private String qq;
	private String officePhone;
	private String homePhone;
	private String mobilePhone;
	private Integer isValidated;
	private Double creditLine;
	private String passwdQuestion;
	private String passwdAnswer;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String userName, String password, Integer flag,
			String mobilePhone) {
		this.userName = userName;
		this.password = password;
		this.flag = flag;
		this.mobilePhone = mobilePhone;
	}

	/** full constructor */
	public Users(String email, String userName, String password,
			String question, String answer, Integer sex, Long birthday,
			Double userMoney, Double frozenMoney, Integer payPoints,
			Integer rankPoints, Integer addressId, Long regTime,
			Long lastLogin, Long lastTime, String lastIp, Integer visitCount,
			Integer userRank, Integer isSpecial, String ecSalt, String salt,
			Integer parentId, Integer flag, String alias, String msn,
			String qq, String officePhone, String homePhone,
			String mobilePhone, Integer isValidated, Double creditLine,
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
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "email")
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

	@Column(name = "password", nullable = false, length = 128)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "question")
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column(name = "answer")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "sex")
	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Column(name = "birthday")
	public Long getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	@Column(name = "user_money", precision = 10)
	public Double getUserMoney() {
		return this.userMoney;
	}

	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}

	@Column(name = "frozen_money", precision = 10)
	public Double getFrozenMoney() {
		return this.frozenMoney;
	}

	public void setFrozenMoney(Double frozenMoney) {
		this.frozenMoney = frozenMoney;
	}

	@Column(name = "pay_points")
	public Integer getPayPoints() {
		return this.payPoints;
	}

	public void setPayPoints(Integer payPoints) {
		this.payPoints = payPoints;
	}

	@Column(name = "rank_points")
	public Integer getRankPoints() {
		return this.rankPoints;
	}

	public void setRankPoints(Integer rankPoints) {
		this.rankPoints = rankPoints;
	}

	@Column(name = "address_id")
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "reg_time")
	public Long getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Long regTime) {
		this.regTime = regTime;
	}

	@Column(name = "last_login")
	public Long getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Long lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "last_time")
	public Long getLastTime() {
		return this.lastTime;
	}

	public void setLastTime(Long lastTime) {
		this.lastTime = lastTime;
	}

	@Column(name = "last_ip", length = 15)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "visit_count")
	public Integer getVisitCount() {
		return this.visitCount;
	}

	public void setVisitCount(Integer visitCount) {
		this.visitCount = visitCount;
	}

	@Column(name = "user_rank")
	public Integer getUserRank() {
		return this.userRank;
	}

	public void setUserRank(Integer userRank) {
		this.userRank = userRank;
	}

	@Column(name = "is_special")
	public Integer getIsSpecial() {
		return this.isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}

	@Column(name = "ec_salt", length = 10)
	public String getEcSalt() {
		return this.ecSalt;
	}

	public void setEcSalt(String ecSalt) {
		this.ecSalt = ecSalt;
	}

	@Column(name = "salt", length = 10)
	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Column(name = "parent_id")
	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Column(name = "flag", nullable = false)
	public Integer getFlag() {
		return this.flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "alias", length = 60)
	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Column(name = "msn", length = 60)
	public String getMsn() {
		return this.msn;
	}

	public void setMsn(String msn) {
		this.msn = msn;
	}

	@Column(name = "qq", length = 20)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "office_phone", length = 20)
	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	@Column(name = "home_phone", length = 20)
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

	@Column(name = "is_validated")
	public Integer getIsValidated() {
		return this.isValidated;
	}

	public void setIsValidated(Integer isValidated) {
		this.isValidated = isValidated;
	}

	@Column(name = "credit_line", precision = 10)
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