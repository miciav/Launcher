package it.ciavotta.Launcher.service;

import java.util.List;

import it.ciavotta.Launcher.domain.User;

public interface UserService {
	
	public void persist(User user);
	
	public List<User> getAll();

}
