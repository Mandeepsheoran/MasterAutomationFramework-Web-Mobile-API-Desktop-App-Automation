package org.igt.pommobilepages;

import org.igt.driver.DriverManager;
import org.igt.pageactionutil.AppiumScreenActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
/**
 * POM class to hold the UI locator and respective actions for mobile screen. 
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class ViewScreen {
/**	
	public ViewScreen() {
	    PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
	  }

	  @iOSXCUITFindBy(xpath = "")
	  @AndroidFindBy(accessibility = "WebView")
	  private WebElement textboxEmail;
	**/
	
	private static final String VIEW_SCREEN_ELEMENT = "%s";
	private static final By WEB_VIEW_ANDROID = MobileBy.AccessibilityId("Views");
	
	public void clickViewScreenElement(String elementname) {
		String xpathvalue=String.format(VIEW_SCREEN_ELEMENT, elementname);
		AppiumScreenActions.scrollForMobile(WEB_VIEW_ANDROID);
		AppiumScreenActions.waitAndClick(MobileBy.AccessibilityId(xpathvalue));	
	}
}
