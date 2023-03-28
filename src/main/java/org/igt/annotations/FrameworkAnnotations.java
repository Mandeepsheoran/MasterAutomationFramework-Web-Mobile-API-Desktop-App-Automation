package org.igt.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.igt.enums.CategoryType;
import org.igt.enums.TestType;
import org.igt.enums.MobileOSType;


/**
 * Annotation interface to create custom annotations to display these values in Extent Report.
 * Mar 14, 2023
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface FrameworkAnnotations {
	String[] author() default "Mandeep Sheoran";
	CategoryType category() default CategoryType.REGRESSION;
	TestType baseType();
}
