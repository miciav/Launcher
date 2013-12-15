package it.ciavotta.Launcher.components;

import it.ciavotta.Launcher.domain.Role;
import it.ciavotta.Launcher.domain.User;
import it.ciavotta.Launcher.domain.UserStatus;
import it.ciavotta.Launcher.repository.RoleRepository;
import it.ciavotta.Launcher.repository.UserRepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LauncherWebAppInit implements InitializingBean {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	public LauncherWebAppInit(){
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		try {
			Role role = new Role();
//			role.setId(1);
			role.setRoleName("ADMIN");
			roleRepository.save(role);
			User user = new User();
			role.getUsers().add(user);
			user.setUsername("admin");
			user.setPassword("admin");
			user.setStatus(UserStatus.ACTIVE);
			user.getRoles().add(role);
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
