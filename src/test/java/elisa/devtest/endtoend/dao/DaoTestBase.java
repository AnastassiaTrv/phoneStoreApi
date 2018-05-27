package elisa.devtest.endtoend.dao;

import elisa.devtest.endtoend.DbBootstrap;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

@Ignore
public abstract class DaoTestBase {

    /**
     * Set up db and properties for testing environment
     */
    @Before
    public void setUp() {
        System.setProperty("testDb", "true");
        System.setProperty("insertExampleData", "true");

        new DbBootstrap().bootstratp();
    }


    /**
     * Clean up testing environment
     */
    @After
    public void cleanUp() {
        new DbBootstrap().cleanUpTestDb();
    }
}
