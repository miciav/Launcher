package it.ciavotta.Node.domain;

import org.springframework.stereotype.Component;

@Component
public class ServerStatus {

	private String status;

	private String message;
	
	private String ConnectionId;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getConnectionId() {
		return ConnectionId;
	}

	public void setConnectionId(String connectionId) {
		ConnectionId = connectionId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}