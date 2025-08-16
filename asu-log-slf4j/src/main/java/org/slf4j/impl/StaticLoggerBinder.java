package org.slf4j.impl;

import me.asu.log.Log;
import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

    public static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

    private final ILoggerFactory factory = new MinlogLoggerFactory();

    private StaticLoggerBinder() {
        // 允许用系统属性控制 minlog 级别：-Dminlog.level=TRACE|DEBUG|INFO|WARN|ERROR|NONE
        String level = System.getProperty("minlog.level");
        if (level != null) {
            Log.set(toMinlogLevel(level));
        }
    }

    private static int toMinlogLevel(String s) {
        s = s.trim().toUpperCase();
        if ("TRACE".equals(s)) return Log.LEVEL_TRACE;
        if ("DEBUG".equals(s)) return Log.LEVEL_DEBUG;
        if ("INFO".equals(s))  return Log.LEVEL_INFO;
        if ("WARN".equals(s))  return Log.LEVEL_WARN;
        if ("ERROR".equals(s)) return Log.LEVEL_ERROR;
        if ("NONE".equals(s))  return Log.LEVEL_NONE;
        return Log.LEVEL_INFO;
    }

    public static StaticLoggerBinder getSingleton() {
        return SINGLETON;
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return factory;
    }

    @Override
    public String getLoggerFactoryClassStr() {
        return MinlogLoggerFactory.class.getName();
    }
}
