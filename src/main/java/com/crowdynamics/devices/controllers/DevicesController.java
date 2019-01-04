package com.crowdynamics.devices.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.devices.converters.DeviceDtoToDevice;
import com.crowdynamics.devices.converters.DeviceToDeviceDto;
import com.crowdynamics.devices.dto.DeviceDto;
import com.crowdynamics.devices.model.Device;
import com.crowdynamics.devices.services.DeviceService;

@RestController
@RequestMapping(value = "/devices")
public class DevicesController {

	@Autowired
	private DeviceService deviceService;

	@GetMapping
	public ResponseEntity<List<DeviceDto>> getAll() {

		List<Device> DeviceList = deviceService.findAll();

		List<DeviceDto> deviceListDto = DeviceList.stream().map(DeviceToDeviceDto::convertToDto)
				.collect(Collectors.toList());

		return new ResponseEntity<>(deviceListDto, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceDto> getById(@PathVariable Long id) {

		Device device = deviceService.findById(id);

		DeviceDto deviceDto = DeviceToDeviceDto.convertToDto(device);

		return new ResponseEntity<>(deviceDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<DeviceDto> save(DeviceDto deviceDto) {
		
		Device device = DeviceDtoToDevice.convertFromDto(deviceDto);
				
		Device newDevice = deviceService.save(device);
		
		DeviceDto newDeviceDto= DeviceToDeviceDto.convertToDto(newDevice);
		
		return new ResponseEntity<>(newDeviceDto, HttpStatus.OK);
	}
}
