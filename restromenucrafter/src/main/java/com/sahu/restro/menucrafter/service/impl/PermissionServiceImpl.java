package com.sahu.restro.menucrafter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.restro.menucrafter.model.Permission;
import com.sahu.restro.menucrafter.repository.PermissionRepository;
import com.sahu.restro.menucrafter.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionRepository permissionRepository;

	@Override
	public List<Permission> findAll() {
		return permissionRepository.findByActive(true);
	}

	@Override
	public List<Permission> findByIdIn(List<Long> ids) {
		return permissionRepository.findAllById(ids);
	}

	@Override
	public List<Permission> getAllPermissionsOfUserByUserId(Long userId) {
		return permissionRepository.getAllPermissionsOfUserByUserId(userId);
	}

}
