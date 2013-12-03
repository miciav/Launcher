package it.ciavotta.Node.domain;

public class NodeInformation {
	
	private String ipAddress; 

	private String port;
	
	private String state;
	
	public NodeInformation(String ipAddress, String port, String state) {
	        this.setIpAddress(ipAddress);
	        this.setPort(port);
	        this.setState(state);
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
