package org.igt.utils;

import java.net.URI;
import java.util.function.Predicate;
import org.igt.driver.DriverManager;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
/**
 * Class to provide authorization process to handle browser basic authentication alert popup.
 * April 4, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see HasAuthentication
 * @see UsernameAndPassword
 */
public class BrowserBasicAuthAlertPopup {
	/**
	 * This method will not allow the browser alert popup to display and it will authenticate it as backend process
	 * April 4, 2023
	 * @author Mandeep Sheoran
	 */
	public static void basicAuthBrowserAlert() {
		Predicate<URI> uriPredicate = uri -> uri.getHost().contains("https://the-internet.herokuapp.com/");
		((HasAuthentication) DriverManager.getDriver()).register(uriPredicate,
				UsernameAndPassword.of("admin", "admin"));
	}
}
