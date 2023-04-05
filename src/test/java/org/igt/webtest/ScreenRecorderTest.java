package org.igt.webtest;

import java.lang.reflect.Method;
import org.igt.driver.DriverManager;
import org.igt.utils.MonteScreenRecorderAPI;
import org.openqa.selenium.By;

public class ScreenRecorderTest {
	
	public void recordWebPage(Method method) throws Exception {
		MonteScreenRecorderAPI.startRecord(method.getName());
		DriverManager.getDriver().get("https://the-internet.herokuapp.com/add_remove_elements/");
		Thread.sleep(5000);
		DriverManager.getDriver().findElement(By.xpath("//*[@id='content']/div/button")).click();
		DriverManager.getDriver().findElement(By.xpath("//*[@id='elements']/button")).click();
		Thread.sleep(5000);
		MonteScreenRecorderAPI.stopRecord();
	}
}
