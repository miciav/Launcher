package it.ciavotta.Node.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.DefaultPropertiesPersister;

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
	
	@Value("${node.id}")
	private String nodeID;
	
	
	private String id; // this is database stuff related

	
	
	public NodeInformation(){
		
		try {
			InetAddress IP = InetAddress.getLocalHost();
			this.nodeIP = IP.getHostAddress();
			this.state = "OK";
			


		} catch (UnknownHostException e) {
			this.state = "ERROR";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void postConst(){
		this.id = this.nodeIP+this.port;
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
	 * @throws IOException 
	 */
	public void setNodeID(String nodeID) throws IOException {
		if (this.nodeID != nodeID){
		this.nodeID = nodeID;
		Properties props = new Properties();
		
		FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
	    props.load(fileInputStream);
	    fileInputStream.close();
	    props.setProperty("node.id", this.nodeID);

	    FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/application.properties");
	    props.store(fileOutputStream, "");
	    fileOutputStream.close();
		}
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	
}
