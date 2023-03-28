package org.igt.drivermanager.remote.mobile;

import org.igt.configfactory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
/**
 * Class to create instance for Android driver on BrowserStack
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see AndroidDriver
 * @see UiAutomator2Options
 */
public class BrowserStackAndroidManager {
	
	private BrowserStackAndroidManager() {}
	/**
	 * Method to return Android/WebDriver instance for remote execution on BrowserStack.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
		UiAutomator2Options options = new UiAutomator2Options()
			       .setPlatformName("Android");	
//		options.setCapability("username", "mandeepsheoran_HMkLhW");
//		options.setCapability("access_key", "hDswhU9eB6bza1oMBtPy");
//		options.setCapability("app", "bs://0b49595c1bc4162972a9cc5efcbfadaad8d0b487");
		options.setCapability("project", "Browserstack Appium Android Project");
		options.setCapability("build", "ANDROID_01");
		options.setCapability("name", "Browserstack Android Test");	
		options.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		options.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		return new AndroidDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), options);
	}
}
