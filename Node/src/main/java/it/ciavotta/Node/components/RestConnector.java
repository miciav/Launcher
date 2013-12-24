package it.ciavotta.Node.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestConnector {

	@Value("${LauncherServer.address}")
	private String address;
	
	@Value("${LauncherServer.port}")
	private String port;
	
	@Value("${LauncherServer.name}")
	private String serviceName;
	
	private String restUrl ;
	
	@Value("${LauncherServer.login}")
	private String login;
	
	@Value("${LauncherServer.password}")
	private String password;
	
	private String restAPIName;
	
	private RestTemplate rest = new RestTemplate();
	
	public RestConnector(){
		
	}
	
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRestUrl() {
		return restUrl;
	}

	public void setRestUrl(String restUrl) {
		this.restUrl = restUrl;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public <T> T postForObject(Object request,
            Class<T> responseType,
            Object... uriVariables)
            		throws RestClientException{

		if(this.restUrl == null){
			
			this.restUrl= "http://"+address+":"+port+"/"+serviceName+"/";
		}
		
		rest.getMessageConverters().add(new StringHttpMessageConverter());
		return rest.postForObject(this.restUrl+restAPIName, request, responseType);
	}
	
	
	
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the port
	 */
	public String getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(String port) {
		this.port = port;
	}

	/**
	 * @return the serverName
	 */
	public String getServerName() {
		return serviceName;
	}

	/**
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serviceName = serverName;
	}

	/**
	 * @return the restAPIName
	 */
	public String getRestAPIName() {
		return restAPIName;
	}

	/**
	 * @param restAPIName the restAPIName to set
	 */
	public void setRestAPIName(String restAPIName) {
		this.restAPIName = restAPIName;
	}

	/**
	 * @return the rest
	 */
	public RestTemplate getRest() {
		return rest;
	}

	/**
	 * @param rest the rest to set
	 */
	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}
	
	
}
