package it.ciavotta.Launcher.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.hibernate.annotations.NaturalId;


/*
 * This class represent the node, each node is a computing unity in a virtual machine
 * */
@Entity(name = "Node")
public class Node {

	
	
	//@Column(nullable = false)
	private String nodeId;
	
	@Id
//	@GeneratedValue
	private String id;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@NaturalId
//	@Column(nullable = false)
	private String nodeIP;
	@NaturalId
//	@Column(nullable = false)
	private String port;
	
	private String operatingSystem;
	
	private String architecture;
	
	private String osVersion;

	
	@PrePersist
	private void createId(){
		this.id = this.nodeIP+this.port;
		
	}
	
	
	@Enumerated(EnumType.STRING)
	private NodeState state;

	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}

	public NodeState getState() {
		return state;
	}

	public void setState(NodeState state) {
		this.state = state;
	}

	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}


	/**
	 * @return the nodeIP
	 */
	public String getNodeIP() {
		return nodeIP;
	}

	/**
	 * @param nodeIP the nodeIP to set
	 */
	public void setNodeIP(String nodeIP) {
		this.nodeIP = nodeIP;
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
	 * @return the operatingSystem
	 */
	public String getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	/**
	 * @return the architecture
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * @param architecture the architecture to set
	 */
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	/**
	 * @return the osVersion
	 */
	public String getOsVersion() {
		return osVersion;
	}

	/**
	 * @param osVersion the osVersion to set
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
	
}
