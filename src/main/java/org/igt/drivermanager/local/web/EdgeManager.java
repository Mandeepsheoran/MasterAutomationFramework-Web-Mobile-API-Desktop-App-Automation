package org.igt.drivermanager.local.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Class to create instance for Edge driver for local execution 
 * Feb 19, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @see WebDriver
 */
public final class EdgeManager {
	
	private EdgeManager() {}
	/**
	 * Method to return WebDriver instance for local execution on Edge
	 * Feb 19, 2023
	 * @author Mandeep Sheoran
	 * @version 1.0
	 */
	public static WebDriver getMSEdgeDriver() {
		WebDriverManager.edgedriver()
		  .setup();
		return new EdgeDriver();
	}

}
