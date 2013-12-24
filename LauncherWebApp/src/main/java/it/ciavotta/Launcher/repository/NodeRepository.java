package it.ciavotta.Launcher.repository;


import java.util.List;

import it.ciavotta.Launcher.domain.Node;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface NodeRepository extends CrudRepository<Node, String> {

@Query("SELECT n FROM Node n WHERE n.nodeId = :NODEID ORDER BY n.id")
public List<Node> findAllButThisNodeId(@Param("NODEID") String nodeId);
}
