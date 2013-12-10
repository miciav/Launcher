package it.ciavotta.Launcher.service;

import it.ciavotta.Launcher.dao.BaseDao;
import it.ciavotta.Launcher.domain.Node;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("NodeServicen")
public class NodeServiceImpl implements NodeService {

	@Autowired
	BaseDao baseDao;
	
	@Override
	public void persist(Node node) {
		baseDao.persist(node);

	}

	@Override
	public List<Node> getAll() {

		return baseDao.getAll(Node.class);
	}

	@Override
	public boolean contains(Node node) {
		return baseDao.contains(node);
	}

	
}
