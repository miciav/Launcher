package it.ciavotta.Launcher.controller;



import it.ciavotta.Launcher.component.ServerStatus;
import it.ciavotta.Launcher.messages.NodeInformation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/Node")
public class NodeConnectionController {

	@RequestMapping(value ="/connect", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ServerStatus connect(@RequestBody NodeInformation nodeInfo){
	       	System.out.println(nodeInfo.getPort());
			return new ServerStatus();
	    }
	
	
}
