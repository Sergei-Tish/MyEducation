import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestForLogback {
    private static final Logger logger = LoggerFactory.getLogger(TestForLogback.class);

    public static void main(String[] args) {
        logger.info("Test log from {}", TestForLogback.class.getSimpleName());
    }
}
