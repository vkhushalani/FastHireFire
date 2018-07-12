package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapTemplateFieldFieldGroup;

public interface MapTemplateFieldFieldGroupService {
	public List<MapTemplateFieldFieldGroup> findAll();
	public MapTemplateFieldFieldGroup create(MapTemplateFieldFieldGroup item);
	public MapTemplateFieldFieldGroup findById(String templateId , String fieldGroupId, String fieldId);
	public List<MapTemplateFieldFieldGroup>  findByTemplate(String templateId);
	public List<MapTemplateFieldFieldGroup>  findByTemplateFieldGroup(String templateId,String fieldGroupId);
	public List<MapTemplateFieldFieldGroup>  findByTemplateFieldGroupCol(String templateId,String fieldGroupId,Integer colNo);
	public List<String> findDistinctFieldGroup (String templateId);
	public void deleteByObject(MapTemplateFieldFieldGroup item);
	
}
