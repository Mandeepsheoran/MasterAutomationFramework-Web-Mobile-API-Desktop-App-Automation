package org.igt.drivermanager.remote.mobile;

import org.igt.configfactory.BrowserStackConfigFactory;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
/**
 * Class to create instance for iOS driver on BrowserStack
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see IOSDriver
 * @see WebDriver
 */
public class BrowserStackIOSManager {
	
	private BrowserStackIOSManager() {}
	/**
	 * Method to return IOSDriver/WebDriver instance for remote execution on BrowserStack.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		    capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
		    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 Pro Max");
		    capabilities.setCapability("project", "Browserstack Appium IOS Project");
		    capabilities.setCapability("build", "IOS_01");
		    capabilities.setCapability("name", "Browserstack IOS Test");	
		return new IOSDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);
	}
}
