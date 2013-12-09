package it.ciavotta.Node.controllers;

import it.ciavotta.Node.domain.NodeInformation;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.properties.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ConfigurationProperties(name = "server")
public class NodeController {
	
	@Autowired
	private ServerProperties properties;
	
	private InetAddress IP;
	private String ipAddress;
	
	private String port;
	private String state;
	
	public NodeController(){
		try {
			this.IP = InetAddress.getLocalHost();			
			setIpAddress(IP.getHostAddress());
    		this.setState("OK");
		} catch (UnknownHostException e) {
			this.setIpAddress("Unknown");
			this.setPort("Unknown");
			this.setPort("Unknown");
			this.setState("Error");
			e.printStackTrace();
		} 
		
		
		
	}

	@RequestMapping("/nodeInformation")
	public @ResponseBody NodeInformation nodeInformation(){
	        return new NodeInformation(this.ipAddress, this.port, this.state);
	    }

	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
}
