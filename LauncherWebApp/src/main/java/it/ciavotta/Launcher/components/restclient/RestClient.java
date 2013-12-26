package it.ciavotta.Launcher.components.restclient;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

@Component
public class RestClient
{
	private String hostAddress;
	
	private String port = "8080";
	
    private String applicationPath = "Node";
	
    public String getHostAddress() {
		return hostAddress;
	}

	public void setHostAddress(String hostAddress) {
		this.hostAddress = hostAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String apiPath = "api";
    private String loginPath = "login";
    private String logoutPath = "logout";
    private final String usernameInputFieldName = "username";
    private final String passwordInputFieldName = "password";
    
    @Value("${LauncherServer.login}")
    private String username;
    
    @Value("${LauncherServer.login}")
    private String password;
    
    private final StatefullRestTemplate template = new StatefullRestTemplate();

    /**
     * This method logs into a service by doing an standard http using the configuration in this class.
     * 
     * @param username
     *            the username to log into the application with
     * @param password
     *            the password to log into the application with
     * 
     * @return the url that the login redirects to
     */
    public String login(String username, String password)
    {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
        form.add(usernameInputFieldName, username);
        form.add(passwordInputFieldName, password);
        URI location = this.template.postForLocation(loginUrl(), form);
        return location.toString();
    }
    
    public String login(){
    	
    	return login(this.username, this.password);
    }

    /**
     * Logout by doing an http get on the logout url
     * 
     * @return result of the get as ResponseEntity
     */
    public ResponseEntity<String> logout()
    {
        return this.template.getForEntity(logoutUrl(), String.class);
    }

    public String applicationUrl(String relativePath)
    {
        return applicationUrl() + "/" + Preconditions.checkNotNull(relativePath);
    }

    public String apiUrl(String relativePath)
    {
        return applicationUrl(apiPath + "/" + Preconditions.checkNotNull(relativePath));
    }

    public StatefullRestTemplate template()
    {
        return template;
    }

    public String serverUrl()
    {
        return "http://" + hostAddress + ":" + port;
    }

    public String applicationUrl()
    {
        return serverUrl() + "/" + Strings.nullToEmpty(applicationPath);
    }

    public String loginUrl()
    {
        return applicationUrl(loginPath);
    }

    public String logoutUrl()
    {
        return applicationUrl(logoutPath);
    }

    public String apiUrl()
    {
        return applicationUrl(apiPath);
    }

    public void setLogoutPath(String logoutPath)
    {
        this.logoutPath = logoutPath;
    }

    public String getHost()
    {
        return hostAddress;
    }

    public void setHost(String host)
    {
        this.hostAddress = host;
    }

    public String getPort()
    {
        return port;
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public String getApplicationPath()
    {
        return applicationPath;
    }

    public void setApplicationPath(String contextPath)
    {
        this.applicationPath = contextPath;
    }

    public String getApiPath()
    {
        return apiPath;
    }

    public void setApiPath(String apiPath)
    {
        this.apiPath = apiPath;
    }

    public String getLoginPath()
    {
        return loginPath;
    }

    public void setLoginPath(String loginPath)
    {
        this.loginPath = loginPath;
    }

    public String getLogoutPath()
    {
        return logoutPath;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("RestClient [\n serverUrl()=");
        builder.append(serverUrl());
        builder.append(", \n applicationUrl()=");
        builder.append(applicationUrl());
        builder.append(", \n loginUrl()=");
        builder.append(loginUrl());
        builder.append(", \n logoutUrl()=");
        builder.append(logoutUrl());
        builder.append(", \n apiUrl()=");
        builder.append(apiUrl());
        builder.append("\n]");
        return builder.toString();
    }
}