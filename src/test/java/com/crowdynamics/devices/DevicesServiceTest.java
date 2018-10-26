package com.crowdynamics.devices;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.crowdynamics.devices.model.Device;
import com.crowdynamics.devices.services.DeviceService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DevicesServiceTest {

	private static final Long ID = 1L;
	private static final String DEVICE_ID = "TEST01";
	private static final Long USER_ID = 4L;
	private static final String MODEL = "MKRFOX1200";
	private static final String DESCRIPTION = "DESCRIPTION";

	@Autowired
	private DeviceService deviceService;

	/**
	 * Test obtener todos los dispositivos: Devuelve una lista vacia si no hay
	 * dispositivos
	 */
	@Sql({ "classpath:insertDevices.sql" })
	@Rollback(true)
	@Test
	public void testFindAll() {

		List<Device> deviceList = deviceService.findAll();

		Assert.assertNotNull(deviceList);
		Assert.assertEquals(1, deviceList.size());
		
	Assert.assertEquals(DEVICE_ID, deviceList.get(0).getDeviceId());
	Assert.assertEquals(USER_ID, deviceList.get(0).getUserId());
	Assert.assertTrue(MODEL.compareTo(deviceList.get(0).getModelName())==0);
	Assert.assertTrue(DESCRIPTION.compareTo(deviceList.get(0).getDescription())==0);
	
		// == 0);
	}

	 /**
	 * Test crear mensaje: Se llama al servicio de creacion de dispositivos y
	 * devuelve un dispositivo igual al pasado con el ID obtenido en DB
	 */
	 @Rollback(true)
	 @Test
	 public void testSave() {
	
	 Device newDevice = new Device();
	 newDevice.setId(ID);
	 newDevice.setDeviceId(DEVICE_ID);
	 newDevice.setUserId(USER_ID);
	 newDevice.setModelName(MODEL);
	 newDevice.setDescription(DESCRIPTION);
	
	 Device device = null;
	
	
	 try {
	 device = deviceService.save(newDevice);
	
	 } catch (Exception e) {
	 e.printStackTrace();
	
	 Assert.fail("No exception is expected");
	 }
	 // Assert.assertEquals(SEQ_NUMBER, Device.getSeqnumer());
	 // Assert.assertTrue(RECEPTION_ID.compareTo(Device.getReceptionId()) ==
	 // 0);
	 Assert.assertEquals(DEVICE_ID, device.getDeviceId());
	 Assert.assertEquals(USER_ID, device.getUserId());
	 Assert.assertEquals(MODEL, device.getModelName());
	 Assert.assertEquals(DESCRIPTION, device.getDescription());
	 
	 }
	
	 /**
	 * Test obtener todos los mensajes: Devuelve una lista vacia con un
	 elemento
	 * previamente insertado y su contenido es el esperado
	 */
	 @Rollback(true)
	 @Test
	 public void testFindAllEmpty() {
	
	 List<Device> deviceList = deviceService.findAll();
	
	 Assert.assertNotNull(deviceList);
	 Assert.assertEquals(0, deviceList.size());
	
	 }
	
	 /**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve null al no
	 * haber ningun mensaje en DB
	 */
	 @Rollback(true)
	 @Sql({ "classpath:insertDevices.sql" })
	 @Test
	 public void testFindByIdNull() {
	
	 Long longNotInserted = 10L;
	
	 Device device = deviceService.findById(longNotInserted);
	
	 Assert.assertNull(device);
	 }
	
	 /**
	 * Test obtener mensaje: Obtiene un mensaje por id, devuelve el objeto que
	 * se ha insertado previamente
	 */
	 @Rollback(true)
	 @Sql({ "classpath:insertDevices.sql" })
	 @Test
	 public void testFindById() {
	
	 Device device = deviceService.findById(4L);
	
	 Assert.assertNotNull(device);
	
	 }

}
