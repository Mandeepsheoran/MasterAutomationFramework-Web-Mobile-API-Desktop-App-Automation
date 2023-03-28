package org.igt.drivermanager.remote.web;

import org.igt.configfactory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Class to create instance for Firefox manager on SeleniumGrid for remote execution.
 * Feb 22, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see DesiredCapabilities
 * @see RemoteWebDriver
 */
public class SeleniumGridFirefoxManager {
	
	private SeleniumGridFirefoxManager() {}
	/**
	 * Method to return Firefox driver instance for SeleniumGrid remote execution.
	 * Feb 22, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("browserName", "firefox");
	return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridUrl(),caps);	
	}
}
