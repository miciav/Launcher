/**
 * 
 */
package it.ciavotta.Launcher.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author michele ciavotta
 *
 */
@Entity(name = "User")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int Id;
	
	@NotNull
	@Size(min = 4, max = 10)
	private String username;
	
	@NotNull
	@Size(min = 5, max = 10)	
	private String password;
	
	@NotEmpty
	@Email
	private String email;

	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	@ManyToMany
	@JoinTable(name="UsersAndRoles",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	
	public User(){
		
		this.roles = new ArrayList<Role>();
	}
	
	

	public User(String username, String password, String email, UserStatus type,
			List<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = type;
		this.roles = roles;
	}



	public UserStatus getStatus() {
		return status;
	}



	public void setStatus(UserStatus type) {
		this.status = type;
	}



	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


}
