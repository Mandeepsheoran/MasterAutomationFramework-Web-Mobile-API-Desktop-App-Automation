package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Base class to create instance for Edge browser to invoke the test inside running Docker instance.
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WebDriverManager
 */
public class EdgeBrowserInDocker {
	
	private EdgeBrowserInDocker() {}
	
	static EdgeOptions options;
	/**
	 * Method to launch the docker container and run the Edge browser and driver inside that container.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getEdgeDriver() {
		options = new EdgeOptions();
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
		WebDriverManager wdm = WebDriverManager.edgedriver().browserInDocker().enableVnc().enableRecording();
		wdm.capabilities(options);
		return wdm.create();
	}

}
