package org.igt.drivermanager.remote.web;

import org.igt.configfactory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Class to create instance for Firefox driver on SelenoidGrid for remote execution.
 * Feb 22, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ChromeOptions
 * @see RemoteWebDriver
 */
public class SelenoidFirefoxManager {
	
	private SelenoidFirefoxManager() {}
	/**
	 * Method to return Firefox Driver on Selenoid remote execution.
	 * Feb 22, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", "firefox");
		caps.setCapability("enableVNC", "true");
		caps.setCapability("enableVideo", "false");
		return new RemoteWebDriver(ConfigFactory.getConfig().selenoidGrid(),caps);
	}

}
