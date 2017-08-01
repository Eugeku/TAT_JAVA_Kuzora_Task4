package com.epam.server;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Class {@link ServerFactoryTest}.
 * <p>
 * Test Class ServerFactoryTest is for testing creation, running and stopping a lot of servers.
 * <i>This Class is a member of the {@link com.epam.server}
 * package.</i>
 */
public class ServerFactoryTest {
    /**
     * Unique server port. Using not yet implemented.
     */
    private int serverPort;
    /**
     * Var of {@link Server} type;
     */
    private Server server;

    /**
     * Constructor ServerFactoryTest.
     * <p>
     * Sets {@link #serverPort} using parameter.
     *
     * @param port server port
     */
    ServerFactoryTest(int port) {
        this.serverPort = port;
    }

    /**
     * Test method tst_startNewServer.
     * <p>
     * Method starts new server.
     */
    @Test
    public void tst_startNewServer() {
        server = new Server(serverPort);
        Assert.assertTrue(server.serverStart());
    }

    /**
     * Test method tst_stopNewServer.
     * <p>
     * Method stops new server. There is dependency on {@link #tst_startNewServer()} method.
     */
    @Test(dependsOnMethods = "tst_startNewServer")
    public void tst_stopNewServer() {
        Assert.assertFalse(server.serverStop());
        server = null;
    }
}
