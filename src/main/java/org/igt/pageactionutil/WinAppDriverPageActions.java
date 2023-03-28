package org.igt.pageactionutil;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.enums.LogType.INFO;
import static org.igt.reports.FrameworkLogger.log;
import java.util.function.Consumer;
import org.igt.driver.DriverManager;
import org.igt.driverfactory.ExplicitWaitFactory;
import org.igt.enums.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class WinAppDriverPageActions {
	/**
	 * Method to click on the element on desktop screen.
	 * @author Mandeep.Sheoran
	 * @see ExplicitWaitFactory
	 */
	public static void click(By by,WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).click();
		log(CONSOLEANDEXTENTINFO, elementname + " is clicked"); 
	}
	
	/**
	 * Method to type on text field on desktop screen.
	 * @author Mandeep.Sheoran
	 * @see ExplicitWaitFactory
	 */
	public static void sendkeys(By by, String value) {
		DriverManager.getDriver().findElement(by).sendKeys(value);
		log(CONSOLEANDEXTENTINFO, value + " is entered"); 
	}
	
	/**
	 * Method to wait and type on text field on desktop screen.
	 * @author Mandeep.Sheoran
	 * @see ExplicitWaitFactory
	 */
	public static void waitAndSendKeys(By by, String textbox, WaitMethods waitmethod, String elementname) {
		ExplicitWaitFactory.performExplicitWait(waitmethod, by).sendKeys(textbox);
		log(INFO, textbox +" is entered sucessfully in " +elementname); 
	}
	
	/**
	 * Method to provide enter text functionality for desktop application
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public String getText(By by, WaitMethods waitmethod, String elementname) {
		return ExplicitWaitFactory.performExplicitWait(waitmethod, by).getText();

	}
	
	/**
	 * Method to select any value from dropdown using By locator provided by user.
	 * @param by
	 * @param waitmethod
	 * @param elementname
	 */
	public static void selectDropDownUsingConsumerInterface(Consumer<Select> consumer, By by, WaitMethods waitmethod, String elementname) {
		Select select = new Select(ExplicitWaitFactory.performExplicitWait(waitmethod, by));
		consumer.accept(select);
		log(CONSOLEANDEXTENTINFO, elementname+ " is clicked"); 
	}
}
