package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MinlogLoggerFactory implements ILoggerFactory {

    private final ConcurrentMap<String, Logger> cache = new ConcurrentHashMap<>();

    @Override
    public Logger getLogger(String name) {
        return cache.computeIfAbsent(name, MinlogLogger::new);
    }
}
