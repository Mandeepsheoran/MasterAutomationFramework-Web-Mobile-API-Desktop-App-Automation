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
public class PageMenuComponent {
	
	private static final String MENU = "//b[text()='%s']/parent::a";
	private static final String SUB_MENU = "//a[text()='%s']";
	
	public PageMenuComponent clickMenu(String menuname) {
		String menuxpath=String.format(MENU, menuname);
		SeleniumPageActions.waitAndClick(By.xpath(menuxpath), WaitMethods.CLICKABLE, "Menu");
		return this;
	}
	
	public AddUserComponents  clickSubMenu(String menusubname) {
		String menuxpath=String.format(SUB_MENU, menusubname);
		SeleniumPageActions.waitAndClick(By.xpath(menuxpath),WaitMethods.CLICKABLE, menusubname);
		return new AddUserComponents();
	}
}
