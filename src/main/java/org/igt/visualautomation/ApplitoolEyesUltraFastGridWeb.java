package org.igt.visualautomation;

import org.igt.driver.DriverManager;
import org.openqa.selenium.By;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.*;
import com.applitools.eyes.selenium.fluent.Target;
import com.applitools.eyes.visualgrid.model.DesktopBrowserInfo;
import com.applitools.eyes.visualgrid.services.RunnerOptions;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;

/**
 * Class to tear up and tear down Applitools eyes for web application for Ultra
 * fast grid runner. Feb 1, 2023
 * 
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 */
public class ApplitoolEyesUltraFastGridWeb {

	private static EyesRunner runner;
	private static Eyes eyes;
	private static Configuration suiteConfig;
	private static BatchInfo batch;
	RectangleSize viewPortSize = new RectangleSize(1920, 1080);
	private static int concurrentSessions = 10;
	private static int viewPortWidth = 1920;
	private static int viewPortHeight = 1080;

	private ApplitoolEyesUltraFastGridWeb() {
	}

	/**
	 * Method to set unique eyes API key to initialize the eye instance for web application on UltraGrid runner. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public static void eyesSetup() {
		runner = new VisualGridRunner(new RunnerOptions().testConcurrency(concurrentSessions));
		System.out.println("Visual grid initiated");
		suiteConfig = (Configuration) new Configuration()
				.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.CHROME))
				.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.EDGE_CHROMIUM))
				.addBrowser(new DesktopBrowserInfo(viewPortWidth, viewPortHeight, BrowserType.SAFARI));
		eyes = new Eyes(runner);
		eyes.setConfiguration(suiteConfig);
		batch = new BatchInfo("Ultra-fast Grid");
		eyes.setBatch(batch);
	}

	/**
	 * Method to kill the eye instance after capturing the screenshot. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void tearDownEyes() {
		eyes.closeAsync();
		eyes.abortIfNotClosed();
		TestResultsSummary allTestResults = runner.getAllTestResults(true);
	}

	/**
	 * Method to open eyes instance by passing the active Selenium driver instance
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void openEyes(String appName, String testName) {
		eyes.open(DriverManager.getDriver(), appName, testName);
	}

	/**
	 * Method to take snapshot by passing the tag name. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void checkLayout(String tag) {
		eyes.check(tag, Target.window().layout().useDom(true).enablePatterns(true));
	}

	/**
	 * Method for strict checking on a particular region for comparison. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void checkStrictRegionAndLayoutRegion(String tag, String strictRegionLocator) {
		eyes.check(tag, Target.window().fully().layout(By.cssSelector(strictRegionLocator)).strict());
	}

	/**
	 * Method for strict visual comparison.
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void checkStrict(String tag) {
		eyes.check(tag, Target.window().strict());
	}

	/**
	 * Method to select a region on screen to restrict the capture and compare visual check. 
	 * Feb 1, 2023
	 * @author Mandeep Sheoran
	 */
	public void checkIgnoreAndLayoutRegion(String tag, String ignoreRegionLocator) {
		eyes.check(tag, Target.window().fully().ignore(By.cssSelector(ignoreRegionLocator)).layout());
	}
}
