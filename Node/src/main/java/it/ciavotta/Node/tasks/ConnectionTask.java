package it.ciavotta.Node.tasks;

import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.components.RestClient;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConnectionTask {

	@Autowired
	private NodeInformation nodeInfo;
//	
	@Autowired
	private RestClient restClient;
	
	public ConnectionTask(){
		
		String prova = "aiuto!!";
		System.out.println(prova);
	}
	
	@Scheduled(fixedDelay = 5000) // ten minutes
	public void nodeConnection(){
		
		System.out.println("NODE: nodeconnection ");
		restClient.setApiPath("Node");
		
		try {
			restClient.logout();
			restClient.login("admin", "admin");
		} catch (Exception e1) {
			nodeInfo.setState("Error");
			System.out.println("NODE: not connected! ");
		}
		
		try {
			ServerStatus status = restClient.template().postForObject(restClient.apiUrl("connect"), nodeInfo, ServerStatus.class);
		
		
		if (status !=null && status.getMessage().equals("Connected") && status.getConnectionId() != null) {

			System.out.println("NODE: connected! ");
				nodeInfo.setNodeID(status.getConnectionId());
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			nodeInfo.setState("Error");
			System.out.println("NODE: not connected! ");
		} 
		
		
	}

}
