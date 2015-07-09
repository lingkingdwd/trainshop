package com.trainshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "trainshop")
public class Role implements java.io.Serializable {

	// Fields

	private Short roleId;
	private String roleName;
	private String actionList;
	private String roleDescribe;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName, String actionList) {
		this.roleName = roleName;
		this.actionList = actionList;
	}

	/** full constructor */
	public Role(String roleName, String actionList, String roleDescribe) {
		this.roleName = roleName;
		this.actionList = actionList;
		this.roleDescribe = roleDescribe;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_id", unique = true, nullable = false)
	public Short getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Short roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_name", nullable = false, length = 60)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "action_list", nullable = false, length = 65535)
	public String getActionList() {
		return this.actionList;
	}

	public void setActionList(String actionList) {
		this.actionList = actionList;
	}

	@Column(name = "role_describe", length = 65535)
	public String getRoleDescribe() {
		return this.roleDescribe;
	}

	public void setRoleDescribe(String roleDescribe) {
		this.roleDescribe = roleDescribe;
	}

}