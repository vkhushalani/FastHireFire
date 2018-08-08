package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_MAP_COUNTRY_BUSINESS_UNITS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapCountryBusinessUnit.findAll", query = "SELECT map FROM MapCountryBusinessUnit map"),
		@NamedQuery(name = "MapCountryBusinessUnit.findByCountry", query = "SELECT map FROM MapCountryBusinessUnit map WHERE map.countryId = :countryId"),
		@NamedQuery(name = "MapCountryBusinessUnit.findByCountryBusinessUnit", query = "SELECT map FROM MapCountryBusinessUnit map WHERE map.countryId = :countryId AND map.businessUnitId = :businessUnitId")
})
public class MapCountryBusinessUnit {
	
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;
	
	@Column(name = "\"COUNTRY.ID\"", columnDefinition = "VARCHAR(32)")
	private Integer countryId;
	
	@Column(name = "\"BUSINESS_UNIT.ID\"", columnDefinition = "VARCHAR(32)")
	private Integer businessUnitId;
	
	@Column(name = "\"START_DATE\"",columnDefinition = "SECONDDATE")
    private Date startDate;
	
	@Column(name = "\"END_DATE\"",columnDefinition = "SECONDDATE")
    private Date endDate;
	
	

	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public Integer getBusinessUnitId() {
		return businessUnitId;
	}


	public void setBusinessUnitId(Integer businessUnitId) {
		this.businessUnitId = businessUnitId;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



}
