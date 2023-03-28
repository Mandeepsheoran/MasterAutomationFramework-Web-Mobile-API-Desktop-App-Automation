package org.igt.driverfactory.remote.web;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.igt.drivermanager.remote.web.BrowserStackChromeManager;
import org.igt.drivermanager.remote.web.BrowserStackEdgeManager;
import org.igt.drivermanager.remote.web.BrowserStackFirefoxManager;
import org.igt.drivermanager.remote.web.BrowserStackSafariManager;
import org.igt.drivermanager.remote.web.SeleniumGridChromeManager;
import org.igt.drivermanager.remote.web.SeleniumGridEdgeManager;
import org.igt.drivermanager.remote.web.SeleniumGridFirefoxManager;
import org.igt.drivermanager.remote.web.SeleniumGridSafariManager;
import org.igt.enums.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Class to contain methods for remote web setup on SeleniumGrid platform.
 * Feb 11, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see BrowserType
 */
public class SeleniumGridWebSetup {

	private SeleniumGridWebSetup() {
	}

	private static final Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);

	private static final Supplier<WebDriver> chrome = SeleniumGridChromeManager::getDriver;
	private static final Supplier<WebDriver> firefox = SeleniumGridFirefoxManager::getDriver;
	private static final Supplier<WebDriver> edge = SeleniumGridEdgeManager::getDriver;
	private static final Supplier<WebDriver> safari = SeleniumGridSafariManager::getDriver;

	static {
		map.put(BrowserType.CHROME, chrome);
		map.put(BrowserType.FIREFOX, firefox);
		map.put(BrowserType.EDGE, edge);
		map.put(BrowserType.SAFARI, safari);
	}
	/**
	 * Method to get driver for SeleniumGrid based on provided browser value.
	 * Feb 11, 2023
	 * @author Mandeep Sheoran
	 * @see BrowserType
	 */
	public static WebDriver getDriver(BrowserType browsertype) {
		return map.get(browsertype).get();
	}
	
	
	
	
	
	

	static WebDriver driver = null;

	public static WebDriver getDriver_Java7(BrowserType browsertype) {
		if (browsertype == BrowserType.CHROME) {
			SeleniumGridChromeManager.getDriver();
		} else if (browsertype == BrowserType.FIREFOX) {
			SeleniumGridFirefoxManager.getDriver();
		} else if (browsertype == BrowserType.EDGE) {
			SeleniumGridEdgeManager.getDriver();
		} else if (browsertype == BrowserType.SAFARI) {
			SeleniumGridSafariManager.getDriver();
		}
		return driver;

		// return browsertype == BrowserType.CHROME
		// ? SeleniumGridChromeManager.getDriver()
		// : SeleniumGridFirefoxManager.getDriver();
	}

}
