package listeners.utils;

/**
 * Logger Class {@link Logger}.
 * <p>
 * Logger Class Logger is for logging info in different resources. Destination resource: console.
 * <i>This Class is a member of the {@link listeners.utils}
 * package.</i>
 */
public class Logger {
    /**
     * Public static method logInConsole.
     * <p>
     * Method logs info in console. Destination resource: console.
     *
     * @param logMessage logMessage
     */
    public static void logInConsole(String logMessage) {
        System.out.print(logMessage);
    }
}
