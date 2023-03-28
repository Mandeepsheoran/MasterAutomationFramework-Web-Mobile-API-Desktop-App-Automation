package org.igt.driver.mobile;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.igt.drivermanager.local.mobile.AndroidManager;
import org.igt.drivermanager.local.mobile.IOSManager;
import org.igt.enums.MobileOSType;
import org.openqa.selenium.WebDriver;

/**
 * Method to initialize the local mobile driver factory to setup the driver based on mobile OS platform.
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see AndroidManager
 * @see IOSManager
 */
public class LocalMobileDriverFactory {
	
private LocalMobileDriverFactory() {}
	
	private static final Map<MobileOSType, Supplier<WebDriver>> map = new EnumMap<>(MobileOSType.class);
	
	private static final Supplier<WebDriver> android = AndroidManager::getDriver;
	private static final Supplier<WebDriver> ios = IOSManager::getDriver;
	
	static {
		map.put(MobileOSType.ANDROID, android);
		map.put(MobileOSType.IOS, ios);
	}
	
	/**
	 * Method to get driver instance based on mobile OS platform type
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver(MobileOSType platformtype) {
		return map.get(platformtype).get();
	}
	

}
