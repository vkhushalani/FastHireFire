package com.amrest.fastHire.service;

import java.util.List;

import com.amrest.fastHire.model.CodeList;

public interface CodeListService {
	public List<CodeList> findAll();
	public CodeList update(CodeList item);
	public CodeList create(CodeList item);
	public List<CodeList> findByFieldId(String fieldId);
	public List<CodeList> findByCountryField(String fieldId,String countryId);
	public CodeList findByCountryFieldLang(String fieldId,String countryId,String language);
	public void deleteByObject(CodeList item);
}
