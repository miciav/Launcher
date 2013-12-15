package it.ciavotta.Launcher.controller;

import it.ciavotta.Launcher.domain.Role;
import it.ciavotta.Launcher.domain.User;
import it.ciavotta.Launcher.domain.UserStatus;
import it.ciavotta.Launcher.repository.RoleRepository;
import it.ciavotta.Launcher.repository.UserRepository;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping( value= "/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
	
		User user = new User();
		user.setUsername("username");
		user.setPassword("username");
		user.setEmail("name@email.com");
		user.setStatus(UserStatus.ACTIVE);
		ModelAndView mv = new ModelAndView("registration", "user", user);
//		mv.addObject("usernameMessage", "prova prova");
		return mv;
	}
	@RequestMapping( value= "/registration", method = RequestMethod.POST)
	public ModelAndView login(@Valid User user, BindingResult result, Model model){
	
		if(result.hasErrors()){
			ModelAndView mv = new ModelAndView("registration", "user", user);
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError error : errors){
				String field = error.getField();
				if (field.equals("username")) {
					mv.addObject("usernameMessage", "<--");
				} else if(field.equals("password"))
				{
					mv.addObject("passwordMessage", "<--");	
				}
				else{
					mv.addObject("emailMessage", "<--");
									
				}
				mv.addObject("errorMessage","Registration Error!!");	
			}
			return mv;
		}
		
		Role role = roleRepository.findRoleByRoleName("USER");
		user.getRoles().add(role);
		User foundUser = userRepository.findUserByUsername(user.getUsername());
		if(foundUser != null){
			return new ModelAndView("registration", "user", user);
		}else{
			user.getRoles().add(role);
			user.setStatus(UserStatus.ACTIVE);
			userRepository.save(user);
			return new ModelAndView("index");
		}
			
	}
	
}
