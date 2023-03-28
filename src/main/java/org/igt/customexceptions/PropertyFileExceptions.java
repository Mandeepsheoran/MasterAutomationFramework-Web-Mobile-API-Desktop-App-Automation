/**
 * 
 */
package org.igt.customexceptions;

/**
 * To declare custom exception methods for property file related usage.<p> 
 * This will extend main custom exception handling class (@link FrameworkException).
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class PropertyFileExceptions extends FrameworkException {
	/**
	 * Method to pass exception to parent class with custom message.
	 * @param message
	 */
	public PropertyFileExceptions(String message) {
		super(message);
	}
	/**
	 * Method to pass exception to parent class with custom message and throwable.
	 * @param message
	 */
	public PropertyFileExceptions(String message,Throwable cause) {
		super(message,cause);
	}
}

