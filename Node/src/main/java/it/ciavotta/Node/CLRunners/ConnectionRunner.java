package it.ciavotta.Node.CLRunners;

import it.ciavotta.Node.components.RestConnector;
import it.ciavotta.Node.domain.NodeInformation;
import it.ciavotta.Node.domain.ServerStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ConnectionRunner implements CommandLineRunner {

	private RestTemplate rest = new RestTemplate();
	
	private String address = "localhost";
	
	private String port = "8080";
	
	private String serviceName = "/Launcher/Node";
	
	@Autowired
	private RestConnector conn;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			
			System.out.println(conn.getAddress());
//			System.out.println(conn.getPort());
//			System.out.println(conn.getServerName());
			
			
	//        rest.getMessageConverters().add(new StringHttpMessageConverter());
			
	//		String url = "http://"+address+":"+port+serviceName+"/connect";
		
			conn.setRestAPIName("Node/connect");
	
			
			NodeInformation nodeInfo = new NodeInformation("localhost", "9000", "running");
			
			ServerStatus status = conn.postForObject( nodeInfo, ServerStatus.class);
			
		//	ServerStatus status = rest.getForObject(url, ServerStatus.class);
			
			System.out.println(status.getStatus());
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
