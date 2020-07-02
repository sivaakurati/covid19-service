/**
 * 
 */
package com.wander.cloud.covid19.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wander.cloud.covid19.data.ColumnType;
import com.wander.cloud.covid19.data.TableType;

/**
 * @author SIVA KUMAR
 */
@Entity
@Table(name = TableType.USER)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Integer id;
	
	@Column(name = ColumnType.NAME)
	private String name;
	
	@Column(name = ColumnType.USERNAME)
	private String username;
	
	@Column(name = ColumnType.PASSWORD)
	private String password;
	
	@Column(name = ColumnType.ACCESS)
	private String access;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
}
