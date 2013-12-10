package it.ciavotta.Node.components;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NodeInformation {
	
	private String nodeIP; 

	@Value("${server.port}")
	private String port;
	
	private String state;
	
	@Value("${os.name}")
	private String os;
	
	@Value("${os.arch}")
	private String osArch;
	
	@Value("${os.version}")
	private String osVersion;
	
	private String nodeID;


	public NodeInformation(){
		
		try {
			InetAddress IP = InetAddress.getLocalHost();
			this.nodeIP = IP.getHostAddress();
			this.state = "OK";
		} catch (UnknownHostException e) {
			this.state = "ERROR";
		}
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	/**
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return nodeIP;
	}

	/**
	 * @param ipAddress the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.nodeIP = ipAddress;
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

	/**
	 * @return the operatingSystem
	 */
	public String getos() {
		return os;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setos(String operatingSystem) {
		os = operatingSystem;
	}

	/**
	 * @return the osArch
	 */
	public String getOsArch() {
		return osArch;
	}

	/**
	 * @param osArch the osArch to set
	 */
	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	/**
	 * @return the nodeID
	 */
	public String getNodeID() {
		return nodeID;
	}

	/**
	 * @param nodeID the nodeID to set
	 */
	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	
}
