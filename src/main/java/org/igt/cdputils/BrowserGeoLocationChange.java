package org.igt.cdputils;

import java.util.Optional;
import org.igt.driver.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.emulation.Emulation;

/**
 * Class to provide methods to change the Geo location of the browser to test certain functionalities.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Emulation
 * @see DriverManager
 */
public class BrowserGeoLocationChange extends CreateChromeDevToolsConnection{
	/**
	 * Method to provide Geo location based on latitude and longitude provided by the calling class.
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void changeGeoLocation(Number latitude, Number longitute) {
		CreateChromeDevToolsConnection.createConnection();
		devTools.send(Emulation.setGeolocationOverride(Optional.of(latitude),
		                                               Optional.of(longitute),
		                                               Optional.of(1)));	
	}
}
