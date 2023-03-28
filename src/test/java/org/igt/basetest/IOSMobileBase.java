package org.igt.basetest;

import org.igt.driver.Driver;
import org.igt.enums.MobileOSType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/**
 * Class to initialize the iOS mobile driver before and after running any suite or class for test. 
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @see Driver
 */
public class IOSMobileBase {
	/**
	 * Method to provide the iOS mobile driver instance before running any class for test.
	 * @author Mandeep Sheoran
	 */
	@BeforeClass
	public static void setUp() {
		Driver.initDriverForMobile(MobileOSType.IOS);
	}
	
	/**
	 * Method to provide the iOS mobile driver instance after running any class for test.
	 * @author Mandeep Sheoran
	 */
	@AfterClass
	public static void tearDown() {
		Driver.quitDriver();;
	}

}
