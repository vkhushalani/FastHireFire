package com.amrest.fastHire.controller;

import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrest.fastHire.model.FieldGroup;
import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;
import com.amrest.fastHire.model.MapTemplateFieldFieldGroup;
import com.amrest.fastHire.model.Template;
import com.amrest.fastHire.service.FieldGroupService;
import com.amrest.fastHire.service.MapCountryBusinessUnitTemplateService;
import com.amrest.fastHire.service.MapTemplateFieldFieldGroupService;
import com.google.gson.Gson;



@RestController
@RequestMapping("/PreHireManager")
public class PreHireManagerController {
	private static String successMessage = "SUCCESS";
	Logger logger = LoggerFactory.getLogger(PreHireManagerController.class);
	
	@Autowired
	MapCountryBusinessUnitTemplateService mapCountryBusinessUnitTemplateService;
	
	@Autowired
	MapTemplateFieldFieldGroupService mapTemplateFieldFieldGroupService;
	
	@Autowired
	FieldGroupService fieldGroupService;
	
	@GetMapping(value = "/FormTemplate")
	public ResponseEntity <?> getFormTemplateFields(
			@RequestParam(value = "country", required = true) Integer countryId,
			@RequestParam(value = "businessUnit", required = true) Integer businessUnitId
			){
		
		Date today = new Date();
		Template template = null;
		
		JSONArray returnArray =  new JSONArray();
		
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
//			List<MapTemplateFieldFieldGroup> templateFields = mapTemplateFieldFieldGroupService.findByTemplate(template.getId());
			List<String> templateFieldGroups = mapTemplateFieldFieldGroupService.findDistinctFieldGroup(template.getId());
			if(templateFieldGroups.size() !=0)
			{	logger.debug("templateFieldGroups"+templateFieldGroups);
				
				for(String tFieldGroup :templateFieldGroups)
				{
					logger.debug("fieldGrouID"+tFieldGroup);
					JSONObject fieldObject = new JSONObject();
					Gson gson = new Gson();
					logger.debug(""+fieldGroupService.findById(tFieldGroup));
					FieldGroup fGroup = fieldGroupService.findById(tFieldGroup);
					if(fGroup !=null){
				    String jsonString = gson.toJson(fGroup);
					fieldObject.put("fieldGroup",new JSONObject(jsonString));
					fieldObject.put("fieldsCol1", mapTemplateFieldFieldGroupService.findByTemplateFieldGroupCol(template.getId(), tFieldGroup,1));
					fieldObject.put("fieldsCol2", mapTemplateFieldFieldGroupService.findByTemplateFieldGroupCol(template.getId(), tFieldGroup ,2));
					returnArray.put(fieldObject);
					}
				}
					
			}
		}
				
		return ResponseEntity.ok().body(returnArray.toString());
	
	}
	
}
