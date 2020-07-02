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
@Table(name = TableType.LOCATION)
public class Location extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = ColumnType.NAME)
	private String name;
	
	@Column(name = ColumnType.PIN)
	private Integer pin;
	
	@Column(name = ColumnType.CITY)
	private String city;
	
	@Column(name = ColumnType.STATE)
	private String state;
	
	@Column(name = ColumnType.COUNTRY)
	private String country;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
