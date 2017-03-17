package com.giventime.dealgator.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: UserRole
 *
 */
@Entity
@Table(name="user_roles")
public class UserRole implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public UserRole() {
		super();
	}
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="roleid")
	private String roleid;
	
	@Column(name="rolegroup")
	private String roleGroup;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the roleGroup
	 */
	public String getRoleGroup() {
		return roleGroup;
	}

	/**
	 * @param roleGroup the roleGroup to set
	 */
	public void setRoleGroup(String roleGroup) {
		this.roleGroup = roleGroup;
	}
	
}
