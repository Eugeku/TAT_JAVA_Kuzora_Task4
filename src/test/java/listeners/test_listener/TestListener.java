package listeners.test_listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;

public class TestListener implements ITestListener {
    private static final String TEST_NAME = "Test name";
    private static final String STATUS_START_TEST = "TEST START";
    private static final String STATUS_FINISH_TEST = "TEST FINISH";
    private static final String CLASS_NAME = "Class name";
    private static final String METHOD_NAME = "Method name";
    private static final String DURATION = "Duration of executing";
    private static final String STATUS = "Status";
    private static final String STATUS_START_METHOD = "METHOD START";
    private static final String STATUS_SUCCESS_METHOD = "METHOD PASSED";
    private static final String STATUS_FAILURE_METHOD = "METHOD FAILED";
    private static final String STATUS_SKIPPED_METHOD = "METHOD SKIPPED";
    private static final String START_TIME = "Start time";
    private static final String FINISH_TIME = "Finish time";

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.printf("%s: %s; %s: %s; %s: %s\n\r", CLASS_NAME, iTestResult.getTestClass().getName(), METHOD_NAME, iTestResult.getMethod().getMethodName(), STATUS, STATUS_START_METHOD);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.printf("%s: %s; %s: %s; %s: %s ms; %s: %s\n\r", CLASS_NAME, iTestResult.getTestClass().getName(), METHOD_NAME, iTestResult.getMethod().getMethodName(), DURATION, getTimeOfExecution(iTestResult), STATUS, STATUS_SUCCESS_METHOD);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.printf("%s: %s; %s: %s; %s: %s ms; %s: %s\n\r", CLASS_NAME, iTestResult.getTestClass().getName(), METHOD_NAME, iTestResult.getMethod().getMethodName(), DURATION, getTimeOfExecution(iTestResult), STATUS, STATUS_FAILURE_METHOD);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.printf("%s: %s; %s: %s; %s: %s ms; %s: %s\n\r", CLASS_NAME, iTestResult.getTestClass().getName(), METHOD_NAME, iTestResult.getMethod().getMethodName(), DURATION, getTimeOfExecution(iTestResult), STATUS, STATUS_SKIPPED_METHOD);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.printf("%s: %s; %s: %s\n\r", TEST_NAME, iTestContext.getName(), STATUS, STATUS_START_TEST);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");
        System.out.printf("%s: %s; %s: %s; %s: %s | %s: %s\n\r",TEST_NAME, iTestContext.getName(), STATUS, STATUS_FINISH_TEST, START_TIME, dt.format(iTestContext.getStartDate()), FINISH_TIME, dt.format(iTestContext.getEndDate()));
    }

    private long getTimeOfExecution(ITestResult iTestResult) {
        long time = iTestResult.getEndMillis() - iTestResult.getStartMillis();
        return time;
    }
}
