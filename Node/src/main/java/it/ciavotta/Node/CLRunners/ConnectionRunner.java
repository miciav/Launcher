package it.ciavotta.Node.CLRunners;

import it.ciavotta.Node.components.RestConnector;
import it.ciavotta.Node.components.NodeInformation;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConnectionRunner implements CommandLineRunner {
	
	@Autowired
	private RestConnector conn;
	
	@Autowired
	private NodeInformation nodeInfo;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			

		
			conn.setRestAPIName("Node/connect");

			ServerStatus status = conn.postForObject( nodeInfo, ServerStatus.class);
			
		//	ServerStatus status = rest.getForObject(url, ServerStatus.class);
			
			System.out.println(status.getStatus());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
