package org.igt.driverfactory.remote.web;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.igt.drivermanager.remote.web.BrowserStackChromeManager;
import org.igt.drivermanager.remote.web.BrowserStackEdgeManager;
import org.igt.drivermanager.remote.web.BrowserStackFirefoxManager;
import org.igt.drivermanager.remote.web.BrowserStackSafariManager;
import org.igt.enums.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Class to contain methods for remote web setup on BrowserStack platform.
 * Feb 11, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see BrowserType
 */
public class BrowserStackWebSetup {
	
	private BrowserStackWebSetup() {}
	
	private static final Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);
	
	private static final Supplier<WebDriver> chrome = BrowserStackChromeManager::getDriver;
	private static final Supplier<WebDriver> firefox = BrowserStackFirefoxManager::getDriver;
	private static final Supplier<WebDriver> edge = BrowserStackEdgeManager::getDriver;
	private static final Supplier<WebDriver> safari = BrowserStackSafariManager::getDriver;
	
	static {
		map.put(BrowserType.CHROME, chrome);
		map.put(BrowserType.FIREFOX,firefox);
		map.put(BrowserType.EDGE, edge);
		map.put(BrowserType.SAFARI, safari);
	}
	/**
	 * Method to get driver for BrowserStack based on provided browser value.
	 * Feb 11, 2023
	 * @author Mandeep Sheoran
	 * @see BrowserType
	 */
	public static WebDriver getDriver(BrowserType browsertype) {
		return map.get(browsertype).get();
	}
	
	
	
	
	
	
	static WebDriver driver = null;
	 public static WebDriver getDriver_Java7(BrowserType browsertype) {
		 if(browsertype == BrowserType.CHROME) {
			 BrowserStackChromeManager.getDriver();
		 } else if(browsertype == BrowserType.FIREFOX) {
			 BrowserStackFirefoxManager.getDriver();
		 } else if(browsertype == BrowserType.EDGE) {
			 BrowserStackEdgeManager.getDriver();
		 } else if(browsertype == BrowserType.SAFARI) {
			 BrowserStackSafariManager.getDriver();
		 }
		 return driver;
	 }
}
