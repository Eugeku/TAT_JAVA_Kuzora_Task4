package com.epam.server;

import org.testng.annotations.*;
import org.testng.Assert;

/**
 * Test Class {@link ServerTest}.
 * <p>
 * Test Class ServerTest is for testing multithreading requets to server.
 * <i>This Class is a member of the {@link com.epam.server}
 * package.</i>
 */
public class ServerTest {
    /**
     * Unique server port. Using not yet implemented.
     */
    private static final int SERVER_PORT = 1;
    /**
     * Var of {@link Server} type;
     */
    private Server server;

    /**
     * BeforeClass method beforeClass.
     * <p>
     * Method creates new Server using unique {@link #SERVER_PORT} and also starts this server.
     */
    @BeforeClass
    public void beforeClass() {
        server = new Server(SERVER_PORT);
        server.serverStart();
    }

    /**
     * AfterClass method afterClass.
     * <p>
     * Method stops {@link #server} and sets it on null.
     */
    @AfterClass
    public void afterClass() {
        server.serverStop();
        server = null;
    }

    /**
     * Test method multiThreadingTest.
     * <p>
     * Method runs parallel threads and try to execute all of it as competing
     * threads. Positive result for this test will be fact of executing all
     * commands, in that case it does not matter result of each other.
     *
     * @param userIp  unique user ip
     * @param request String line with command and parameters
     */
    @Test(groups = {
            "parallelRequests"}, dataProvider = "parallelRequests", dataProviderClass = DataProviderServerTest.class)
    public void tst_multiThreadingRequestsTest(Integer userIp, String request) {
//        System.out.println(userIp + "__!!__" + server.takeRequest(userIp, request));
        server.takeRequest(userIp, request);
    }

    /**
     * Test method sequentialRequestsTest.
     * <p>
     * Method runs sequential threads and try to execute all of it.
     *
     * @param userIp   unique user ip
     * @param request  String line with command and parameters
     * @param expected String line as expected result of executing
     */
    @Test(dependsOnMethods = "tst_multiThreadingRequestsTest",
            groups = {
                    "sequentialRequests"}, dataProvider = "sequentialRequests", dataProviderClass = DataProviderServerTest.class)
    public void tst_sequentialRequestsTest(String expected, Integer userIp, String request) {
        Assert.assertEquals(server.takeRequest(userIp, request), expected);
    }
}
