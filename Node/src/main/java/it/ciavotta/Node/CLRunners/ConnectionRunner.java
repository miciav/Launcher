package it.ciavotta.Node.CLRunners;

import java.io.IOException;
import java.util.List;

import it.ciavotta.Node.components.RestClient;
import it.ciavotta.Node.components.RestConnector;
import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConnectionRunner implements CommandLineRunner {
	
	@Autowired
	private RestConnector conn;
	
	@Autowired
	private NodeInformation nodeInfo;
	
	@Autowired
	private RestClient restClient;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
			restClient.setApplicationPath("Launcher");
			String url = restClient.login("admin", "admin");
			if (nodeConnection()) {
				conn.setRestAPIName("Node/nodeList");
				NodeInformation[] listaNodi	= conn.postForObject(nodeInfo, NodeInformation[].class);
				System.out.println(listaNodi.length);	
			}
		
			

			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private boolean nodeConnection(){
		conn.setRestAPIName("Node/connect");

		ServerStatus status = conn.postForObject( nodeInfo, ServerStatus.class);
		
		if (status !=null && status.getMessage().equals("Connected") && status.getConnectionId() != null) {
			try {
				nodeInfo.setNodeID(status.getConnectionId());
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				return false;
			}
		}
		return false;
		
		
	}
	
	
}
