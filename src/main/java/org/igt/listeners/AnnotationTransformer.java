package org.igt.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.igt.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * Implementation of TestNg Listener IAnnotationTransformer
 * Mar 21, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see IAnnotationTransformer
 */
public class AnnotationTransformer implements IAnnotationTransformer {
	/**
	 * Method to pass the test data class and set test retry.
	 * Mar 21, 2023
	 * @author Mandeep Sheoran
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethods) {
		annotation.setDataProvider("getPlayerName");
		annotation.setDataProviderClass(DataProviderUtils.class);
		annotation.setRetryAnalyzer(RetryFailedTests.class);
	}
}
