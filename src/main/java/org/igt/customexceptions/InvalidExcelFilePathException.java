package org.igt.customexceptions;

/**
 * Class to declare custom exception for invalid file path.<p>
 * This will extend main custom exception class (@link FrameworkException)
 * Mar 1, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class InvalidExcelFilePathException extends FrameworkException {  
	/**
	 * Method to pass exception to parent class with custom message.
	 * @param message
	 */
	public InvalidExcelFilePathException(String message) {
		super(message);
	}
	/**
	 * Method to pass exception to parent class with custom message and throwable.
	 * @param message
	 */
	public InvalidExcelFilePathException(String message,Throwable cause) {
		super(message,cause);
	}
}
