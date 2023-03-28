package org.igt.driverfactory;

import org.igt.constants.FrameworkConstant;
import org.igt.driver.DriverManager;
import org.igt.enums.WaitMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Contain methods with wait time required for GUI interactions with element like click, element availability,visibility.
 * Jan 31, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see WebElement
 * @see DriverManager
 */
public class ExplicitWaitFactory { 
	/**
	 * Handling of element clickable conditions, presence and visibility check
	 * @param waitmethod
	 * @param by
	 * @return DOM element
	 * @throws InterruptedException 
	 */
	public static WebElement performExplicitWait(WaitMethods waitmethod, By by)  {
		WebElement element =null;
		if(waitmethod == WaitMethods.CLICKABLE) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstant.getExplicitwaittime())
					          .until(ExpectedConditions.elementToBeClickable(by));

		}
		else if(waitmethod == WaitMethods.PRESENCE) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element =new WebDriverWait(DriverManager.getDriver(),FrameworkConstant.getExplicitwaittime())
					.until(ExpectedConditions.presenceOfElementLocated(by));
					
		}
		else if(waitmethod == WaitMethods.VISIBLE) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element =new WebDriverWait(DriverManager.getDriver(),FrameworkConstant.getExplicitwaittime())
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitmethod == WaitMethods.HANDLESTALEELEXEC) {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			element = new WebDriverWait(DriverManager.getDriver(),FrameworkConstant.getExplicitwaittime())
			.until(d -> {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Handling StaleElementRefException");
				if(!d.findElements(by).isEmpty()) {
					DriverManager.getDriver().navigate().refresh();
				    return d.findElement(by);
				} else {
					return d.findElement(by);
				}
			       }); 
		}
		else if(waitmethod == WaitMethods.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;
	}
}
