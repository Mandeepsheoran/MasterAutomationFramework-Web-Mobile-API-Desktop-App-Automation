package org.igt.basetest;

import org.igt.configfactory.ConfigFactory;
import org.igt.driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * Class to initialize the mobile driver before and after running any suite or class for test. 
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @see Driver
 */
public class MobileBase {
	/**
	 * Method to provide the mobile driver instance before running any class for test.
	 * @author Mandeep Sheoran
	 */
	@BeforeClass
	public static void setUp() {
		Driver.initDriverForMobile(ConfigFactory.getConfig().mobileBase());
	}
	
	/**
	 * Method to provide the mobile driver instance after running any class for test.
	 * @author Mandeep Sheoran
	 */
	@AfterClass
	public static void tearDown() {
		Driver.quitDriver();;
	}
}
