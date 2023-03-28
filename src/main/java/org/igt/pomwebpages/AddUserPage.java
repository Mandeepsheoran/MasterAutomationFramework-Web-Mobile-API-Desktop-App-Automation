package org.igt.pomwebpages;

import org.igt.pageactionutil.AppiumScreenActions;

/**
 * POM class to hold the UI locator and respective actions for Web screen.  
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class AddUserPage {
	
	private AddUserComponents addusercomponents;
	
	public AddUserPage() {
		this.addusercomponents = new AddUserComponents();
	}
	
	public AddUserComponents getAddUserComponents() {
		return addusercomponents;
	}
}
