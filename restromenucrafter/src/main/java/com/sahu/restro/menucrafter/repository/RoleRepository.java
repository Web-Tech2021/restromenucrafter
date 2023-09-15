package com.sahu.restro.menucrafter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sahu.restro.menucrafter.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	@Query(value = "SELECT r.* FROM role AS r \r\n"
			+ "INNER JOIN user_role AS ur ON r.id = ur.role_id \r\n"
			+ "WHERE ur.user_id = :userId AND r.active = true", nativeQuery = true)
	public List<Role> getRolesOfUserByUserId(Long userId);

	public Optional<Role> findByName(String name);

}
