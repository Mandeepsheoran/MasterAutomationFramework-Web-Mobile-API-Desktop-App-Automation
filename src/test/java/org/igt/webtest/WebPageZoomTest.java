package org.igt.webtest;

import org.igt.driver.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class WebPageZoomTest {
	@Test
	public void pageZoomInZoomOutTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("document.body.style.zoom='200%';");
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='50%';");
		Thread.sleep(3000);
		js.executeScript("document.body.style.zoom='250%';");
		Thread.sleep(3000);
	}
}
