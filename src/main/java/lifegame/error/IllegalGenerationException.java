package lifegame.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IllegalGenerationException extends RuntimeException {
    private static final Logger log = LoggerFactory.getLogger(IllegalGenerationException.class);

    public IllegalGenerationException(String message) {
        super(message);
        log.debug("음수 초기화 불가능");
    }
}
