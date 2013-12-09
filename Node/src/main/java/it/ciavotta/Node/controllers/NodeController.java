package it.ciavotta.Node.controllers;

import it.ciavotta.Node.components.NodeInformation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@ConfigurationProperties(name = "server")
public class NodeController {
	
	@Autowired
	private NodeInformation nodeInfo;
	
	

	@RequestMapping("/nodeInformation")
	public @ResponseBody NodeInformation nodeInformation(){
	        return nodeInfo;
	    }

}
