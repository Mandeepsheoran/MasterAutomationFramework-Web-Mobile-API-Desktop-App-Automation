package org.igt.driver.mobile;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;
import org.igt.driverfactory.remote.mobile.BrowserStackMobileSetup;
import org.igt.enums.MobileOSType;
import org.igt.enums.MobileRemoteRunMode;
import org.openqa.selenium.WebDriver;

/**
 * Method to initialize the remote mobile driver factory to setup the driver based on mobile OS platform. 
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see BrowserStackMobileSetup
 */
public class RemoteMobileDriverFactory {

	private RemoteMobileDriverFactory() {}

	private static final Map<MobileRemoteRunMode, Function<MobileOSType, WebDriver>> map = new EnumMap<>(
			MobileRemoteRunMode.class);
	private static final Function<MobileOSType, WebDriver> browserstack = BrowserStackMobileSetup::getDriver;
	private static final Function<MobileOSType, WebDriver> saucelab = BrowserStackMobileSetup::getDriver;
	// Sauce Lab is yet to be implemented hence returning Browserstack for Sauce lab
	// also.
	static {
		map.put(MobileRemoteRunMode.BROWSERSTACK, browserstack);
		map.put(MobileRemoteRunMode.SAUCELAB, saucelab);
	}

	/**       
	 * Method to get driver instance based on remote mode type and mobile OS platform type .
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getDriver(MobileRemoteRunMode remotemode, MobileOSType platformtype) {
		return map.get(remotemode).apply(platformtype);
	}
}
