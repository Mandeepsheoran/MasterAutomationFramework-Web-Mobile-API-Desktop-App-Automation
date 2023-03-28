package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Class to create instance for Chrome driver for local execution 
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 */
public final class SafariManager {
	
	private SafariManager() {}
	/**
	 * Method to return WebDriver instance for local execution on Safari
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getSafariDriver() {
		WebDriverManager.safaridriver().setup();
		return new SafariDriver();
	}
}
