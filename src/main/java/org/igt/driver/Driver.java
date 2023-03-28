package org.igt.driver;

import java.util.Objects;
import org.igt.configfactory.ConfigFactory;
import org.igt.driver.entity.DriverData;
import org.igt.driverfactory.DriverFactory;
import org.igt.enums.MobileOSType;
import org.openqa.selenium.WebDriver;

/**
 * Driver management for web, mobile and desktop based on configuration values passed from property file 
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WebDriver
 */
public class Driver {
	/**
	 * Web driver initialization based on execution type and remote run mode values.
	 * Mar 1, 2023
	 * 
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see WebDriver
	 * @see DriverManager
	 */
	public static void initDriverForWeb() {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverData driverdata = DriverData.builder().browserType(ConfigFactory.getConfig().browser())
					.browserRemoteRunMode(ConfigFactory.getConfig().browserRemoteMode())
					.runModeType(ConfigFactory.getConfig().browserRunMode()).build();
			WebDriver driver = DriverFactory.getDriverForWeb(driverdata);
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ConfigFactory.getConfig().webUrl());
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	/**
	 * Mobile driver initialization based on execution type and remote run mode
	 * values. Mar 1, 2023
	 * 
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see WebDriver
	 * @see DriverManager
	 */
	public static void initDriverForMobile(MobileOSType ostype) {
		if (Objects.isNull(DriverManager.getDriver())) {
			DriverData driverdata = DriverData.builder().mobileOSType(MobileOSType.ANDROID)
					.mobileRemoteRunMode(ConfigFactory.getConfig().mobileRemoteMode())
					.runModeType(ConfigFactory.getConfig().mobileRunMode()).build();
			WebDriver driver = DriverFactory.getDriverForMobile(driverdata);
			DriverManager.setDriver(driver);
		}
	}

	/**
	 * Desktop driver initialization based on execution type and remote run mode
	 * values. Mar 1, 2023
	 * 
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see DriverFactory
	 * @see DriverManager
	 */
	public static void initDriverForDesktop() {
		if (Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver = DriverFactory.getDriverForDesktopApp(ConfigFactory.getConfig().desktopRunMode());
			DriverManager.setDriver(driver);
		}
	}

	/**
	 * Driver quit method and unloading from thread. Mar 1, 2023
	 * 
	 * @author Mandeep Sheoran
	 * @version 1.0
	 * @see DriverManager
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
