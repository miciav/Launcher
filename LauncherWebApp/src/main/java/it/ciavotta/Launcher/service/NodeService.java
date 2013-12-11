package it.ciavotta.Launcher.service;

import it.ciavotta.Launcher.domain.Node;

import java.util.List;

public interface NodeService {

	public void persist(Node node);
	
	public List<Node> getAll();
	
	public boolean contains(Node node);
	
	public Node isContained(Node node);
}
