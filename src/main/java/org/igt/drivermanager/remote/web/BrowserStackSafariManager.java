package org.igt.drivermanager.remote.web;

import org.igt.configfactory.BrowserStackConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Class to create instance for Safari manager on BrowserStack for remote execution.
 * Feb 22, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see DesiredCapabilities
 * @see RemoteWebDriver
 */
public class BrowserStackSafariManager {
	
	private BrowserStackSafariManager() {}
	/**
	 * Method to return Safari driver instance for BrowserStack remote execution.
	 * Feb 22, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "chrome");
		caps.setCapability("browser_version", "latest");
		return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), caps);
	}
}
