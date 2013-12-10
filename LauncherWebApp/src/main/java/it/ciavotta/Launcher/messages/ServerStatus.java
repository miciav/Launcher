package it.ciavotta.Launcher.messages;

import org.springframework.stereotype.Component;

@Component
public class ServerStatus {

	private String status = "running";
	
	private String message;
	
	private String ConnectionId;

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

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the connectionId
	 */
	public String getConnectionId() {
		return ConnectionId;
	}

	/**
	 * @param connectionId the connectionId to set
	 */
	public void setConnectionId(String connectionId) {
		ConnectionId = connectionId;
	}
}
