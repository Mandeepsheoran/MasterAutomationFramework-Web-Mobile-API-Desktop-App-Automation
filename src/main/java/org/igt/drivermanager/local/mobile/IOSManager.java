package org.igt.drivermanager.local.mobile;

import org.igt.configfactory.ConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Base class to create instance for Android mobile driver for local execution.
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see IOSDriver
 */
public final class IOSManager {

	private IOSManager() {}
	/**
	 * Method to create driver for iOS on local by providing application path and other details. 
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 */
	public static WebDriver getDriver() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
		capabilities.setCapability(MobileCapabilityType.APP,
				System.getProperty("user.dir") + "src/test/resources/mobile-app/ios-app.zip");
		return new IOSDriver(ConfigFactory.getConfig().localAppiumServerURL(), capabilities);
	}
}
