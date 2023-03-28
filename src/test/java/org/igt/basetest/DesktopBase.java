package org.igt.basetest;

import org.igt.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * Class to initialize the Desktop driver before and after running any suite or class for test. 
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @see Driver
 */
public class DesktopBase {
	/**
	 * Method to provide the desktop driver instance before running any class for test.
	 * @author Mandeep Sheoran
	 */
	@BeforeClass
	public static void setUp() {
		Driver.initDriverForDesktop();
	}
	
	/**
	 * Method to provide the desktop driver instance after running any class for test.
	 * @author Mandeep Sheoran
	 */
	@AfterClass
	public static void tearDown() {
		Driver.quitDriver();;
	}

}
