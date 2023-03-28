package org.igt.pageactionutil;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import org.igt.driver.DriverManager;
import org.igt.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
/**
 * Base class for mobile actions like click, swipe, sendkeys, scroll, select etc.
 * Mar 4, 2023
 * @author Mandeep Sheoran
 * @see DriverManager
 */
public class AppiumScreenActions {
	/**
	 * Method to click the mobile element passed by calling method.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void waitAndClick(By by) {
		DriverManager.getDriver().findElement(by).click();
	}
	/**
	 * Method to click the mobile element based on the platform value
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void waitAndClick(By androidBy, By iosBy) {
		By byvalue = getByValueOnMobilePlatform(androidBy, iosBy);
		DriverManager.getDriver().findElement(byvalue).click();
	}

	/**
	 * Method to type the vale provided by user in text field.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void waitAndSendKeys(By by, String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
	}
	
	/**
	 * Method to select values from dropdown on mobile screen.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void select(By by, Consumer<Select> consumer) {
		consumer.accept(new Select(DriverManager.getDriver().findElement(by)));
	}

	/**
	 * Method to provide mobile platform to perform the action
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static By getByValueOnMobilePlatform(By androidBy, By iosBy) {
		return isAndroid() ? androidBy : iosBy;
	}

	/**
	 * Function to check if the required platform is Android
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static Boolean isAndroid() {
		return DriverManager.getDriver() instanceof AndroidDriver;
	}

	/**
	 * Method to scroll on mobile screen using By locator
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void scrollForMobile(By by) {
		String previousPageSource = "";
		while (isElementNotEnabled(by) && isNotEndOfPage(previousPageSource)) {
			previousPageSource = DriverManager.getDriver().getPageSource();
			performScroll();
		}
	}

	/**
	 * Method to scroll on mobile screen using web element passed by the calling method
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void scrollForMobile(WebElement element) {
		String previousPageSource = "";
		while (isElementNotEnabled(element) && isNotEndOfPage(previousPageSource)) {
			previousPageSource = DriverManager.getDriver().getPageSource();
			performScroll();
		}
	}

	/**
	 * Method to check if user is already on last page or bottom after scrolling.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static boolean isNotEndOfPage(String previousPageSource) {
		return !previousPageSource.equals(DriverManager.getDriver().getPageSource());
	}

	/**
	 * Method to check if element is enabled on mobile screen using Web Element.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static boolean isElementNotEnabled(WebElement element) {
		try {
			return !element.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	/**
	 * Method to check if element is enabled on mobile screen using By locator.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static boolean isElementNotEnabled(By by) {
		List<WebElement> elements = DriverManager.getDriver().findElements(by);
		if (isAndroid()) {
			return elements.isEmpty();
		}
		if (!elements.isEmpty()) {
			return elements.get(0).getAttribute("visible").equalsIgnoreCase("false");
		}
		return true;
	}

	/**
	 * Method to perform scroll using height and width in screen.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static void performScroll() {
		Dimension size = DriverManager.getDriver().manage().window().getSize();
		int startX = size.getWidth() / 2;
		int endX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		int endY = (int) (size.getHeight() * 0.25);
		if (isAndroid())
			performScrollForAndroid(startX, startY, endX, endY);
		else
			performScrollForIOS(startX, startY, endX, endY);
	}

	/**
	 * Method to scroll on mobile screen for Android platform
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static void performScrollForAndroid(int startX, int startY, int endX, int endY) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
				.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
				.moveTo(PointOption.point(endX, endY)).release().perform();
	}

	/**
	 * Method to scroll on mobile screen for iOS platform
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	private static void performScrollForIOS(int startX, int startY, int endX, int endY) {
		new IOSTouchAction((PerformsTouchActions) DriverManager.getDriver()).press(PointOption.point(startX, startY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(200))).moveTo(PointOption.point(endX, endY))
				.release().perform();
	}
	
	/**
	 * Method to perform get text on mobile screen for Android and iOS.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected String getText(WebElement element) {
		return element.getText();
	}
	
	/**
	 * Method to drag and drop the element on mobile screen.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected static void dragAndDrop(WebElement source, WebElement target) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
            .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
            .moveTo(ElementOption.element(target))
            .release()
            .perform();  
		ExtentLogger.pass("Element is selected and dropped successfully to destination.");
	}
	
	/**
	 * Method to swipe the screen based on source and destination Web element.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected static void swipe(WebElement source, WebElement target) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
            .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
            .moveTo(ElementOption.element(target))
            .release()
            .perform();      
		ExtentLogger.pass("Swipe action is performed.");
	}
	
	/**
	 * Method to tap on teh screen for Android and iOS
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected static void tap(WebElement ele) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .tap(TapOptions.tapOptions().withElement(ElementOption.element(ele)))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
		ExtentLogger.pass("Tap action is performed on element.");
	}
	
	/**
	 * Method to tap on screen using provided coordinated.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected static void tapUsingCoordinates(int x, int y) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .tap(PointOption.point(x,y))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
		ExtentLogger.pass("Tap action is performed on element using provided coordinates.");
	}
	
	/**
	 * Method to perform long press any element on mobile screen.
	 * Mar 4, 2023
	 * @author Mandeep Sheoran
	 */
	protected static void longPress(WebElement names) {
		new AndroidTouchAction((PerformsTouchActions) DriverManager.getDriver())
        .longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(names)))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
        .perform();
	}
}
