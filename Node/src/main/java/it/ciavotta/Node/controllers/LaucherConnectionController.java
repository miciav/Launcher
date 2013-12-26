package it.ciavotta.Node.controllers;



import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Launcher")
public class LaucherConnectionController {

	@Autowired
	NodeInformation nodeInformation;
	
	@RequestMapping(value ="/connect", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody NodeInformation connect(@RequestBody ServerStatus serverStatus){
		if (serverStatus.getConnectionId().equals(nodeInformation.getNodeID())) {
			return nodeInformation;
		} else {
			return null;
		}
	}
	@RequestMapping(value ="/connect", method = RequestMethod.GET)
	public @ResponseBody NodeInformation connectGet(){
			return nodeInformation;
		
	}
}
