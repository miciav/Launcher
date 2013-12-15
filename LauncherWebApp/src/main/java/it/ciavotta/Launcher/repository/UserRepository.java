package it.ciavotta.Launcher.repository;

import it.ciavotta.Launcher.domain.User;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUsername(String username);
}
