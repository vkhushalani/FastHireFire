package com.amrest.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.amrest.ph.db::Table.FIELD_GROUPS\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "FieldGroup.findAll", query = "SELECT f FROM FieldGroup f")
		
})
public class FieldGroup {
	
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(10)")
	private String id;
	
	@Column(name = "\"NAME\"",columnDefinition = "VARCHAR(64)")
    private String name;

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

}
