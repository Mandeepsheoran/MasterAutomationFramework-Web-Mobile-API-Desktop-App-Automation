package org.igt.drivermanager.local.web;

import org.igt.configfactory.ConfigFactory;
import org.igt.securityscan.OWASPZapScan;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Class to create instance for Chrome driver for local execution 
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 * @see ChromeOptions
 */
public final class ChromeManager {

	private ChromeManager() {}

	static ChromeOptions options;
	/**
	 * Method to return WebDriver instance for local chrome execution on Chrome
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getChromeDriver() {
		if ((ConfigFactory.getConfig().isZapScanRequired()).toLowerCase().equalsIgnoreCase("yes")) {
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.setAcceptInsecureCerts(true);
			options.setProxy(OWASPZapScan.setZAPScanProxy());
		} else {
			options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
		}
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}
}
