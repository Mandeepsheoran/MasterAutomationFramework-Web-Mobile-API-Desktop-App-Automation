package org.igt.driver.web;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import org.igt.driverfactory.remote.web.BrowserStackWebSetup;
import org.igt.driverfactory.remote.web.SeleniumGridWebSetup;
import org.igt.driverfactory.remote.web.SelenoidGridWebSetup;
import org.igt.enums.BrowserRemoteRunMode;
import org.igt.enums.BrowserType;
import org.openqa.selenium.WebDriver;

/**
 * Class to provide driver initialization for different browser based of value provided by calling method for remote execution.
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 * @see BrowserRemoteRunMode
 */
public class RemoteWebDriverFactory {
	
	private RemoteWebDriverFactory() {}
	
	private static final Map<BrowserRemoteRunMode, Function<BrowserType, WebDriver>> map 
	    = new EnumMap<>(BrowserRemoteRunMode.class);
	
	private static final Function<BrowserType, WebDriver> seleniumgrid = SeleniumGridWebSetup::getDriver;
	private static final Function<BrowserType, WebDriver> browserstack = BrowserStackWebSetup::getDriver;
	private static final Function<BrowserType, WebDriver> selenoid = SelenoidGridWebSetup::getDriver;
	private static final Function<BrowserType, WebDriver> dockergrid = SeleniumGridWebSetup::getDriver;
	private static final Function<BrowserType, WebDriver> saucelab = BrowserStackWebSetup::getDriver;
	
	static {
		map.put(BrowserRemoteRunMode.SELENIUMGRID,seleniumgrid);
		map.put(BrowserRemoteRunMode.BROWSERSTACK,browserstack);
		map.put(BrowserRemoteRunMode.SELENOID,selenoid);
		map.put(BrowserRemoteRunMode.DOCKERGRID,dockergrid);
		map.put(BrowserRemoteRunMode.SAUCELAB,saucelab);
	}
	
	public static WebDriver getDriver(BrowserRemoteRunMode remotemode, BrowserType browsertype) {
		return map.get(remotemode).apply(browsertype);
	}
	
	
	
	
	
	
	
	public static WebDriver getDriver_Java7(BrowserRemoteRunMode remotemode, BrowserType browsertype) {
		if(remotemode == BrowserRemoteRunMode.SELENIUMGRID) {
			return SeleniumGridWebSetup.getDriver(browsertype);
		} else if(remotemode == BrowserRemoteRunMode.BROWSERSTACK) {
			return BrowserStackWebSetup.getDriver(browsertype);
		} else if(remotemode == BrowserRemoteRunMode.SELENOID)	{
			return SelenoidGridWebSetup.getDriver(browsertype);
		} else if(remotemode == BrowserRemoteRunMode.DOCKERGRID)	{
			return SeleniumGridWebSetup.getDriver(browsertype);          // Not Implemented yet hence returning Selenium grid
		} else if(remotemode == BrowserRemoteRunMode.SAUCELAB)	{
			return BrowserStackWebSetup.getDriver(browsertype);        // Not yet Implemented hence returning Browserstack
		}
		return null;
	}
}
