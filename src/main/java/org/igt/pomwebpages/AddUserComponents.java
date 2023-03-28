package org.igt.pomwebpages;

import org.igt.enums.WaitMethods;
import org.igt.pageactionutil.AppiumScreenActions;
import org.igt.pageactionutil.SeleniumPageActions;
import org.igt.testdatapojo.SearchUserData;
import org.openqa.selenium.By;
/**
 * POM class to hold the UI locator and respective actions for Web screen.  
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class AddUserComponents {

	private static final By SEARCH_BUTTON = By.linkText("Search");
	private static final By USER_ROLE_DROP_DOWN = By.xpath("//label[text()='User Role']/following-sibling::select");
	private static final By STATUS_DROP_DOWN = By.xpath("//label[text()='Status']/following-sibling::select");
	private static final By EMPLOYEE_NAME_TEXT_BOX = By.xpath("//label[text()='Employee Name']/following-sibling::input");
	private static final By USER_NAME_TEXT_BOX = By.xpath("//label[text()='Username']/following-sibling::input");

	public AddUserComponents clickSearchButton() {
		SeleniumPageActions.waitAndClick(SEARCH_BUTTON, WaitMethods.CLICKABLE, "Search Button");
		return this;
	}

	private AddUserComponents  selectRole() {
		SeleniumPageActions.select(USER_ROLE_DROP_DOWN, e -> e.selectByIndex(0));
		return this;
	}

	private AddUserComponents selectStatus() {
		SeleniumPageActions.select(STATUS_DROP_DOWN, e -> e.selectByIndex(0));
		return this;
	}
	
	private AddUserComponents enterEmployeeName(String employee) {
		SeleniumPageActions.waitAndSendKeys(EMPLOYEE_NAME_TEXT_BOX, WaitMethods.PRESENCE,employee);
		return this;
	}
	
	private AddUserComponents enterUserName(String username) {
		SeleniumPageActions.waitAndSendKeys(USER_NAME_TEXT_BOX,WaitMethods.PRESENCE, username);
		return this;
	}
	
	public AddUserComponents fillSearchUserDetails(SearchUserData searchuserdata) {
		enterEmployeeName(searchuserdata.getEmployeeName())
		.enterUserName(searchuserdata.getUserName())
		.selectRole()
		.selectStatus();
		return this;
	}
}
