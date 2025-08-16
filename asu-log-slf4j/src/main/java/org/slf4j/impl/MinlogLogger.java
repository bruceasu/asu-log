package org.slf4j.impl;

import me.asu.log.Log;
import org.slf4j.Logger;
import org.slf4j.Marker;

public class MinlogLogger implements Logger {

    private final String name;

    public MinlogLogger(String name) {
        this.name = (name == null || name.isEmpty()) ? "Minlog" : name;
    }

    // ---- Level enable checks ----
    @Override public boolean isTraceEnabled() { return Log.get() <= Log.LEVEL_TRACE; }
    @Override public boolean isDebugEnabled() { return Log.get() <= Log.LEVEL_DEBUG; }
    @Override public boolean isInfoEnabled()  { return Log.get() <= Log.LEVEL_INFO;  }
    @Override public boolean isWarnEnabled()  { return Log.get() <= Log.LEVEL_WARN;  }
    @Override public boolean isErrorEnabled() { return Log.get() <= Log.LEVEL_ERROR; }

    // Marker 版本同样返回上述结果（minlog 不支持 Marker，忽略）
    @Override public boolean isTraceEnabled(Marker m) { return isTraceEnabled(); }
    @Override public boolean isDebugEnabled(Marker m) { return isDebugEnabled(); }
    @Override public boolean isInfoEnabled (Marker m) { return isInfoEnabled();  }
    @Override public boolean isWarnEnabled (Marker m) { return isWarnEnabled();  }
    @Override public boolean isErrorEnabled(Marker m) { return isErrorEnabled(); }

    // ---- Trace ----
    @Override public void trace(String msg) { Log.trace(name, msg); }
    @Override public void trace(String format, Object arg) { Log.trace(name, format(format, arg)); }
    @Override public void trace(String format, Object arg1, Object arg2) { Log.trace(name, format(format, arg1, arg2)); }
    @Override public void trace(String format, Object... arguments) { Log.trace(name, format(format, arguments)); }
    @Override public void trace(String msg, Throwable t) { Log.trace(name, msg, t); }
    @Override public void trace(Marker marker, String msg) { trace(msg); }
    @Override public void trace(Marker marker, String format, Object arg) { trace(format, arg); }
    @Override public void trace(Marker marker, String format, Object arg1, Object arg2) { trace(format, arg1, arg2); }
    @Override public void trace(Marker marker, String format, Object... arguments) { trace(format, arguments); }
    @Override public void trace(Marker marker, String msg, Throwable t) { trace(msg, t); }

    // ---- Debug ----
    @Override public void debug(String msg) { Log.debug(name, msg); }
    @Override public void debug(String format, Object arg) { Log.debug(name, format(format, arg)); }
    @Override public void debug(String format, Object arg1, Object arg2) { Log.debug(name, format(format, arg1, arg2)); }
    @Override public void debug(String format, Object... arguments) { Log.debug(name, format(format, arguments)); }
    @Override public void debug(String msg, Throwable t) { Log.debug(name, msg, t); }
    @Override public void debug(Marker marker, String msg) { debug(msg); }
    @Override public void debug(Marker marker, String format, Object arg) { debug(format, arg); }
    @Override public void debug(Marker marker, String format, Object arg1, Object arg2) { debug(format, arg1, arg2); }
    @Override public void debug(Marker marker, String format, Object... arguments) { debug(format, arguments); }
    @Override public void debug(Marker marker, String msg, Throwable t) { debug(msg, t); }

    // ---- Info ----
    @Override public void info(String msg) { Log.info(name, msg); }
    @Override public void info(String format, Object arg) { Log.info(name, format(format, arg)); }
    @Override public void info(String format, Object arg1, Object arg2) { Log.info(name, format(format, arg1, arg2)); }
    @Override public void info(String format, Object... arguments) { Log.info(name, format(format, arguments)); }
    @Override public void info(String msg, Throwable t) { Log.info(name, msg, t); }
    @Override public void info(Marker marker, String msg) { info(msg); }
    @Override public void info(Marker marker, String format, Object arg) { info(format, arg); }
    @Override public void info(Marker marker, String format, Object arg1, Object arg2) { info(format, arg1, arg2); }
    @Override public void info(Marker marker, String format, Object... arguments) { info(format, arguments); }
    @Override public void info(Marker marker, String msg, Throwable t) { info(msg, t); }

    // ---- Warn ----
    @Override public void warn(String msg) { Log.warn(name, msg); }
    @Override public void warn(String format, Object arg) { Log.warn(name, format(format, arg)); }
    @Override public void warn(String format, Object... arguments) { Log.warn(name, format(format, arguments)); }
    @Override public void warn(String format, Object arg1, Object arg2) { Log.warn(name, format(format, arg1, arg2)); }
    @Override public void warn(String msg, Throwable t) { Log.warn(name, msg, t); }
    @Override public void warn(Marker marker, String msg) { warn(msg); }
    @Override public void warn(Marker marker, String format, Object arg) { warn(format, arg); }
    @Override public void warn(Marker marker, String format, Object arg1, Object arg2) { warn(format, arg1, arg2); }
    @Override public void warn(Marker marker, String format, Object... arguments) { warn(format, arguments); }
    @Override public void warn(Marker marker, String msg, Throwable t) { warn(msg, t); }

    // ---- Error ----
    @Override public void error(String msg) { Log.error(name, msg); }
    @Override public void error(String format, Object arg) { Log.error(name, format(format, arg)); }
    @Override public void error(String format, Object arg1, Object arg2) { Log.error(name, format(format, arg1, arg2)); }
    @Override public void error(String format, Object... arguments) { Log.error(name, format(format, arguments)); }
    @Override public void error(String msg, Throwable t) { Log.error(name, msg, t); }
    @Override public void error(Marker marker, String msg) { error(msg); }
    @Override public void error(Marker marker, String format, Object arg) { error(format, arg); }
    @Override public void error(Marker marker, String format, Object arg1, Object arg2) { error(format, arg1, arg2); }
    @Override public void error(Marker marker, String format, Object... arguments) { error(format, arguments); }
    @Override public void error(Marker marker, String msg, Throwable t) { error(msg, t); }

    // ---- Name ----
    @Override public String getName() { return name; }

    // ---- 简易格式化：按 SLF4J 占位符 {} 替换（简单实现，够用） ----
    private static String format(String pattern, Object... args) {
        if (pattern == null || args == null || args.length == 0) return pattern;
        StringBuilder sb = new StringBuilder();
        int start = 0, argIdx = 0, idx;
        while ((idx = pattern.indexOf("{}", start)) >= 0 && argIdx < args.length) {
            sb.append(pattern, start, idx).append(String.valueOf(args[argIdx++]));
            start = idx + 2;
        }
        sb.append(pattern.substring(start));
        return sb.toString();
    }
}
