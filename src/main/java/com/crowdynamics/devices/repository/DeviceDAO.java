package com.crowdynamics.devices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crowdynamics.devices.model.Device;

public interface DeviceDAO extends JpaRepository<Device,Long> {
}


