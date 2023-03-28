package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Class to create instance for Firefox driver for local execution 
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 */
public final class FirefoxManager {
	
	private FirefoxManager() {}
	/**
	 * Method to return WebDriver instance for local execution on Firefox.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver()
		   .setup();
		return new FirefoxDriver();
	}

}
