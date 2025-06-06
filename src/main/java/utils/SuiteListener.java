package utils;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListener implements ITestListener, IAnnotationTransformer {

    private static final Logger logger = LogManager.getLogger(SuiteListener.class);

    @Override
    public void onTestFailure(ITestResult result) {
        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
                + result.getMethod().getMethodName();
        File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(file, new File(fileName + ".png"));
        } catch (IOException e) {
            logger.error("An error occurred:");
            logger.error(e.toString());
        }
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
