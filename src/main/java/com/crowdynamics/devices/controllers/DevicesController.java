package com.crowdynamics.devices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crowdynamics.devices.dto.DeviceDto;

@RestController
@RequestMapping(value = "/devices")
public class DevicesController {

	@GetMapping
	public ResponseEntity<DeviceDto> getAll() {
		throw new RuntimeException("Not implemented yet");
	}

	@GetMapping("/{id}")
	public ResponseEntity<DeviceDto> getById(@PathVariable Long id) {
		throw new RuntimeException("Not implemented yet");
	}

	@PostMapping
	public ResponseEntity<DeviceDto> save(DeviceDto deviceDto) {
		throw new RuntimeException("Not implemented yet");
	}
}
