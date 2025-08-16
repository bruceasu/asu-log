package me.asu.log.slf4j2;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class MinLoggerFactory implements ILoggerFactory {
    @Override
    public Logger getLogger(String name) {
        return new MinLogger(name);
    }
}
