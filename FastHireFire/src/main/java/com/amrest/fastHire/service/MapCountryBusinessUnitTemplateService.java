package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;

public interface MapCountryBusinessUnitTemplateService {
	public List<MapCountryBusinessUnitTemplate> findAll();
	public MapCountryBusinessUnitTemplate create(MapCountryBusinessUnitTemplate item);
	public MapCountryBusinessUnitTemplate findById(Integer countryId , Integer businessUnitId, String templateId);
	public List<MapCountryBusinessUnitTemplate> findByCountry(Integer countryId);
	public List<MapCountryBusinessUnitTemplate> findByCountryBusinessUnit(Integer countryId, Integer businessUnitId);
	public void deleteByObject(MapCountryBusinessUnitTemplate item);
}
