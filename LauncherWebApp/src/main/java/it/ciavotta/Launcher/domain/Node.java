package it.ciavotta.Launcher.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


/*
 * This class represent the node, each node is a computing unity in a virtual machine
 * */
@Entity(name = "Node")
public class Node {

	@Id
	@GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
	@Column(nullable = false)
	private String nodeId;
	
	private String hashConnection;
	
	private String nodeIP;
	
	private String port;
	
	private String operatingSystem;
	 
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
	 * @return the hashConnection
	 */
	public String getHashConnection() {
		return hashConnection;
	}

	/**
	 * @param hashConnection the hashConnection to set
	 */
	public void setHashConnection(String hashConnection) {
		this.hashConnection = hashConnection;
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
	
	
}
