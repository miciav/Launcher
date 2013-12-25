package it.ciavotta.Node.CLRunners;

import java.io.IOException;

import it.ciavotta.Node.components.RestClient;
import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionRunner implements CommandLineRunner {
	
	
	@Autowired
	private NodeInformation nodeInfo;
	
	@Autowired
	private RestClient restClient;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
			restClient.setApplicationPath("Launcher");
			restClient.login("admin", "admin");
			if (nodeConnection()) {
				restClient.setApiPath("Node");
				NodeInformation[] listaNodi	= restClient.template().postForObject(restClient.apiUrl("nodelist"), nodeInfo, NodeInformation[].class);
				
				//NodeInformation[] listaNodi	= conn.postForObject(nodeInfo, NodeInformation[].class);
				System.out.println(listaNodi.length);	
			}
		
			

			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
 
	@Scheduled(fixedDelay= 10000)
	public boolean nodeConnection(){
		
		System.out.println("nodeconnection ");
		restClient.setApiPath("Node");
		ServerStatus status = restClient.template().postForObject(restClient.apiUrl("connect"), nodeInfo, ServerStatus.class); 
				//conn.postForObject( nodeInfo, ServerStatus.class);
		
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
