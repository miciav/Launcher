package it.ciavotta.Launcher.repository;

import it.ciavotta.Launcher.domain.Experiment;

import org.springframework.data.repository.CrudRepository;

public interface ExperimentRepository extends CrudRepository<Experiment, Long> {

}
