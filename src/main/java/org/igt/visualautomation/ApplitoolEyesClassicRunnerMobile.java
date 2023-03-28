package org.igt.visualautomation;

import org.igt.configfactory.ConfigFactory;
import org.igt.driver.DriverManager;

import com.applitools.eyes.appium.Eyes;

/**
 * Class to tear up and tear down Applitools eyes for mobile application. 
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public class ApplitoolEyesClassicRunnerMobile {

	private ApplitoolEyesClassicRunnerMobile() {
	}

	private static Eyes eye;
	private static String apikey = ConfigFactory.getConfig().eyesapikey();

	/**
	 * Method to set unique eyes API key to initialize the eye instance. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void eyesSetup(String appName, String testName) {
		eye = new Eyes();
		eye.setApiKey(apikey);
		eye.setForceFullPageScreenshot(true);
		eye.open(DriverManager.getDriver(), appName, testName);
	}

	/**
	 * Method to kill the eye instance after capturing the screenshot.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void eyesTearDown() {
		eye.close();
		eye.abortIfNotClosed();
	}

	/**
	 * Method to perform visual test at specified point on mobile application. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void performVisualTest(String pageName) {
		eye.checkWindow(pageName);
	}
}
