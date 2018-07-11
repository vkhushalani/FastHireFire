package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.MapCountryFieldFieldGroup;

public interface MapCountryFieldFieldGroupService {
	public List<MapCountryFieldFieldGroup> findAll();
	public MapCountryFieldFieldGroup create(MapCountryFieldFieldGroup item);
	public MapCountryFieldFieldGroup findById(Integer countryId , String fieldGroupId, String fieldId);
	public List<MapCountryFieldFieldGroup> findByCountry(Integer countryId);
	public List<MapCountryFieldFieldGroup> findByCountryFieldGroup(Integer countryId,String fieldGroupId);
	public void deleteByObject(MapCountryFieldFieldGroup item);
}
