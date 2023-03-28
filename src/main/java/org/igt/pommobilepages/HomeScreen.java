package org.igt.pommobilepages;

import org.igt.pageactionutil.AppiumScreenActions;
import org.openqa.selenium.By;
import io.appium.java_client.MobileBy;

/**
 * POM class to hold the UI locator and respective actions for mobile screen. 
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class HomeScreen {
	
	private HomeScreen() {}
	
	private static final By VIEWS_ANDROID = MobileBy.AccessibilityId("Views");
	private static final By VIEWS_IOS = MobileBy.xpath("//*[@name='views']");
	
	public static HomeScreen getHomeScreen() {
		return new HomeScreen();
	}
	
	public ViewScreen navigateToViewScreen() {
		AppiumScreenActions.waitAndClick(VIEWS_ANDROID, VIEWS_IOS);
		return new ViewScreen();
	}

}
