package com.amrest.fastHire.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrest.fastHire.SF.DestinationClient;
import com.amrest.fastHire.service.MapCountryBusinessUnitService;
import com.amrest.fastHire.service.MapCountryBusinessUnitTemplateService;
import com.amrest.fastHire.service.MapTemplateFieldGroupService;
import com.amrest.fastHire.service.MapTemplateFieldPropertiesService;
import com.google.gson.Gson;
import com.amrest.fastHire.model.MapCountryBusinessUnit;
import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;
import com.amrest.fastHire.model.MapTemplateFieldGroup;
import com.amrest.fastHire.model.Template;



@RestController
@RequestMapping("/PreHireManager")
public class PreHireManagerController {
	private static String successMessage = "SUCCESS";
	Logger logger = LoggerFactory.getLogger(PreHireManagerController.class);
	
	@Autowired
	MapCountryBusinessUnitService mapCountryBusinessUnitService;
	
	@Autowired
	MapCountryBusinessUnitTemplateService mapCountryBusinessUnitTemplateService;
	
	@Autowired
	MapTemplateFieldGroupService mapTemplateFieldGroupService;
	@Autowired
	MapTemplateFieldPropertiesService mapTemplateFieldPropertiesService;
	
	@GetMapping(value = "/FormTemplate")
	public ResponseEntity <?> getFormTemplateFields(
			@RequestParam(value = "country", required = true) String countryId,
			@RequestParam(value = "businessUnit", required = true) String businessUnitId
			){
		
		Date today = new Date();
		Template template = null;
		JSONArray returnArray =  new JSONArray();
//		
		MapCountryBusinessUnit mapCountryBusinessUnit = mapCountryBusinessUnitService.findByCountryBusinessUnit(countryId, businessUnitId);
		List<MapCountryBusinessUnitTemplate> mapTemplateList = mapCountryBusinessUnitTemplateService.findByCountryBusinessUnitId(mapCountryBusinessUnit.getId());
		for(MapCountryBusinessUnitTemplate mapTemplate : mapTemplateList)
		{
			template = mapTemplate.getTemplate();
			if(today.before(mapTemplate.getEndDate()) && today.after(mapTemplate.getStartDate()))
			 {
				break;
			 }
		}
		if(template !=null)
		{
			List<MapTemplateFieldGroup> templateFieldGroups = mapTemplateFieldGroupService.findByTemplate(template.getId());
			if(templateFieldGroups.size() !=0)
			{	
				logger.debug("templateFieldGroups"+templateFieldGroups);
				
				for( MapTemplateFieldGroup tFieldGroup :templateFieldGroups)
				{
					if(tFieldGroup.getIsVisibleManager()){
					JSONObject fieldObject = new JSONObject();
					Gson gson = new Gson();
					
					tFieldGroup.getFieldGroup().setFieldGroupSeq(tFieldGroup.getFieldGroupSeq());
					if(tFieldGroup.getFieldGroup() !=null){
				    String jsonString = gson.toJson(tFieldGroup.getFieldGroup());
					fieldObject.put("fieldGroup",new JSONObject(jsonString));
					fieldObject.put("fields",mapTemplateFieldPropertiesService.findByTemplateFieldGroupManager(tFieldGroup.getId(),true));
					returnArray.put(fieldObject);
					}
					}
				}
					
			}
		}
				
		return ResponseEntity.ok().body(returnArray.toString());
	
	}
	@GetMapping(value = "/SF/PickList/{name}")
	public ResponseEntity <?> getSFPicklist( @PathVariable("name") String picklistName) throws NamingException, ClientProtocolException, IOException, URISyntaxException{
		// calling the oauth destination of SF
		
		DestinationClient destClient = new DestinationClient();
		destClient.setDestName("erwatSFOData");
		destClient.setHeaderProvider();
		destClient.setConfiguration();
		destClient.setDestConfiguration();
		destClient.setHeaders(destClient.getDestProperty("Authentication"));
		
		String path = "/User?$format=json&$top=10&$filter=substringof(toupper('Anuj Kumar'),toupper(firstName)) or substringof(toupper('Anuj Kumar'),toupper(lastName))&$select=userId,username,defaultFullName";
		HttpResponse response = destClient.callDestinationGET(path);
		logger.debug("response"+response);
		String responseJson = EntityUtils.toString(response.getEntity(), "UTF-8");
		return ResponseEntity.ok().body(responseJson);
	}
}
