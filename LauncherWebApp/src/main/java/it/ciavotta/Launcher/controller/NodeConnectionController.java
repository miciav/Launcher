package it.ciavotta.Launcher.controller;



import java.util.UUID;

import it.ciavotta.Launcher.messages.ServerStatus;
import it.ciavotta.Launcher.domain.Node;
import it.ciavotta.Launcher.domain.NodeState;
import it.ciavotta.Launcher.messages.NodeInformation;
import it.ciavotta.Launcher.service.NodeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Node")
public class NodeConnectionController {

	@Autowired
	NodeService nodeService;
	
	@Autowired
	ServerStatus serverStatus;
	
	@RequestMapping(value ="/connect", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ServerStatus connect(@RequestBody NodeInformation nodeInfo){
		
			Node node = convertNodeInfo(nodeInfo);
			try {
				if ( nodeService.isContained(node)== null){
					node.setNodeId( UUID.randomUUID().toString()); // adding connection id
					nodeService.persist(node);
					serverStatus.setMessage("Connected");
					serverStatus.setConnectionId(node.getNodeId());
				}
				else{
					// not returning the id 
					serverStatus.setMessage("Connected");
				}
					
			} catch (Exception e) {
				serverStatus.setStatus("ERROR");
				serverStatus.setMessage("Not Connected");
			}
			
			return serverStatus;
	    }
	
	private Node convertNodeInfo(NodeInformation nodeInfo){
		Node node = new Node();
		node.setNodeIP(nodeInfo.getIpAddress());
		node.setOperatingSystem(nodeInfo.getOs());
		node.setArchitecture(nodeInfo.getOsArch());
		node.setPort(nodeInfo.getPort());
		node.setId(nodeInfo.getId());
		node.setOsVersion(nodeInfo.getOsVersion());
		node.setNodeId(nodeInfo.getNodeID());
		
		if (nodeInfo.getState().equals("OK")) {
			node.setState(NodeState.OK);
		}
		else if (nodeInfo.getState().equals("ERROR")) {
			node.setState(NodeState.ERROR);
		}
		
		return node;
	}
	
}
