package com.crowdynamics.devices.converters;

import com.crowdynamics.devices.dto.DeviceDto;
import com.crowdynamics.devices.model.Device;

public class DeviceToDeviceDto {

	public static DeviceDto convertToDto(Device device) {
		DeviceDto deviceDto = null;

		if (device != null) {
			deviceDto = new DeviceDto();

			deviceDto.setId(device.getId());
			deviceDto.setDeviceId(device.getDeviceId());
			deviceDto.setModelName(device.getModelName());
			deviceDto.setUserId(device.getUserId());
			deviceDto.setDescription(device.getDescription());

		}
		return deviceDto;
	}

}
