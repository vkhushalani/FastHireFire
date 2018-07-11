package com.amrest.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.MAP_COUNTRY_FIELD_FIELDGROUP\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapCountryFieldFieldGroup.findAll", query = "SELECT map FROM MapCountryFieldFieldGroup map"),
		@NamedQuery(name = "MapCountryFieldFieldGroup.findByCountry", query = "SELECT map FROM MapCountryFieldFieldGroup map WHERE map.countryId = :countryId"),
		@NamedQuery(name = "MapCountryFieldFieldGroup.findByCountryFieldGroup", query = "SELECT map FROM MapCountryFieldFieldGroup map WHERE map.countryId = :countryId AND map.fieldGroupId = :fieldGroupId"),
		@NamedQuery(name = "MapCountryFieldFieldGroup.findById", query = "SELECT map FROM MapCountryFieldFieldGroup map WHERE map.countryId = :countryId AND map.fieldGroupId = :fieldGroupId AND map.fieldId = :fieldId")
})
public class MapCountryFieldFieldGroup {
	@Id
	@Column(name = "\"COUNTRY.ID\"", columnDefinition = "INTEGER")
	private Integer countryId;
	
	@ManyToOne
	@JoinColumn(name="\"COUNTRY.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private Country country;
	
	@Id
	@Column(name = "\"FIELD_GROUP.ID\"", columnDefinition = "VARCHAR(10)")
	private String fieldGroupId;
	
	@ManyToOne
	@JoinColumn(name="\"FIELD_GROUP.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private FieldGroup fieldGroup;
	
	@Id
	@Column(name = "\"FIELD.ID\"", columnDefinition = "VARCHAR(10)")
	private String fieldId;
	
	@ManyToOne
	@JoinColumn(name="\"FIELD.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private Field field;


	public Integer getCountryId() {
		return countryId;
	}


	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}


	public String getFieldGroupId() {
		return fieldGroupId;
	}


	public void setFieldGroupId(String fieldGroupId) {
		this.fieldGroupId = fieldGroupId;
	}


	public String getFieldId() {
		return fieldId;
	}


	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public FieldGroup getFieldGroup() {
		return fieldGroup;
	}


	public void setFieldGroup(FieldGroup fieldGroup) {
		this.fieldGroup = fieldGroup;
	}


	public Field getField() {
		return field;
	}


	public void setField(Field field) {
		this.field = field;
	}
}
