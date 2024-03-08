package git.gavinkeys.testautomation_demo.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    public static Logger getLogger(Class<?> clazz) {
        return LOGGER;
    }

    public static void logError(Class<?> clazz, String message, Throwable throwable) {
        getLogger(clazz).log(Level.SEVERE, message, throwable);
    }
}
