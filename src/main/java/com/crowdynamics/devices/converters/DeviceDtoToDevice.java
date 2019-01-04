package com.crowdynamics.devices.converters;

import com.crowdynamics.devices.dto.DeviceDto;
import com.crowdynamics.devices.model.Device;

public class DeviceDtoToDevice {
	public static Device convertFromDto(DeviceDto deviceDto) {
		Device device = null;

		if (deviceDto != null) {
			device = new Device();

			device.setId(deviceDto.getId());
			device.setDeviceId(deviceDto.getDeviceId());
			device.setModelName(deviceDto.getModelName());
			device.setUserId(deviceDto.getUserId());
			device.setDescription(deviceDto.getDescription());

		}
		return device;
	}

}
