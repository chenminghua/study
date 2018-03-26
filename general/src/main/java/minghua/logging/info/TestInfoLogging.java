package minghua.logging.info;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInfoLogging {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestInfoLogging.class);
    @Test
    public void infoLoggingTest(){
        LOGGER.info("info package info");
        LOGGER.debug("info package debug");
    }
}
