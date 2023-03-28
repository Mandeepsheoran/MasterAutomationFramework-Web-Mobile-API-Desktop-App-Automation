package org.igt.driver.web;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;
import org.igt.drivermanager.local.web.ChromeBrowserInDocker;
import org.igt.drivermanager.local.web.ChromeManager;
import org.igt.drivermanager.local.web.EdgeBrowserInDocker;
import org.igt.drivermanager.local.web.EdgeManager;
import org.igt.drivermanager.local.web.FirefoxBrowserInDocker;
import org.igt.drivermanager.local.web.FirefoxManager;
import org.igt.drivermanager.local.web.SafariBrowserInDocker;
import org.igt.drivermanager.local.web.SafariManager;
import org.igt.enums.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Class to provide driver initialization for different browser based of value provided by calling method for local execution.
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 * @see BrowserType
 */
public class LocalWebDriverFactory {
	
	private LocalWebDriverFactory() {}
	
	private static final Map<BrowserType, Supplier<WebDriver>> map = new EnumMap<>(BrowserType.class);
	
	private static final Supplier<WebDriver> chrome = ChromeManager::getChromeDriver;
	private static final Supplier<WebDriver> firefox = FirefoxManager::getFirefoxDriver;
	private static final Supplier<WebDriver> edge = EdgeManager::getMSEdgeDriver;
	private static final Supplier<WebDriver> safari = SafariManager::getSafariDriver;
	private static final Supplier<WebDriver> chromeindocker = ChromeBrowserInDocker::getChromeDriver;
	private static final Supplier<WebDriver> firefoxindocker = FirefoxBrowserInDocker::getFirefoxDriver;
	private static final Supplier<WebDriver> edgeindocker = EdgeBrowserInDocker::getEdgeDriver;
	private static final Supplier<WebDriver> safariindocker = SafariBrowserInDocker::getSafariDriver;
	
	static {
		map.put(BrowserType.CHROME, chrome);
		map.put(BrowserType.FIREFOX, firefox);
		map.put(BrowserType.EDGE, edge); 
		map.put(BrowserType.SAFARI, safari);
		map.put(BrowserType.CHROMEINDOCKER, chromeindocker);
		map.put(BrowserType.FIREFOXINDOCKER, firefoxindocker);
		map.put(BrowserType.EDGEINDOCKER, edgeindocker);
		map.put(BrowserType.SAFARIINDOCKER, safariindocker);
	}
	
	public static WebDriver getDriver(BrowserType browsertype) {
		return map.get(browsertype).get();
	}
	
	
	static WebDriver driver =null;
	public static WebDriver getdriver_Java7(BrowserType browsertype) {
		if(browsertype == BrowserType.CHROME) {
		    driver = ChromeManager.getChromeDriver();
		} else if(browsertype == BrowserType.FIREFOX) {
		    driver = FirefoxManager.getFirefoxDriver();
		} else if(browsertype == BrowserType.EDGE) {
			driver = EdgeManager.getMSEdgeDriver();
		} else if (browsertype == BrowserType.SAFARI){
			driver = SafariManager.getSafariDriver();
		}		
		return driver;
	}
}
