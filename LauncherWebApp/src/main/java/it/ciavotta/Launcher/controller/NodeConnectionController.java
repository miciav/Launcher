package it.ciavotta.Launcher.controller;

import it.ciavotta.Launcher.messages.LauncherStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/Node")
public class NodeConnectionController {
	
	@RequestMapping(value="/state")
	public @ResponseBody LauncherStatus connection(){
        return new LauncherStatus();
    }
}
