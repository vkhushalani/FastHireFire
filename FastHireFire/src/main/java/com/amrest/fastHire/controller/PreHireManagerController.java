package com.amrest.fastHire.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;
import com.amrest.fastHire.model.MapTemplateFieldFieldGroup;
import com.amrest.fastHire.model.Template;
import com.amrest.fastHire.service.MapCountryBusinessUnitTemplateService;
import com.amrest.fastHire.service.MapTemplateFieldFieldGroupService;



@RestController
@RequestMapping("/PreHireManager")
public class PreHireManagerController {
	private static String successMessage = "SUCCESS";
	Logger logger = LoggerFactory.getLogger(PreHireManagerController.class);
	
	@Autowired
	MapCountryBusinessUnitTemplateService mapCountryBusinessUnitTemplateService;
	
	@Autowired
	MapTemplateFieldFieldGroupService mapTemplateFieldFieldGroupService;
	
	@GetMapping(value = "/FormTemplate")
	public ResponseEntity <List<MapTemplateFieldFieldGroup>> getFormTemplateFieldFieldGroup(
			@RequestParam(value = "country", required = true) Integer countryId,
			@RequestParam(value = "businessUnit", required = true) Integer businessUnitId
			){
		
		Date today = new Date();
		Template template = null;
		
		List<MapTemplateFieldFieldGroup> returnMap= null;
		
		List<MapCountryBusinessUnitTemplate> mapCountryUnitTemplateList = mapCountryBusinessUnitTemplateService.findByCountryBusinessUnit(countryId, businessUnitId);
		for(MapCountryBusinessUnitTemplate mapCountryUnitTemplate : mapCountryUnitTemplateList)
		{
			 template = mapCountryUnitTemplate.getTemplate();
			if(template.getStatus() && today.after(template.getEffectiveDate()))
			 {
				break;
			 }
		}
		if(template !=null)
		{
			 returnMap = mapTemplateFieldFieldGroupService.findByTemplate(template.getId());
		}
				
		return ResponseEntity.ok().body(returnMap);
	
	}
}
