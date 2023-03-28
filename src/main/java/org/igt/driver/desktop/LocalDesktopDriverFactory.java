package org.igt.driver.desktop;

import org.igt.drivermanager.local.desktop.WinAppDriverManager;
import io.appium.java_client.windows.WindowsDriver;

/**
 * Class to get driver from WinAppDriver for desktop application.
 * Feb 15, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WinAppDriverManager
 */
public class LocalDesktopDriverFactory {
	
	private LocalDesktopDriverFactory() {}
	
	/**
	 * Method to initialize the Windows driver for local execution.
	 * Feb 15, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WindowsDriver getDriver() {
		return WinAppDriverManager.getDriver();
	}
}
