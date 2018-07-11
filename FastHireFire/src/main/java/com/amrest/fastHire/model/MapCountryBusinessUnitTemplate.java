package com.amrest.fastHire.model;

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
@Table(name = "\"com.amrest.ph.db::Table.MAP_BUSINESS_UNIT_TEMPLATE\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapCountryBusinessUnitTemplate.findAll", query = "SELECT map FROM MapCountryBusinessUnitTemplate map"),
		@NamedQuery(name = "MapCountryBusinessUnitTemplate.findByCountry", query = "SELECT map FROM MapCountryBusinessUnitTemplate map WHERE map.countryId = :countryId"),
		@NamedQuery(name = "MapCountryBusinessUnitTemplate.findByCountryBusinessUnit", query = "SELECT map FROM MapCountryBusinessUnitTemplate map WHERE map.countryId = :countryId AND map.businessUnitId = :businessUnitId"),
		@NamedQuery(name = "MapCountryBusinessUnitTemplate.findById", query = "SELECT map FROM MapCountryBusinessUnitTemplate map WHERE map.countryId = :countryId AND map.businessUnitId = :businessUnitId AND map.templateId = :templateId")
})
public class MapCountryBusinessUnitTemplate {
	
	@Id
	@Column(name = "\"COUNTRY.ID\"", columnDefinition = "INTEGER")
	private Integer countryId;
	
	@Id
	@Column(name = "\"BUS_UNIT.ID\"", columnDefinition = "INTEGER")
	private Integer businessUnitId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="\"BUS_UNIT.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private BusinessUnit businessUnit;
	
	@Id
	@Column(name = "\"TEMPLATE.ID\"", columnDefinition = "VARCHAR(10)")
	private String templateId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="\"TEMPLATE.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private Template template;


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


	public String getTemplateId() {
		return templateId;
	}


	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}


	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}


	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
	}


	public Template getTemplate() {
		return template;
	}


	public void setTemplate(Template template) {
		this.template = template;
	}

}
