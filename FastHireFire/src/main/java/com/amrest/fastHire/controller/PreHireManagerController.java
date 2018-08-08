package com.amrest.fastHire.controller;

import java.io.IOException;
import java.net.URISyntaxException;
//import java.util.Date;
//import java.util.List;

import javax.naming.NamingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
//import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amrest.fastHire.SF.DestinationClient;
//import com.amrest.fastHire.model.FieldGroup;
//import com.amrest.fastHire.model.MapCountryBusinessUnitTemplate;
//import com.amrest.fastHire.model.Template;
//import com.amrest.fastHire.service.FieldGroupService;
//import com.amrest.fastHire.service.MapCountryBusinessUnitTemplateService;
//import com.amrest.fastHire.service.MapTemplateFieldFieldGroupService;
//import com.google.gson.Gson;



@RestController
@RequestMapping("/PreHireManager")
public class PreHireManagerController {
	private static String successMessage = "SUCCESS";
	Logger logger = LoggerFactory.getLogger(PreHireManagerController.class);
	
//	@Autowired
//	MapCountryBusinessUnitTemplateService mapCountryBusinessUnitTemplateService;
//	
//	@Autowired
//	MapTemplateFieldFieldGroupService mapTemplateFieldFieldGroupService;
//	
//	@Autowired
//	FieldGroupService fieldGroupService;
	
	@GetMapping(value = "/FormTemplate")
	public ResponseEntity <?> getFormTemplateFields(
			@RequestParam(value = "country", required = true) Integer countryId,
			@RequestParam(value = "businessUnit", required = true) Integer businessUnitId
			){
		
//		Date today = new Date();
//		Template template = null;
//		
		JSONArray returnArray =  new JSONArray();
//		
//		List<MapCountryBusinessUnitTemplate> mapCountryUnitTemplateList = mapCountryBusinessUnitTemplateService.findByCountryBusinessUnit(countryId, businessUnitId);
//		for(MapCountryBusinessUnitTemplate mapCountryUnitTemplate : mapCountryUnitTemplateList)
//		{
//			 template = mapCountryUnitTemplate.getTemplate();
//			if(template.getStatus() && today.after(template.getStartDate()))
//			 {
//				break;
//			 }
//		}
//		if(template !=null)
//		{
////			List<MapTemplateFieldFieldGroup> templateFields = mapTemplateFieldFieldGroupService.findByTemplate(template.getId());
//			List<Object[]> templateFieldGroups = mapTemplateFieldFieldGroupService.findDistinctFieldGroup(template.getId());
//			if(templateFieldGroups.size() !=0)
//			{	logger.debug("templateFieldGroups"+templateFieldGroups);
//				
//				for(Object[] tFieldGroup :templateFieldGroups)
//				{
//					logger.debug("fieldGrouID"+tFieldGroup[0]);
//					JSONObject fieldObject = new JSONObject();
//					Gson gson = new Gson();
//					logger.debug(""+tFieldGroup[1]);
//					FieldGroup fGroup = fieldGroupService.findById(tFieldGroup[0].toString());
//					fGroup.setSequence((Integer)tFieldGroup[1]);
//					if(fGroup !=null){
//				    String jsonString = gson.toJson(fGroup);
//					fieldObject.put("fieldGroup",new JSONObject(jsonString));
//					fieldObject.put("fields",mapTemplateFieldFieldGroupService.findByTemplateFieldGroupManager(template.getId(), tFieldGroup[0].toString(),true));
////					fieldObject.put("fieldsCol1", mapTemplateFieldFieldGroupService.findByTemplateFieldGroupCol(template.getId(), tFieldGroup[0].toString(),1));
////					fieldObject.put("fieldsCol2", mapTemplateFieldFieldGroupService.findByTemplateFieldGroupCol(template.getId(), tFieldGroup[0].toString() ,2));
//					returnArray.put(fieldObject);
//					
//					}
//				}
//					
//			}
//		}
				
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
