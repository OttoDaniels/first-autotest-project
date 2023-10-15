package requesters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class TestRequester {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void testLogger() {
        LOGGER.info("Hi! This is logger.");
        LOGGER.info("First info message.");
        LOGGER.info("Second info message.");
    }
}
