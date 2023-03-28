package org.igt.pommobilepages;

import org.igt.pageactionutil.AppiumScreenActions;
import org.igt.pageactionutil.WinAppDriverPageActions;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
/**
 * POM class to hold the UI locator and respective actions for mobile screen. 
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class IosHomeScreen {

	private static final By ADD_TASK = AppiumBy.accessibilityId("plus.circle");

	private IosHomeScreen() {
	}

	public static IosHomeScreen getInstance() {
		return new IosHomeScreen();
	}

	public void addANewTask() {
		AppiumScreenActions.waitAndClick(ADD_TASK, ADD_TASK);
	}
}
