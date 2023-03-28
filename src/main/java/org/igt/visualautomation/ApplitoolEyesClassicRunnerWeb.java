package org.igt.visualautomation;

import org.igt.configfactory.ConfigFactory;
import org.igt.constants.FrameworkConstant;
import org.igt.driver.DriverManager;
import org.openqa.selenium.By;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.*;
import com.applitools.eyes.selenium.fluent.Target;
/**
 * Class to tear up and tear down Applitools eyes for web application for classic runner.. 
 * Feb 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public class ApplitoolEyesClassicRunnerWeb {

	private static EyesRunner runner;
	private static Eyes eyes;

	private ApplitoolEyesClassicRunnerWeb() {}
	/**
	 * Method to set unique eyes API key to initialize the eye instance for web application on classic runner. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void eyesSetup() {
		runner = new ClassicRunner();
		eyes = new Eyes(runner);
		BatchInfo batch = new BatchInfo("Classic Runner");
		eyes.setBatch(batch);
		System.out.println("Classic runner initiated");
		eyes.setLogHandler(new FileLogger(FrameworkConstant.applitoolseyeslogs, false, true));
		String apikey = ConfigFactory.getConfig().eyesapikey();
		eyes.setApiKey("0Zh7z102BMYNslOLMs71Nyaci2P6n3o38P0ubC103q2V2Zc110");
		eyes.setStitchMode(StitchMode.CSS);
		eyes.setHideScrollbars(true);
		eyes.setHideCaret(true);
	}
	/**
	 * Method to kill the eye instance after capturing the screenshot.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void tearDownEyes() {
		eyes.closeAsync();
		eyes.abortIfNotClosed();
		TestResultsSummary allTestResults = runner.getAllTestResults(true);
	}

	/**
	 * Method to open eyes instance by passing the active Selenium driver instance
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void openEyes(String appName, String testName) {
		eyes.open(DriverManager.getDriver(), appName , testName);
	}    

	/**
	 * Method to take snapshot by passing the tag name.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void checkLayout(String tag) {
		eyes.check(tag, Target.window().layout().useDom(true).enablePatterns(true));
	}

	/**
	 * Method for strict checking on a particular region for comparison.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void checkStrictRegionAndLayoutRegion(String tag, String strictRegionLocator) {
		eyes.check(tag, Target.window().fully().layout(By.cssSelector(strictRegionLocator)).strict());
	}

	/**
	 * Method for strict visual comparison.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void checkStrict(String tag) {
		eyes.check(tag, Target.window().strict());
	}

	/**
	 * Method to select a region on screen to restrict the capture and compare visual check.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void checkIgnoreAndLayoutRegion(String tag, String ignoreRegionLocator) {
		eyes.check(tag, Target.window().fully().ignore(By.cssSelector(ignoreRegionLocator)).layout());
	}
}
