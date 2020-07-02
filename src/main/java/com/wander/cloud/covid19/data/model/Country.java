/**
 * 
 */
package com.wander.cloud.covid19.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.wander.cloud.covid19.data.ColumnType;
import com.wander.cloud.covid19.data.TableType;

/**
 * @author SIVA KUMAR
 */
@Entity
@Table(name = TableType.COUNTRY)
public class Country extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = ColumnType.NAME)
	private String name;
	
	@Column(name = ColumnType.ISD)
	private String isd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsd() {
		return isd;
	}

	public void setIsd(String isd) {
		this.isd = isd;
	}
}
