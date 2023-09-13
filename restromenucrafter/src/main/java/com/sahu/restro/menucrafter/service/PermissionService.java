package com.sahu.restro.menucrafter.service;

import java.util.List;

import com.sahu.restro.menucrafter.model.Permission;

public interface PermissionService {

	public List<Permission> findAll();

	public List<Permission> findByIdIn(List<Long> ids);
	
	public List<Permission> getAllPermissionsOfUserByUserId(Long userId);

}
