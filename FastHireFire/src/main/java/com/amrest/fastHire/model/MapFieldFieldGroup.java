package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_MAP_FIELD_GROUP_FIELDS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapFieldFieldGroup.findAll", query = "SELECT map FROM MapFieldFieldGroup map"),
		@NamedQuery(name = "MapFieldFieldGroup.findByFieldGroupId", query = "SELECT map FROM MapFieldFieldGroup map WHERE map.fieldGroupId = :fieldGroupId"),
		@NamedQuery(name = "MapFieldFieldGroup.findByFieldGroupFieldId", query = "SELECT map FROM MapFieldFieldGroup map WHERE map.fieldGroupId = :fieldGroupId AND map.fieldId = :fieldId")
})
public class MapFieldFieldGroup {
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;
	
	@Column(name = "\"FIELD_GROUP.ID\"", columnDefinition = "VARCHAR(32)")
	private String fieldGroupId;
	
	@Column(name = "\"FIELD.ID\"", columnDefinition = "VARCHAR(32)")
	private String fieldId;
	
	@Column(name = "\"START_DATE\"",columnDefinition = "SECONDDATE")
    private Date startDate;
	
	@Column(name = "\"END_DATE\"",columnDefinition = "SECONDDATE")
    private Date endDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

}
