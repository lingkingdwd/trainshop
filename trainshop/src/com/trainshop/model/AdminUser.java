package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AdminUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "admin_user", catalog = "trainshop")
public class AdminUser implements java.io.Serializable {

	// Fields

	private Short userId;
	private String userName;
	private String email;
	private String password;
	private String ecSalt;
	private Integer addTime;
	private Integer lastLogin;
	private String lastIp;
	private String actionList;
	private String navList;
	private String langType;
	private Short agencyId;
	private Short suppliersId;
	private String todolist;
	private Short roleId;

	// Constructors

	/** default constructor */
	public AdminUser() {
	}

	/** minimal constructor */
	public AdminUser(String userName, String email, String password,
			Integer addTime, Integer lastLogin, String lastIp,
			String actionList, String navList, String langType, Short agencyId) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.addTime = addTime;
		this.lastLogin = lastLogin;
		this.lastIp = lastIp;
		this.actionList = actionList;
		this.navList = navList;
		this.langType = langType;
		this.agencyId = agencyId;
	}

	/** full constructor */
	public AdminUser(String userName, String email, String password,
			String ecSalt, Integer addTime, Integer lastLogin, String lastIp,
			String actionList, String navList, String langType, Short agencyId,
			Short suppliersId, String todolist, Short roleId) {
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.ecSalt = ecSalt;
		this.addTime = addTime;
		this.lastLogin = lastLogin;
		this.lastIp = lastIp;
		this.actionList = actionList;
		this.navList = navList;
		this.langType = langType;
		this.agencyId = agencyId;
		this.suppliersId = suppliersId;
		this.todolist = todolist;
		this.roleId = roleId;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Short getUserId() {
		return this.userId;
	}

	public void setUserId(Short userId) {
		this.userId = userId;
	}

	@Column(name = "user_name", nullable = false, length = 60)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "email", nullable = false, length = 60)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "ec_salt", length = 10)
	public String getEcSalt() {
		return this.ecSalt;
	}

	public void setEcSalt(String ecSalt) {
		this.ecSalt = ecSalt;
	}

	@Column(name = "add_time", nullable = false)
	public Integer getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}

	@Column(name = "last_login", nullable = false)
	public Integer getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Integer lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "last_ip", nullable = false, length = 15)
	public String getLastIp() {
		return this.lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	@Column(name = "action_list", nullable = false, length = 65535)
	public String getActionList() {
		return this.actionList;
	}

	public void setActionList(String actionList) {
		this.actionList = actionList;
	}

	@Column(name = "nav_list", nullable = false, length = 65535)
	public String getNavList() {
		return this.navList;
	}

	public void setNavList(String navList) {
		this.navList = navList;
	}

	@Column(name = "lang_type", nullable = false, length = 50)
	public String getLangType() {
		return this.langType;
	}

	public void setLangType(String langType) {
		this.langType = langType;
	}

	@Column(name = "agency_id", nullable = false)
	public Short getAgencyId() {
		return this.agencyId;
	}

	public void setAgencyId(Short agencyId) {
		this.agencyId = agencyId;
	}

	@Column(name = "suppliers_id")
	public Short getSuppliersId() {
		return this.suppliersId;
	}

	public void setSuppliersId(Short suppliersId) {
		this.suppliersId = suppliersId;
	}

	@Column(name = "todolist")
	public String getTodolist() {
		return this.todolist;
	}

	public void setTodolist(String todolist) {
		this.todolist = todolist;
	}

	@Column(name = "role_id")
	public Short getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

}