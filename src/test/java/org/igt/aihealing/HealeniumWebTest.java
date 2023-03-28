/**
 * 
 */
package org.igt.aihealing;

import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.annotation.DisableHealing;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import static org.igt.enums.LogType.INFO;
import static org.igt.reports.FrameworkLogger.log;
import static org.assertj.core.api.Assertions.assertThat;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.driver.DriverManager;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.utils.DateFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Apr 4, 2022
 * 
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see
 */
public class HealeniumWebTest extends WebBase{


	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}

	@Test(description = "Healenium enabled test", priority = 1)
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void autoHealingTest() throws InterruptedException {
		SelfHealingDriver healdriver = SelfHealingDriver.create(DriverManager.getDriver());
		healdriver.get("http://127.0.0.1:5500/healeniumsamplepage.html");
		Thread.sleep(5000);
		healdriver.findElement(By.name("Channel Name")).sendKeys("Mandeep");
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Cats']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Birds']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Horses']")).click();
	}

	@DisableHealing
	@Test(description = "Healenium disabled test", priority = 2)
	@FrameworkAnnotations(author = "Mandeep", category = CategoryType.REGRESSION, baseType = TestType.WEB)
	public void aiHealingDisabled() throws InterruptedException {
		SelfHealingDriver healdriver = SelfHealingDriver.create(DriverManager.getDriver());
		healdriver.get("http://127.0.0.1:5500/healeniumsamplepage.html");
		healdriver.findElement(By.name("Channel Name")).sendKeys("Mandeep");
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Cats']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Birds']")).click();
		Thread.sleep(5000);
		healdriver.findElement(By.xpath("//*[@value='Horses']")).click();
	}

}
