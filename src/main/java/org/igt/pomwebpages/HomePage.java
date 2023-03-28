package org.igt.pomwebpages;

import org.igt.pageactionutil.AppiumScreenActions;

/**
 * POM class to hold the UI locator and respective actions for Web screen.  
 * Mar 6, 2023
 * @author Mandeep.Sheoran
 * @see AppiumScreenActions
 */
public class HomePage {
	
	private PageMenuComponent pagemenucomponent;
	
	public HomePage() {
		this.pagemenucomponent = new PageMenuComponent();
	}
	
	public PageMenuComponent getPageMenuComponent() {
		return pagemenucomponent;
	}
}
