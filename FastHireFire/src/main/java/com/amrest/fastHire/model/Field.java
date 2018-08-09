package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_FIELDS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "Field.findAll", query = "SELECT f FROM Field f")
		
})
public class Field {
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(32)")
    private String name;
	
	@Column(name = "\"TECHNICAL_FIELD_NAME\"",columnDefinition = "VARCHAR(32)")
    private String technicalName;
	
	@Column(name = "\"FIELD_TYPE\"",columnDefinition = "VARCHAR(16)")
    private String fieldType;
	
	@Column(name = "\"LENGTH\"",columnDefinition = "INTEGER")
    private Integer length;
	
	@Column(name = "\"GLOBAL_HIRE\"",columnDefinition = "VARCHAR(5)")
    private String globalHire;
	
	@Column(name = "\"DEFAULT_VALUE\"",columnDefinition = "VARCHAR(32)")
    private String defaultValue;
	
	@Column(name = "\"DATA_TYPE\"",columnDefinition = "VARCHAR(32)")
    private String dataType;
	
	@Column(name = "\"CREATED_ON\"",columnDefinition = "SECONDDATE")
    private Date createdOn;
	
	@Column(name = "\"START_DATE\"",columnDefinition = "SECONDDATE")
    private Date startDate;
	
	@Column(name = "\"END_DATE\"",columnDefinition = "SECONDDATE")
    private Date endDate;
	
	@Column(name = "\"DESCRIPTION\"",columnDefinition = "VARCHAR(152)")
    private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnicalName() {
		return technicalName;
	}

	public void setTechnicalName(String technicalName) {
		this.technicalName = technicalName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getGlobalHire() {
		return globalHire;
	}

	public void setGlobalHire(String globalHire) {
		this.globalHire = globalHire;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
