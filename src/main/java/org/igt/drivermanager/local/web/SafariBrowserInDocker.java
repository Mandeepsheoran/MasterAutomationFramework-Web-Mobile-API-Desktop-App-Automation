package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Base class to create instance for Safari browser to invoke the test inside running Docker instance.
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WebDriverManager
 */
public class SafariBrowserInDocker {
	
	static SafariOptions options;
	/**
	 * Method to launch the docker container and run the Safari browser and driver inside that container.
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getSafariDriver() {
		options = new SafariOptions();
		options.setAcceptInsecureCerts(true);
		options.setCapability("headless", true);
		WebDriverManager wdm = WebDriverManager.safaridriver().browserInDocker().enableVnc().enableRecording();
		wdm.capabilities(options);
		return wdm.create();
	}

}
