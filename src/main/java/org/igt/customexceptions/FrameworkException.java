package org.igt.customexceptions;

/**
 * Custom exception class to pass the exception to parent RuntimeException class. <p> Child exception classes will pass actual exception to this class.
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see RuntimeException
 */
@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {
	/**
	 * Method to pass exception to parent class.
	 * @param message
	 */
	public FrameworkException(String message) {
		super(message); 
	}
	/**
	 * Method to pass exception to parent class with custom message and throwable.
	 * @param message
	 */
	public FrameworkException(String message, Throwable cause) {  
		super(message,cause);
	}
}
