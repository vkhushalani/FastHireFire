package com.amrest.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_CODELIST\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "CodeList.findAll", query = "SELECT f FROM CodeList f"),
		@NamedQuery(name = "CodeList.findByFieldId", query = "SELECT f FROM CodeList f WHERE f.fieldId = :fieldId"),
		@NamedQuery(name = "CodeList.findByCountryField", query = "SELECT f FROM CodeList f WHERE f.fieldId = :fieldId AND f.countryId = :countryId"),
		@NamedQuery(name = "CodeList.findByCountryFieldLang", query = "SELECT f FROM CodeList f WHERE f.fieldId = :fieldId AND f.value = :value AND f.countryId = :countryId")
})
public class CodeList {


	@Id
	@Column(name = "\"FIELD.ID\"", columnDefinition = "VARCHAR(32)")
	private String fieldId;
	
	@Id
	@Column(name = "\"LANGUAGE\"", columnDefinition = "VARCHAR(5)")
	private String language;
	
	@Id
	@Column(name = "\"COUNTRY.ID\"", columnDefinition = "VARCHAR(32)")
	private String countryId;
	
	@Column(name = "\"VALUE\"", columnDefinition = "VARCHAR(5)")
	private String value;
	
	@Column(name = "\"DESCRIPTION\"", columnDefinition = "VARCHAR(152)")
	private String description;

	public String getFieldId() {
		return fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
