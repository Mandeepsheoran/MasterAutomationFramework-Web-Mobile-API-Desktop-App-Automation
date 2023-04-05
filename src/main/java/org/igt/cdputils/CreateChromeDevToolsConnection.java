package org.igt.cdputils;

import org.igt.driver.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

/**
 * Class to provide methods to create chrome devtool connection using existing driver instance.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see DevTools
 */
public class CreateChromeDevToolsConnection {
	static DevTools devTools;
	
	public static void createConnection() {
	    devTools = ((ChromeDriver)DriverManager.getDriver()).getDevTools();
		devTools.createSession();
	}
}
