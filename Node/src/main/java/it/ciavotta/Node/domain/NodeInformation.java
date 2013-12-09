package it.ciavotta.Node.domain;

public class NodeInformation {
	
	private String nodeIP; 

	private String port;
	
	private String state;
	
	private String OperatingSystem = "MacOSX";
	
	public NodeInformation(String ipAddress, String port, String state) {
	        this.setIpAddress(ipAddress);
	        this.setPort(port);
	        this.setState(state);
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
	public String getOperatingSystem() {
		return OperatingSystem;
	}

	/**
	 * @param operatingSystem the operatingSystem to set
	 */
	public void setOperatingSystem(String operatingSystem) {
		OperatingSystem = operatingSystem;
	}
	
}
