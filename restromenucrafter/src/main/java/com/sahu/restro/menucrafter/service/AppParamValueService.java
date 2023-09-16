package com.sahu.restro.menucrafter.service;

import java.util.List;

import com.sahu.restro.menucrafter.model.AppParamValue;

public interface AppParamValueService {

	public List<AppParamValue> findByAppParamGroupName(String appParamGroupName);
	
}
