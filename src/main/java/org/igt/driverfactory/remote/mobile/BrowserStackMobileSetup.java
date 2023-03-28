package org.igt.driverfactory.remote.mobile;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.igt.drivermanager.remote.mobile.BrowserStackAndroidManager;
import org.igt.drivermanager.remote.mobile.BrowserStackIOSManager;
import org.igt.enums.MobileOSType;
import org.openqa.selenium.WebDriver;

/**
 * Class to contain methods for remote mobile setup on BrowserStack platform.
 * Jan 31, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see BrowserStackIOSManager
 * @see BrowserStackAndroidManager
 */
public class BrowserStackMobileSetup {
	
	private BrowserStackMobileSetup() {}
	
	private static final Map<MobileOSType, Supplier<WebDriver>> map = new EnumMap<>(MobileOSType.class);
	private static final Supplier<WebDriver> android = BrowserStackAndroidManager::getDriver;
	private static final Supplier<WebDriver> ios = BrowserStackIOSManager::getDriver;	
	static {
		map.put(MobileOSType.ANDROID, android);
		map.put(MobileOSType.IOS,ios);
	}
	/**
	 * Method to provide get driver based on mobile OS type.
	 * Jan 31, 2023
	 * @author Mandeep Sheoran
	 */
	public static WebDriver getDriver(MobileOSType platformtype) {
		return map.get(platformtype).get();
	}
}
