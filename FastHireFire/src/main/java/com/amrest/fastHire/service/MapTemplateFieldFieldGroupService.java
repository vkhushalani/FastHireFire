package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapTemplateFieldFieldGroup;

public interface MapTemplateFieldFieldGroupService {
	public List<MapTemplateFieldFieldGroup> findAll();
	public MapTemplateFieldFieldGroup create(MapTemplateFieldFieldGroup item);
	public MapTemplateFieldFieldGroup findById(String templateId , String fieldGroupId, String fieldId);
	public List<MapTemplateFieldFieldGroup>  findByTemplate(String templateId);
	public List<MapTemplateFieldFieldGroup>  findByTemplateFieldGroup(String templateId,String fieldGroupId);
	public List<MapTemplateFieldFieldGroup>  findByTemplateFieldGroupManager(String templateId,String fieldGroupId,Boolean isVisibleManager);
	public List<Object[]> findDistinctFieldGroup (String templateId);
	public void deleteByObject(MapTemplateFieldFieldGroup item);
	
}
