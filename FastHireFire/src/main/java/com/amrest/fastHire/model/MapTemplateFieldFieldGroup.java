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
@Table(name = "\"com.amrest.ph.db::Table.MAP_FIELDS_TEMPLATE\"", schema = "AMREST_PREHIRE")
@NamedQueries({ 
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findAll", query = "SELECT map FROM MapTemplateFieldFieldGroup map"),
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findByTemplate", query = "SELECT map FROM MapTemplateFieldFieldGroup map WHERE map.templateId = :templateId"),
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findByTemplateFieldGroup", query = "SELECT map FROM MapTemplateFieldFieldGroup map WHERE map.templateId = :templateId AND map.fieldGroupId = :fieldGroupId"),
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findByTemplateFieldGroupCol", query = "SELECT map FROM MapTemplateFieldFieldGroup map WHERE map.templateId = :templateId AND map.fieldGroupId = :fieldGroupId AND map.fieldColumn = :fieldColumn"),
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findById", query = "SELECT map FROM MapTemplateFieldFieldGroup map WHERE map.templateId = :templateId AND map.fieldGroupId = :fieldGroupId AND map.fieldId = :fieldId"),
		@NamedQuery(name = "MapTemplateFieldFieldGroup.findDistinctFieldGroup", query = "SELECT DISTINCT map.fieldGroupId FROM MapTemplateFieldFieldGroup map WHERE map.templateId = :templateId")
})
public class MapTemplateFieldFieldGroup {
	@Id
	@Column(name = "\"TEMPLATE.ID\"", columnDefinition = "VARCHAR(10)")
	private String templateId;
	
	@ManyToOne
	@JoinColumn(name="\"TEMPLATE.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private Template template;
	
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
	
	@Column(name = "\"FIELD_GROUP_SEQ\"", columnDefinition = "INTEGER")
	private Integer fieldGroupSeq;
	
	@Column(name = "\"FIELD_ROW\"", columnDefinition = "INTEGER")
	private Integer fieldRow;
	
	
	@Column(name = "\"FIELD_COL\"", columnDefinition = "INTEGER")
	private Integer fieldColumn;
	
	@Column(name = "\"DEFAULT_VALUE\"", columnDefinition = "VARCHAR(32)")
	private String defaultValue;
	
	@Column(name = "\"IS_EDITABLE_MANAGER\"", columnDefinition = "BOOLEAN")
	private Boolean isEditableManager;
	
	@Column(name = "\"IS_EDITABLE_CANDIDATE\"", columnDefinition = "BOOLEAN")
	private Boolean isEditableCandidate;
	
	@Column(name = "\"IS_VISIBLE_MANAGER\"", columnDefinition = "VARCHAR(10)")
	private Boolean isVisibleManager;
	
	@Column(name = "\"IS_VISIBLE_CANDIDATE\"", columnDefinition = "BOOLEAN")
	private Boolean isVisibleCandidate;
	
	@Column(name = "\"IS_MANDATORY_MANAGER\"", columnDefinition = "BOOLEAN")
	private Boolean isMandatoryManager;
	
	@Column(name = "\"IS_MANDATORY_CANDIDATE\"", columnDefinition = "BOOLEAN")
	private Boolean isMandatoryCandidate;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
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

	public Integer getFieldGroupSeq() {
		return fieldGroupSeq;
	}

	public void setFieldGroupSeq(Integer fieldGroupSeq) {
		this.fieldGroupSeq = fieldGroupSeq;
	}

	public Integer getFieldRow() {
		return fieldRow;
	}

	public void setFieldRow(Integer fieldRow) {
		this.fieldRow = fieldRow;
	}

	public Integer getFieldColumn() {
		return fieldColumn;
	}

	public void setFieldColumn(Integer fieldColumn) {
		this.fieldColumn = fieldColumn;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public Boolean getIsEditableManager() {
		return isEditableManager;
	}

	public void setIsEditableManager(Boolean isEditableManager) {
		this.isEditableManager = isEditableManager;
	}

	public Boolean getIsEditableCandidate() {
		return isEditableCandidate;
	}

	public void setIsEditableCandidate(Boolean isEditableCandidate) {
		this.isEditableCandidate = isEditableCandidate;
	}

	public Boolean getIsVisibleManager() {
		return isVisibleManager;
	}

	public void setIsVisibleManager(Boolean isVisibleManager) {
		this.isVisibleManager = isVisibleManager;
	}

	public Boolean getIsVisibleCandidate() {
		return isVisibleCandidate;
	}

	public void setIsVisibleCandidate(Boolean isVisibleCandidate) {
		this.isVisibleCandidate = isVisibleCandidate;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
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

	public Boolean getIsMandatoryCandidate() {
		return isMandatoryCandidate;
	}

	public void setIsMandatoryCandidate(Boolean isMandatoryCandidate) {
		this.isMandatoryCandidate = isMandatoryCandidate;
	}

	public Boolean getIsMandatoryManager() {
		return isMandatoryManager;
	}

	public void setIsMandatoryManager(Boolean isMandatoryManager) {
		this.isMandatoryManager = isMandatoryManager;
	}
}
