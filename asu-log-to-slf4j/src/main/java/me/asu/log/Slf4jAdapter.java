package me.asu.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jAdapter extends Log.Logger {
    @Override
    public void log(int level, String category, String message, Throwable ex) {
        // 如果 category 为空，就用一个默认 logger
        Logger logger = (category != null && !category.isEmpty())
                ? LoggerFactory.getLogger(category)
                : LoggerFactory.getLogger("Minlog");

        switch (level) {
            case Log.LEVEL_ERROR:
                if (ex != null) logger.error(message, ex);
                else logger.error(message);
                break;
            case Log.LEVEL_WARN:
                if (ex != null) logger.warn(message, ex);
                else logger.warn(message);
                break;
            case Log.LEVEL_INFO:
                if (ex != null) logger.info(message, ex);
                else logger.info(message);
                break;
            case Log.LEVEL_DEBUG:
                if (ex != null) logger.debug(message, ex);
                else logger.debug(message);
                break;
            default: // TRACE
                if (ex != null) logger.trace(message, ex);
                else logger.trace(message);
        }
    }
}
