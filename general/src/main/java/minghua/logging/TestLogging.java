package minghua.logging;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogging {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestLogging.class);
    @Test
    public void loggingTest(){
        LOGGER.debug("this is a {} message!", "debug");
        LOGGER.info("this is a {} message!", "info");
        LOGGER.error("this is a {} message!", "error");
    }
}
