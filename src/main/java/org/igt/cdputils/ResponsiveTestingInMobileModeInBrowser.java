package org.igt.cdputils;

import java.util.HashMap;
import java.util.Map;
import org.igt.driver.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class to provide methods to run the test in responsive mode in browser by providing different page dimensions.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see executeCdpCommand
 */
public class ResponsiveTestingInMobileModeInBrowser extends CreateChromeDevToolsConnection{	
	/**
	 * Method to send the command to Devtool with configuration values passed by calling class.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void runInResponsiveMode(String width, String height, String factor, boolean platformvalue) {
		Map<String,Object> map = new HashMap<>();
		map.put("width", width);
		map.put("height",height);
		map.put("deviceScaleFactor", factor);
		map.put("mobile", platformvalue);	
		((ChromeDriver)DriverManager.getDriver()).executeCdpCommand("Emulation.setDeviceMetricsOverride", map);
	}
}
