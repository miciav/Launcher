package it.ciavotta.Launcher.controller;



import it.ciavotta.Launcher.domain.Node;
import it.ciavotta.Launcher.domain.NodeState;
import it.ciavotta.Launcher.messages.NodeInformation;
import it.ciavotta.Launcher.messages.ServerStatus;
import it.ciavotta.Launcher.repository.NodeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javassist.expr.NewArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Node")
public class NodeConnectionController {

//	@Autowired
//	NodeService nodeService;
	
	@Autowired
	ServerStatus serverStatus;
	
	@Autowired
	NodeRepository repository;
	
	@RequestMapping(value ="/connect", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ServerStatus connect(@RequestBody NodeInformation nodeInfo){
		
		Node node = Node.fromNodeInformation(nodeInfo);
			try {
				if (!repository.exists(node.getId())){	
					node.setNodeId( UUID.randomUUID().toString()); // adding connection id
					repository.save(node);

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
	
	@RequestMapping(value ="/nodelist", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody NodeInformation[] nodeList(@RequestBody NodeInformation nodeInfo){
		
		
		Node node = Node.fromNodeInformation(nodeInfo);
		List<Node> list  = repository.findAllButThisNodeId(node.getNodeId());
		
		
		NodeInformation[] listNodes = new NodeInformation[list.size()]; 
				
		for(int i = 0; i < list.size(); i++) listNodes[i] = NodeInformation.fromNode(list.get(i));
		
		return listNodes;
		
	}
	
	

	
}
