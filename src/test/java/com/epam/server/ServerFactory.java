package com.epam.server;

import org.testng.annotations.Factory;

/**
 * Test Class {@link ServerFactory}.
 * <p>
 * Test Class ServerFactory is for testing creation, running and stopping a lot of servers.
 * <i>This Class is a member of the {@link com.epam.server}
 * package.</i>
 */
public class ServerFactory {
    /**
     * Recommended number of servers.
     */
    private static final int RECOMMENDED_COUNT_OF_TEST_SERVERS = 10;

    /**
     * Test method multiThreadingTest.
     * <p>
     * Method runs parallel threads and try to execute all of it as competing
     * threads. Positive result for this test will be fact of executing all
     * commands, in that case it does not matter result of each other.
     *
     * @return Object[] with different instances of {@link ServerFactoryTest}
     */
    @Factory
    public Object[] createSomeServers() {
        Object[] result = new Object[RECOMMENDED_COUNT_OF_TEST_SERVERS];
        for (int i = 0; i < RECOMMENDED_COUNT_OF_TEST_SERVERS; i++) {
            result[i] = new ServerFactoryTest(i);
        }
        return result;
    }
}
