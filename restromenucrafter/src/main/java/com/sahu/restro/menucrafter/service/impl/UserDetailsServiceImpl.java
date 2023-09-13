package com.sahu.restro.menucrafter.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sahu.restro.menucrafter.model.Permission;
import com.sahu.restro.menucrafter.model.Role;
import com.sahu.restro.menucrafter.model.User;
import com.sahu.restro.menucrafter.repository.PermissionRepository;
import com.sahu.restro.menucrafter.repository.RoleRepository;
import com.sahu.restro.menucrafter.repository.UserRepository;
import com.sahu.restro.menucrafter.service.dto.CustomUserDetailsDTO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public CustomUserDetailsDTO loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.debug("Inside loadUserByUsername() method");
		Optional<User> user = userRepository.findByEmail(username);
		LOGGER.info("User - " + user);

		if (user.get() == null) {
			throw new UsernameNotFoundException("User is not exist");
		} else if (!user.get().getActive()) {
			throw new UsernameNotFoundException("User is not active, please contact admin!");
		} else {
			Long loggedInUserId = user.get().getId();
			List<GrantedAuthority> authorities = user.get().getRoles().stream()
					.flatMap(role -> role.getPermissions().stream()
							.map(permission -> new SimpleGrantedAuthority(permission.getName())))
					.collect(Collectors.toList());

			// Here we have to write the logic to collect Roles and permission
			List<Role> roleList = roleRepository.getRolesOfUserByUserId(loggedInUserId);
			List<Permission> permissionList = permissionRepository.getAllPermissionsOfUserByUserId(loggedInUserId);

			List<String> userRoles = roleList.stream().map(Role::getName).collect(Collectors.toList());
			List<String> userPermissions = permissionList.stream().map(Permission::getName)
					.collect(Collectors.toList());

			LOGGER.info("User object created");
			return new CustomUserDetailsDTO(username, user.get().getPassword(), authorities, loggedInUserId, username,
					userRoles, userPermissions);
		}
	}

}
