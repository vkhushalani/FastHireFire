package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapTemplateFieldGroup;

public interface MapTemplateFieldGroupService {
	public List<MapTemplateFieldGroup> findAll();
	public MapTemplateFieldGroup create(MapTemplateFieldGroup item);
	public MapTemplateFieldGroup findById(String id);
	public List<MapTemplateFieldGroup> findByTemplate(String templateId);
	public List<MapTemplateFieldGroup> findByTemplateFieldGroupField(String templateId,String fieldGroupFieldId);
	public void deleteByObject(MapTemplateFieldGroup item);
}
