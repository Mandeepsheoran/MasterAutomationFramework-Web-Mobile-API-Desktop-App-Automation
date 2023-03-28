package org.igt.pomwebpages;

import org.igt.enums.WaitMethods;
import org.igt.pageactionutil.AppiumScreenActions;
import org.igt.pageactionutil.SeleniumPageActions;
import org.openqa.selenium.By;
/**
 * POM class to hold the UI locator and respective actions for Web screen.  
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class LoginPage {
	
	private static final By USER_NAME_TEXT_BOX = By.name("username");
	private static final By PASSWORD_TEXT_BOX = By.name("password");
	private static final By LOGIN_BUTTON = By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
	
	private LoginPage setUserName(String username) {
		SeleniumPageActions.waitAndSendKeys(USER_NAME_TEXT_BOX,WaitMethods.PRESENCE, username);
		return this;
	}
	
	private LoginPage setPassword(String password) {
		SeleniumPageActions.waitAndSendKeys(PASSWORD_TEXT_BOX, WaitMethods.PRESENCE,password);
		return this;
	}
	
	private HomePage clickLogin() {
		SeleniumPageActions.waitAndClick(LOGIN_BUTTON,WaitMethods.CLICKABLE,"Login button");
		return new HomePage();
	}
	
	public HomePage loginApplication(String username, String password) {
		return setUserName(username).setPassword(password).clickLogin();
	}

	public String getPageTitle() {
		return SeleniumPageActions.getPageTitle();
	}
}
