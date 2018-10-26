package com.crowdynamics.devices.exceptions;

public class DeviceServiceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeviceServiceException(String message, Throwable cause) {
		super(message, cause);
	}



	public DeviceServiceException(String message) {
		super(message);
	}

	public DeviceServiceException(Throwable cause) {
		super(cause);
	}



}