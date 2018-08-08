package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapTemplateFieldProperties;

public interface MapTemplateFieldPropertiesService {
	public List<MapTemplateFieldProperties> findAll();
	public MapTemplateFieldProperties create(MapTemplateFieldProperties item);
	public MapTemplateFieldProperties findById(String templateFieldGroupId, String fieldId);
	public List<MapTemplateFieldProperties> findByTemplateFieldGroup(String templateFieldGroupId);
	public List<MapTemplateFieldProperties> findByTemplateFieldGroupFieldManager(String templateFieldGroupId,String fieldId,Boolean isVisibleManager);
	public void deleteByObject(MapTemplateFieldProperties item);

}
