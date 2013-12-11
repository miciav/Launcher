package it.ciavotta.Node.controllers;

import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.components.RestConnector;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class AdminController  {

	@Autowired
	private RestConnector conn;
	
	@Autowired
	private NodeInformation nodeInfo;
	
	private ServerStatus status = null;
	
	@RequestMapping(value="Admin/connect")
	public @ResponseBody ServerStatus connect(){

		
		try {
			conn.setRestAPIName("Node/connect");

			status = conn.postForObject( nodeInfo, ServerStatus.class);
			
			
			if (status.getMessage().equals("Connected") && status.getConnectionId() != null) {
				nodeInfo.setNodeID(status.getConnectionId());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
	}

}
