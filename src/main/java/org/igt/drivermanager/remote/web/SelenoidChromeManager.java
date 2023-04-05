package org.igt.drivermanager.remote.web;

import org.igt.configfactory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Class to create instance for Chrome driver on SelenoidGrid for remote execution.
 * Feb 22, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see ChromeOptions
 * @see RemoteWebDriver
 */
public class SelenoidChromeManager {
	
	private SelenoidChromeManager() {}
	/**
	 * Method to return Chrome Driver on Selenoid remote execution.
	 * Feb 22, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver() {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("--headless");
			options.addArguments("--disable-extensions");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--ignore-ssl-errors=yes");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--start-maximized");
			options.addArguments("--window-size=1920,1080"); 
			options.setCapability("enableVNC", true);
			options.setCapability("enableVideo", false);
			return new RemoteWebDriver(ConfigFactory.getConfig().selenoidGrid(),options);	
	}
}
