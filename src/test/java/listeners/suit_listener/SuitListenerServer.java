package listeners.suit_listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import static listeners.utils.Logger.logInConsole;

/**
 * Listener Class {@link SuitListenerServer}.
 * <p>
 * Listener Class SuitListenerServer is for logging start suite and stop suite.
 * <i>This Class is a member of the {@link listeners.suit_listener}
 * package.</i>
 */
public class SuitListenerServer implements ISuiteListener {
    private static final String SUITE_STATUS = "Status";
    private static final String SUITE_NAME = "Suite name";
    private static final String STATUS_START_SUITE = "SUITE START ";
    private static final String STATUS_FINISH_SUITE = "SUITE FINISH";

    /**
     * Listener method onStart.
     * <p>
     * Method logs info in console about suite starting.
     *
     * @param iSuite object of {@link ISuite} type
     */
    @Override
    public void onStart(ISuite iSuite) {
        String logMessage = String.format("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS, STATUS_START_SUITE);
        logInConsole(logMessage);
    }

    /**
     * Listener method onFinish.
     * <p>
     * Method logs info in console about suite finishing.
     *
     * @param iSuite object of {@link ISuite} type
     */
    @Override
    public void onFinish(ISuite iSuite) {
        String logMessage = String.format("%s: %s; %s: %s\n\r", SUITE_NAME, iSuite.getName(), SUITE_STATUS, STATUS_FINISH_SUITE);
        logInConsole(logMessage);
    }

    /**
     * Private method logInConsole.
     * <p>
     * Method logs info in console.
     *
     * @param logMessage logMessage
     */
}
