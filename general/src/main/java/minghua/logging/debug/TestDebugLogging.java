package minghua.logging.debug;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDebugLogging {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestDebugLogging.class);
    @Test
    public void infoLoggingTest(){
        LOGGER.info("debug package info");
        LOGGER.debug("debug package debug");
    }
}
