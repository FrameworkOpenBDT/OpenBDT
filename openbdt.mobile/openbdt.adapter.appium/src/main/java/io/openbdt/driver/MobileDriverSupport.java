package io.openbdt.driver;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.openbdt.exception.DriverAlreadyExistException;
import io.openbdt.exception.DriverNotExistException;
import io.openbdt.exception.NoUdidAvailableException;

/**
 * 
 * @author splait
 *
 */
public class MobileDriverSupport {

	private static Map<String, Object> driverList;
	private static Logger LOG;
	private static Integer driversAssociatedQuantity;
	private static Integer devicesQuantity;

	static {
		driversAssociatedQuantity = 0;
		devicesQuantity = 0;
		//driverList = new HashMap<>();
		driverList = Collections.synchronizedMap(new LinkedHashMap<String, Object>());
		LOG = Logger.getLogger(MobileDriverSupport.class);
	}

	public <T extends AppiumDriver<? extends MobileElement>> void addDriver(String udid, T driver)
			throws DriverAlreadyExistException {
		synchronized (driverList) {
			if (driverList.containsKey(udid)) {
				throw new DriverAlreadyExistException(String.format("'%s' already was associated with a driver", udid));
			}
			driverList.put(udid, driver);
		}
		LOG.info("###################################");
		LOG.info(String.format("%s : Driver added", udid));
		LOG.info("###################################");
	}

	public void removeDriver(String udid) throws DriverNotExistException {
		synchronized (driverList) {
			if (!driverList.containsKey(udid)) {
				throw new DriverNotExistException(String.format("There is not driver available to '%s'", udid));
			}
			driverList.remove(udid);
		}
		LOG.info("###################################");
		LOG.info(String.format("%s : Driver removed", udid));
		LOG.info("###################################");
	}

	@SuppressWarnings({ "hiding", "unchecked" })
	public <Driver extends AppiumDriver<? extends MobileElement>> Driver getDriver(String udid)
			throws DriverNotExistException {
		synchronized (driverList) {
			if (driverList.containsKey(udid)) {
				// LOG.info(String.format("%s : Driver obtained", udid));
				return (Driver) driverList.get(udid);
			}
			throw new DriverNotExistException(String.format("There is not driver available to '%s'", udid));
		}
	}

	public void setTotalDevices(Integer devicesQuantity) {
		this.devicesQuantity = devicesQuantity;
	}

	public String getNextUdid() throws NoUdidAvailableException {
		synchronized (driverList) {
			LOG.info("Trying to get a device udid not associated yet");
			String[] udidList = driverList.keySet().toArray(new String[] {});
			if (udidList.length > driversAssociatedQuantity) {
				return udidList[driversAssociatedQuantity++];
			}
		}
		throw new NoUdidAvailableException("No udid available");
	}

	@Override
	public String toString() {
		return String.format("Drivers available: %s", this.driverList.keySet());
	}
}
