package it.ciavotta.Launcher.repository;

import it.ciavotta.Launcher.domain.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	public Role findRoleByRoleName(String roleName);
}
