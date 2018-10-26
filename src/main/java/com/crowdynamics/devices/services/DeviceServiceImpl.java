package com.crowdynamics.devices.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crowdynamics.devices.exceptions.DeviceServiceException;
import com.crowdynamics.devices.model.Device;
import com.crowdynamics.devices.repository.DeviceDAO;

@Service
public class DeviceServiceImpl implements DeviceService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DeviceServiceImpl.class);

	@Autowired
	private DeviceDAO deviceDAO;

	@Transactional(rollbackFor = Exception.class)
	public Device save(Device device) {

		return (Device) performOperation(() -> deviceDAO.save(device));
	}

	@Transactional(readOnly = true)
	public Device findById(Long id) {

		return ((Optional<Device>) performOperation(() -> deviceDAO.findById(id))).orElse(null);
	}

	@Transactional(readOnly = true)
	public List<Device> findAll() {

		return (List<Device>) performOperation(() -> deviceDAO.findAll());
	}

	private Object performOperation(Callable<?> function) {

		Object result = null;

		try {

			result = function.call();

		} catch (Exception e) {
			DeviceServiceImpl.handleUnexpectedError(e);
		}

		return result;
	}

	private static void handleUnexpectedError(Exception exception) {

		LOGGER.error("Error procesando operacion", exception);

		throw new DeviceServiceException("DeviceServiceError", exception);
	}

}
