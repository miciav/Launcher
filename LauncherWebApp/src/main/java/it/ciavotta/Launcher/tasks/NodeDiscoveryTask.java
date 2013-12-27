package it.ciavotta.Launcher.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import it.ciavotta.Launcher.components.restclient.RestClient;
import it.ciavotta.Launcher.messages.NodeInformation;
import it.ciavotta.Launcher.messages.ServerStatus;
import it.ciavotta.Launcher.repository.NodeRepository;
import it.ciavotta.Launcher.domain.Node;

/*Every XXX minutes the launcher tries to connect to the nodes and update database
 * TODO: we should consider a bootstrap file */
@Component
public class NodeDiscoveryTask {
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private NodeRepository nodeRepository;
	
	@Autowired
	ServerStatus serverStatus;
	
	/*updating the information about connected nodes*/
	@Scheduled(fixedDelay=1000)
	public void updateNodes(){
		System.out.println("LAUNCHER: connecting to node");
		Iterable<Node> nodeList = nodeRepository.findAll();
//		restClient.setApplicationPath("Node");
		restClient.setApiPath("Launcher");
		serverStatus.setMessage("Connected");
		for (Node node : nodeList) {
			restClient.setHostAddress(node.getNodeIP());
			restClient.setPort(node.getPort());
			try {
				restClient.login("Launcher", "Launcher");
			} catch (Exception e1) {

				System.out.println("LAUNCHER: logging error");
			}
			serverStatus.setConnectionId(node.getNodeId());
			try {
				NodeInformation nodeInfo = restClient.
											template().
											postForObject(	restClient.apiUrl("connect"), 
															serverStatus, 
															NodeInformation.class);
				/*this should be equivalent to update*/
				nodeRepository.save( Node.fromNodeInformation(nodeInfo));
				System.out.println("LAUNCHER: updating node");
			} catch (Exception e) {
				nodeRepository.delete(node);			
				System.out.println("LAUNCHER: deleting to node");
			} 
		}
		
	}

}
