package com.epam.server;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ServerFactoryTest {
    private int serverPort;
    private Server server;

    ServerFactoryTest(int port) {
        this.serverPort = port;
    }

    @Test
    public void tst_startNewServer() {
        server = new Server(serverPort);
        Assert.assertTrue(server.serverStart());
    }

    @Test(dependsOnMethods = "tst_startNewServer")
    public void tst_stopNewServer() {
        Assert.assertFalse(server.serverStop());
        server = null;
    }
}
