package com.crowdynamics.devices.dto;

import lombok.Data;

@Data
public class DeviceDto {

	private Long id;
	private String deviceId;
	private Long userId;
	private	String modelName;
	private String description;
	
	
}
