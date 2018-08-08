package com.amrest.fastHire.SF;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sap.core.connectivity.api.authentication.AuthenticationHeaderProvider;
import com.sap.core.connectivity.api.authentication.AuthenticationHeader;
import com.sap.core.connectivity.api.configuration.ConnectivityConfiguration;
import com.sap.core.connectivity.api.configuration.DestinationConfiguration;

public class DestinationClient {
	Logger logger = LoggerFactory.getLogger(DestinationClient.class);
	private String destName;
	private ConnectivityConfiguration configuration;
	private DestinationConfiguration destConfiguration;
	private List<AuthenticationHeader> headers;
	private AuthenticationHeaderProvider authHeaderProvider;
	
	public String getDestName() {
		return destName;
	}
	public void setDestName(String destName) {
		this.destName = destName;
	}
	public void setHeaderProvider() throws NamingException{
		
		Context ctx = new InitialContext();
		this.authHeaderProvider = (AuthenticationHeaderProvider) ctx.lookup("java:comp/env/myAuthHeaderProvider");
	}
	public void setConfiguration() throws NamingException{
		Context ctx = new InitialContext();
		this.configuration = (ConnectivityConfiguration) ctx.lookup("java:comp/env/connectivityConfiguration");
	}
	public void setDestConfiguration(){
		this.destConfiguration = configuration.getConfiguration(this.destName);

	}
	public Map<String, String> getAllDestProperties(){
		return this.destConfiguration.getAllProperties();
	}
	
	public String getDestProperty(String propName){
		return this.destConfiguration.getProperty(propName);
	}
	
	public DestinationConfiguration getDestConfiguration() {
		return destConfiguration;
	}
	public ConnectivityConfiguration getConfiguration() {
		return configuration;
	}
	
	@SuppressWarnings({ "deprecation", "resource" })
	public HttpResponse callDestinationGET(String path) throws ClientProtocolException, IOException, URISyntaxException{
		
		
		
		
		String url = this.getDestProperty("URL");
		URIBuilder builder = new URIBuilder(url+"/User");
		builder.setParameter("$format", "json").setParameter("$top", "10")
		.setParameter("$filter", "substringof(toupper('Anuj Kumar'),toupper(firstName)) or substringof(toupper('Anuj Kumar'),toupper(lastName))")
		.setParameter("$select", "userId,username,defaultFullName");
		logger.debug("URL: "+ url);
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet request = new HttpGet(builder.build());
		for (AuthenticationHeader header : this.headers){
			logger.debug("Header: "+ header.getName() + header.getValue());
			request.addHeader(header.getName(), header.getValue());
		}
		HttpResponse response = httpClient.execute(request);
		return response;
	}
	public void setHeaders(String type){
		switch(type){
		case "OAuth2SAMLBearerAssertion"	: 
			this.headers = authHeaderProvider.getOAuth2SAMLBearerAssertionHeaders(this.destConfiguration);
			break;
		
		}
	}
}
