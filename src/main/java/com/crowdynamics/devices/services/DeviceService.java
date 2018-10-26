package com.crowdynamics.devices.services;

import java.util.List;

import com.crowdynamics.devices.model.Device;

public interface DeviceService {
	Device save(Device sigfoxMessage) ;

	Device findById(Long id);

	List<Device> findAll();
}
