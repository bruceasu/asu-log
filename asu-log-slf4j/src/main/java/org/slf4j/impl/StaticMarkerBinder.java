package org.slf4j.impl;

import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMarkerFactory;

public class StaticMarkerBinder {

    public static final StaticMarkerBinder SINGLETON = new StaticMarkerBinder();

    private final IMarkerFactory factory = new BasicMarkerFactory();

    public static StaticMarkerBinder getSingleton() {
        return SINGLETON;
    }

    public IMarkerFactory getMarkerFactory() {
        return factory;
    }

    public String getMarkerFactoryClassStr() {
        return BasicMarkerFactory.class.getName();
    }
}
