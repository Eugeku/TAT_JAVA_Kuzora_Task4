package com.epam.server;

import org.testng.annotations.Factory;

/**
 * Test Class {@link ServerFactory}.
 * <p>
 * Test Class ServerFactory is for testing creation, running and stopping a lot of servers.
 */
public class ServerFactory {
    private static final int RECOMMENDED_COUNT_OF_TEST_SERVERS = 10;

    @Factory
    public Object[] createNewServer() {
        Object[] result = new Object[RECOMMENDED_COUNT_OF_TEST_SERVERS];
        for (int i = 0; i < RECOMMENDED_COUNT_OF_TEST_SERVERS; i++) {
            result[i] = new ServerFactoryTest(i);
        }
        return result;
    }
}
