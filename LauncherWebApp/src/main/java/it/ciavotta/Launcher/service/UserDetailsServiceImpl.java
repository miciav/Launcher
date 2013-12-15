package it.ciavotta.Launcher.service;

import it.ciavotta.Launcher.domain.Role;
import it.ciavotta.Launcher.domain.User;
import it.ciavotta.Launcher.domain.UserStatus;
import it.ciavotta.Launcher.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException {
		
		User user = userRepository.findUserByUsername(arg0);
		
		
		if (user != null) {
			String password = user.getPassword();
			boolean enabled = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean credentialsNonExpired = user.getStatus().equals(UserStatus.ACTIVE);
			boolean accountNonLocked = user.getStatus().equals(UserStatus.ACTIVE);
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for (Role role : user.getRoles()){
				authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(user.getUsername(), 
																		password, 
																		enabled, 
																		accountNonExpired, 
																		credentialsNonExpired, 
																		accountNonLocked, 
																		authorities);
		return securityUser;
		}
		else{
			throw new UsernameNotFoundException("Username not Found!!");
			
		}
		
	}

}
