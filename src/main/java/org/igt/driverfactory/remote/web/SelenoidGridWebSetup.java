package org.igt.driverfactory.remote.web;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import org.igt.drivermanager.remote.web.SelenoidChromeManager;
import org.igt.drivermanager.remote.web.SelenoidEdgeManager;
import org.igt.drivermanager.remote.web.SelenoidFirefoxManager;
import org.igt.drivermanager.remote.web.SelenoidSafariManager;
import org.igt.enums.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Class to contain methods for remote web setup on SelenoidGrid platform.
 * Feb 11, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see BrowserType
 */
public class SelenoidGridWebSetup {
	
 private SelenoidGridWebSetup() {}
 
 private static final Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);

	private static final Supplier<WebDriver> chrome = SelenoidChromeManager::getDriver;
	private static final Supplier<WebDriver> firefox = SelenoidFirefoxManager::getDriver;
	private static final Supplier<WebDriver> edge = SelenoidEdgeManager::getDriver;
	private static final Supplier<WebDriver> safari = SelenoidSafariManager::getDriver;
	static {
		map.put(BrowserType.CHROME, chrome);
		map.put(BrowserType.FIREFOX, firefox);
		map.put(BrowserType.EDGE, edge);
		map.put(BrowserType.SAFARI, safari);
	}
	/**
	 * Method to get driver for SelenoidGrid based on provided browser value.
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
		 SelenoidChromeManager.getDriver();
	 } else if(browsertype == BrowserType.FIREFOX) {
		 SelenoidFirefoxManager.getDriver();
	 } else if(browsertype == BrowserType.EDGE) {
		 SelenoidEdgeManager.getDriver();
	 } else if(browsertype == BrowserType.SAFARI) {
		 SelenoidSafariManager.getDriver();
	 }
	 return driver;
 }
}
