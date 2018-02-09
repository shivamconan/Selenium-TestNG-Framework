package test_utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor,
			Method testMethod) {

        // This will set retryAnalyzer to the test methods if not set in class level
		if (testAnnotation.getRetryAnalyzer() == null) {

            testAnnotation.setRetryAnalyzer(RetryAnalyzer.class);

		}

	}

}