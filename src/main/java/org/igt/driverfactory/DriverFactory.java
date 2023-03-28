package org.igt.driverfactory;

import org.igt.driver.desktop.LocalDesktopDriverFactory;
import org.igt.driver.desktop.RemoteDesktopDriverFactory;
import org.igt.driver.entity.DriverData;
import org.igt.driver.mobile.LocalMobileDriverFactory;
import org.igt.driver.mobile.RemoteMobileDriverFactory;
import org.igt.driver.web.LocalWebDriverFactory;
import org.igt.driver.web.RemoteWebDriverFactory;
import org.igt.enums.RunModeType;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.windows.WindowsDriver;

/**
 * Factory class to get the driver based on run mode for web, desktop and mobile platform
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 * @see driverdata
 */
public class DriverFactory {

	/**
	 * Method to check the run mode for web using driver data passed by the calling method.
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see LocalWebDriverFactory
	 * @see RemoteWebDriverFactory
	 */
	public static WebDriver getDriverForWeb(DriverData driverdata) {	
		return driverdata.getRunModeType() == RunModeType.LOCAL
				? LocalWebDriverFactory.getDriver(driverdata.getBrowserType())
				: RemoteWebDriverFactory.getDriver(driverdata.getBrowserRemoteRunMode(), driverdata.getBrowserType());
	}

	/**
	 * Method to check the run mode for mobile using driver data passed by the calling method.
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see LocalWebDriverFactory
	 * @see RemoteWebDriverFactory
	 */
	public static WebDriver getDriverForMobile(DriverData driverdata) {
		return driverdata.getRunModeType() == RunModeType.LOCAL
				? LocalMobileDriverFactory.getDriver(driverdata.getMobileOSType())
				: RemoteMobileDriverFactory.getDriver(driverdata.getMobileRemoteRunMode(),
						driverdata.getMobileOSType());
	}

	/**
	 * Method to check the run mode for desktop using RunModeType type passed by the calling method.
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see LocalWebDriverFactory
	 * @see RemoteWebDriverFactory
	 */
	public static WindowsDriver getDriverForDesktopApp(RunModeType runmode) {
		return runmode == RunModeType.LOCAL 
				? LocalDesktopDriverFactory.getDriver()
				: RemoteDesktopDriverFactory.getDriver();
	}

	public static WebDriver getDriverForWeb_Java7(DriverData driverdata) {
		if (driverdata.getRunModeType() == RunModeType.LOCAL) {
			return LocalWebDriverFactory.getDriver(driverdata.getBrowserType());
		} else {
			return RemoteWebDriverFactory.getDriver(driverdata.getBrowserRemoteRunMode(), driverdata.getBrowserType());
		}
	}

	public static WebDriver getDriverForMobile_Java7(DriverData driverdata) {
		if (driverdata.getRunModeType() == RunModeType.LOCAL) {
			return LocalMobileDriverFactory.getDriver(driverdata.getMobileOSType());
		} else {
			return RemoteMobileDriverFactory.getDriver(driverdata.getMobileRemoteRunMode(),
					driverdata.getMobileOSType());
		}
	}

}
