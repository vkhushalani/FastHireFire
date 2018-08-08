package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_MAP_TEMPLATE_FIELD_GROUPS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapTemplateFieldGroup.findAll", query = "SELECT map FROM MapTemplateFieldGroup map"),
		@NamedQuery(name = "MapTemplateFieldGroup.findByTemplate", query = "SELECT map FROM MapTemplateFieldGroup map WHERE map.templateId = :templateId"),
		@NamedQuery(name = "MapTemplateFieldGroup.findByTemplateFieldGroupField", query = "SELECT map FROM MapTemplateFieldGroup map WHERE map.templateId = :templateId AND map.fieldGroupFieldId = :fieldGroupFieldId")
})
public class MapTemplateFieldGroup {
	

	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;
	
	@Column(name = "\"HIRING_TEMPLATE.ID\"", columnDefinition = "VARCHAR(32)")
	private String templateId;
	
	@Column(name = "\"FIELD_GROUP_FIELD.ID\"", columnDefinition = "VARCHAR(32)")
	private String fieldGroupFieldId;
	
	@Column(name = "\"FIELD_GROUP_SEQ\"", columnDefinition = "INTEGER")
	private Integer fieldGroupSeq;
	
	@Column(name = "\"START_DATE\"",columnDefinition = "SECONDDATE")
    private Date startDate;
	
	@Column(name = "\"END_DATE\"",columnDefinition = "SECONDDATE")
    private Date endDate;

	
	public String getTemplateId() {
		return templateId;
	}


	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public Integer getFieldGroupSeq() {
		return fieldGroupSeq;
	}


	public void setFieldGroupSeq(Integer fieldGroupSeq) {
		this.fieldGroupSeq = fieldGroupSeq;
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


	public String getFieldGroupFieldId() {
		return fieldGroupFieldId;
	}


	public void setFieldGroupFieldId(String fieldGroupFieldId) {
		this.fieldGroupFieldId = fieldGroupFieldId;
	}

}