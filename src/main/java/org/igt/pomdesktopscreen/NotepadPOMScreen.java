package org.igt.pomdesktopscreen;

import org.igt.enums.WaitMethods;
import org.igt.pageactionutil.WinAppDriverPageActions;
import org.openqa.selenium.By;

/**
 * POM class to hold the UI locator for desktop application and respective actions.
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see WinAppDriverPageActions
 */
public class NotepadPOMScreen {	
	private static final By HELP_MENUOPTION = By.name("Help");
	private static final By ABOUT_NOTEPAD = By.name("About Notepad");
	private static final By OK_BUTTON = By.name("OK");
	
	/**
	 * Method to perform actions on help menu using available locators.
	 * Mar 6, 2023
	 * @author Mandeep.Sheoran
	 */
	public static void openHelpMenu() {
		WinAppDriverPageActions.click(HELP_MENUOPTION, WaitMethods.CLICKABLE, "Help Menu");
		WinAppDriverPageActions.click(ABOUT_NOTEPAD, WaitMethods.CLICKABLE, "About Notepad option");
		WinAppDriverPageActions.click(OK_BUTTON, WaitMethods.CLICKABLE, "Ok button");
	}
}
