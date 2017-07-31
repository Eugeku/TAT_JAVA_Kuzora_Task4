package listeners.suit_listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuitListener implements ISuiteListener {
    private static final String SUITE_STATUS = "Status";
    private static final String SUITE_NAME = "Suite name ";
    private static final String STATUS_START_SUITE = "SUITE START ";
    private static final String STATUS_FINISH_SUITE = "SUITE FINISH";

    @Override
    public void onStart(ISuite iSuite) {
        System.out.printf("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS, STATUS_START_SUITE);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.printf("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS, STATUS_FINISH_SUITE);
    }
}
