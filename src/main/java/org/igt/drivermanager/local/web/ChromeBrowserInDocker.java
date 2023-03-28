package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Base class to create instance for chrome browser to invoke the test inside running Docker instance.
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WebDriverManager
 */
public class ChromeBrowserInDocker {

	private ChromeBrowserInDocker() {} 

	static ChromeOptions options;
	/**
	 * Method to launch the docker container and run the Chrome browser and driver inside that container.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getChromeDriver() {
		options = new ChromeOptions();
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
		WebDriverManager wdm = WebDriverManager.chromedriver().browserInDocker().enableVnc().enableRecording();
		wdm.capabilities(options);
		return wdm.create();
	}
}
