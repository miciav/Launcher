package it.ciavotta.Launcher.service;

import it.ciavotta.Launcher.dao.BaseDao;
import it.ciavotta.Launcher.domain.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	BaseDao baseDao;
	
	@Override
	public void persist(User user) {
		baseDao.persist(user);

	}

	@Override
	public List<User> getAll() {
		
		return baseDao.getAll(User.class);
	}

	@Override
	public boolean contains(User user) {
		
		return baseDao.contains(user);
	}

}
