package it.ciavotta.Launcher.component;

import org.springframework.stereotype.Component;

@Component
public class ServerStatus {

	private String status = "running";

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
