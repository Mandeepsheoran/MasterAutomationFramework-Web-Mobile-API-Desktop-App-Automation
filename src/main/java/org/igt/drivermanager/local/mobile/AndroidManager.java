package org.igt.drivermanager.local.mobile;

import org.igt.configfactory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.windows.WindowsDriver;

/**
 * Base class to create instance for Android mobile driver for local execution.
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see AndroidDriver
 */
public final class AndroidManager {
	
	private AndroidManager() {}
	
	/**
	 * Method to create driver for Android on local by providing application path and other details.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 */
	public static WebDriver getDriver() {
		UiAutomator2Options options = new UiAutomator2Options()
			       .setDeviceName("Android Emulator")
			       .setApp(System.getProperty("user.dir") + "/ApiDemos-debug.apk")
			       .setPlatformName("Android");	
		options.setCapability("device", "Samsung Galaxy S22");
		options.setCapability("project", "First Appium Project");
		options.setCapability("build", "T_01");
		options.setCapability("name", "Test1");
		options.setCapability("os_version", "12.0");		
		return new AndroidDriver(ConfigFactory.getConfig().localAppiumServerURL(), options);		
	}
}
