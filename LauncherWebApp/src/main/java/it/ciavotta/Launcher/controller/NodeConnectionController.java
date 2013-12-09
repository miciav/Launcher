package it.ciavotta.Launcher.controller;



import it.ciavotta.Launcher.component.ServerStatus;
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
				nodeService.persist(node);
			} catch (Exception e) {
				serverStatus.setStatus("ERROR");
			}
			
			System.out.println(nodeInfo.getPort());
			return serverStatus;
	    }
	
	private Node convertNodeInfo(NodeInformation nodeInfo){
		Node node = new Node();
		node.setNodeIP(nodeInfo.getIpAddress());
		node.setOperatingSystem(nodeInfo.getOs());
		node.setArchitecture(nodeInfo.getOsArch());
		node.setOsVersion(nodeInfo.getOsVersion());
		if (nodeInfo.getState() == "OK") {
			node.setState(NodeState.OK);
		}
		else if (nodeInfo.getState() =="ERROR") {
			node.setState(NodeState.ERROR);
		}
		return node;
	}
	
}
