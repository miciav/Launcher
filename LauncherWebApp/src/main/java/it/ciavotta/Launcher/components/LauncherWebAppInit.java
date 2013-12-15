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
			Role roleAdmin = new Role();
			roleAdmin.setRoleName("ADMIN");
			roleRepository.save(roleAdmin);

			Role roleUser = new Role();
			roleUser.setRoleName("USER");
			roleRepository.save(roleUser);
			
			User user = new User();
			roleUser.getUsers().add(user);
			roleAdmin.getUsers().add(user);
			user.setUsername("admin");
			user.setPassword("admin");
			user.setStatus(UserStatus.ACTIVE);
			user.setEmail("admin@mail.com");
			user.getRoles().add(roleUser);
	//		userRepository.save(user);
			user.getRoles().add(roleAdmin);
			userRepository.save(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
