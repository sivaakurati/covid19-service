/**
 * 
 */
package com.wander.cloud.covid19.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.wander.cloud.covid19.data.ColumnType;

/**
 * @author SIVA KUMAR
 */
@MappedSuperclass
public class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ColumnType.ID)
	private Integer id;
	
	@Column(name = ColumnType.STATUS)
	private Boolean status;
	
	@Column(name = ColumnType.CREATED_BY)
	private String createdBy;
	
	@Column(name = ColumnType.CREATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name = ColumnType.UPDATED_BY)
	private String updatedBy;
	
	@Column(name = ColumnType.UPDATED_ON)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
