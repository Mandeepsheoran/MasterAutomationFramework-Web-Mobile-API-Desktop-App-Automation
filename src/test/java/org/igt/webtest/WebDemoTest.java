package org.igt.webtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.igt.annotations.FrameworkAnnotations;
import org.igt.basetest.WebBase;
import org.igt.configfactory.ConfigFactory;
import org.igt.enums.BrowserType;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.enums.TestType;
import org.igt.pageactionutil.SeleniumPageActions;
import org.igt.pomwebpages.LoginPage;
import org.igt.reports.FrameworkLogger;
import org.igt.testdatapojo.SearchUserData;
import org.igt.utils.DateFormatUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;


public class WebDemoTest extends WebBase {
	
	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		FrameworkLogger.log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.regionalCurrentDateTimeFormat() + "]");
	}
	
	/**
	@BeforeSuite
	public void setUpData() {
		FixtureFactoryLoader.loadTemplates("org.igt.fixturesdata.template.SearchUserTemplete");
	}
	**/
	@Test(description="Web test to launch browser")
	@FrameworkAnnotations(author="Mike", category=CategoryType.SMOKE, baseType=TestType.WEB)
	public  void webTest1() {
		System.out.println("test 1 in progress");
	//	new LoginPage()
	//	      .loginApplication("Admin", "admin123")
	//	      .getPageMenuComponent().clickMenu("Admin");
		
		 //     .clickSubMenu("User Management")
		  //    .fillSearchUserDetails(searchuserdata)
		  //    .clickSearchButton();
	}
	/**
	@throws InterruptedException 
	 * @throws MalformedURLException 
	 * @DataProvider
	public List<SearchUserData> getData(){
		List<SearchUserData> data=Fixture.from(SearchUserData.class).gimme(2,"fulldata");
		return data;
	}
	**/
	
	
@Test(enabled=false)
	public  void getTextTest() throws InterruptedException, MalformedURLException {
		ChromeOptions options = new ChromeOptions();

		options.setCapability("selenoid:options", new HashMap<String, Object>() {{
		    /* How to add test badge */
		    put("name", "Test badge...");

		    /* How to set session timeout */
		    put("sessionTimeout", "15m");

		    /* How to set timezone */
		    put("env", new ArrayList<String>() {{
		        add("TZ=UTC");
		    }});

		    /* How to add "trash" button */
		    put("labels", new HashMap<String, Object>() {{
		        put("manual", "true");
		    }});

		    /* How to enable video recording */
		    put("enableVideo", false);
		}});
		

		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444"), options);

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		SeleniumPageActions.getPageTitle();
		System.out.println(SeleniumPageActions.getPageTitle());
		Thread.sleep(5000);
		SeleniumPageActions.navigateToURL("https://reqres.in");
		
	}
}
