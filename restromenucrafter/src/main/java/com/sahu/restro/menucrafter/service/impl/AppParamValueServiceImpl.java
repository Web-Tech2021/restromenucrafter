package com.sahu.restro.menucrafter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahu.restro.menucrafter.model.AppParamValue;
import com.sahu.restro.menucrafter.repository.AppParamValueRepository;
import com.sahu.restro.menucrafter.service.AppParamValueService;

@Service
public class AppParamValueServiceImpl implements AppParamValueService {

	@Autowired
	private AppParamValueRepository appParamValueRepository;
	
	@Override
	public List<AppParamValue> findByAppParamGroupName(String appParamGroupName) {
		return appParamValueRepository.findByAppParamGroupName(appParamGroupName);
	}

	
}
