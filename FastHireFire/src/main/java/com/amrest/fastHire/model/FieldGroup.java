package com.amrest.fastHire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FHD_FIELD_GROUPS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "FieldGroup.findAll", query = "SELECT f FROM FieldGroup f")
		
})
public class FieldGroup {
	
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(32)")
    private String name;
	
	@Column(name = "\"CREATED_ON\"",columnDefinition = "SECONDDATE")
    private Date createdOn;
	
	@Column(name = "\"START_DATE\"",columnDefinition = "SECONDDATE")
    private Date startDate;
	
	@Column(name = "\"END_DATE\"",columnDefinition = "SECONDDATE")
    private Date endDate;
	
	@Transient 
	private Integer fieldGroupSeq; 

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

	public Integer getFieldGroupSeq() {
		return fieldGroupSeq;
	}

	public void setFieldGroupSeq(Integer fieldGroupSeq) {
		this.fieldGroupSeq = fieldGroupSeq;
	}

}
