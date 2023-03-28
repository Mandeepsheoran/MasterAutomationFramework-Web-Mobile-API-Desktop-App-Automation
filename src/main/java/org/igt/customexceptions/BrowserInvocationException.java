package org.igt.customexceptions;

/**
 * Custom exception to capture exceptions generated while invoking any browser.
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class BrowserInvocationException extends FrameworkException {

	/**
	 * Method to pass exception to parent class with custom message.
	 * @param message
	 */
	public BrowserInvocationException(String message) {
		super(message);
	}
	
	/**
	 * Method to pass exception to parent class with custom message and throwable.
	 * @param message
	 */
	public BrowserInvocationException(String message,Throwable cause) {
		super(message,cause);
	}
}
