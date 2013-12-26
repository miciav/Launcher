package it.ciavotta.Launcher.messages;

import it.ciavotta.Launcher.domain.Node;
import it.ciavotta.Launcher.domain.NodeState;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NodeInformation {
	
	private String id;
	
	private String nodeIP; 

	private String port;
	
	private String state;
	
	private String os;
	
	private String osArch;
	
	private String osVersion;
	
	private String nodeID;
	
	public static NodeInformation fromNode(Node node){
		NodeInformation nodeInfo = new NodeInformation();
		nodeInfo.setIpAddress(node.getNodeIP());
		nodeInfo.setOs(node.getOperatingSystem());
		nodeInfo.setOsArch(node.getArchitecture());
		nodeInfo.setPort(node.getPort());
		nodeInfo.setId(node.getId());
		nodeInfo.setOsVersion(node.getOsVersion());
		nodeInfo.setNodeID(node.getNodeId());
		if (node.getState().equals(NodeState.OK)) {
			nodeInfo.setState("OK");
		} else if (node.getState().equals(NodeState.ERROR)){
			nodeInfo.setState("ERROR");
		}else{
			System.out.println("conversion error");
		}	
		
		return nodeInfo;
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
	 * @return the os
	 */
	public String getOs() {
		return os;
	}

	/**
	 * @param os the os to set
	 */
	public void setOs(String os) {
		this.os = os;
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
