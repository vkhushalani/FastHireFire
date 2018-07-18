package com.amrest.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FIELDS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "Field.findAll", query = "SELECT f FROM Field f")
		
})
public class Field {
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(10)")
	private String id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(64)")
    private String name;
	
	@Column(name = "\"TECHNICAL_FIELD_NAME\"",columnDefinition = "VARCHAR(32)")
    private String technicalName;
	
	@Column(name = "\"FIELD_TYPE\"",columnDefinition = "VARCHAR(15)")
    private String fieldType;
	
	@Column(name = "\"LENGTH\"",columnDefinition = "INTEGER")
    private Integer length;
	
	@Column(name = "\"GLOBAL_HIRE\"",columnDefinition = "VARCHAR(5)")
    private String globalHire;
	
	@Column(name = "\"DEFAULT_VALUE\"",columnDefinition = "VARCHAR(32)")
    private String defaultValue;
	
	@Column(name = "\"DATA_TYPE\"",columnDefinition = "VARCHAR(32)")
    private String dataType;

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
	
	
}
