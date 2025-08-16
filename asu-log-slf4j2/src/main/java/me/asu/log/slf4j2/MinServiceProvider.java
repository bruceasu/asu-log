package me.asu.log.slf4j2;

import org.slf4j.spi.SLF4JServiceProvider;
import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MDCAdapter;

public class MinServiceProvider implements SLF4JServiceProvider {

    private static final String REQUESTED_API_VERSION = "2.0.99"; // 必须存在

    private ILoggerFactory loggerFactory;
    private IMarkerFactory markerFactory;
    private MDCAdapter mdcAdapter;

    @Override
    public void initialize() {
        this.loggerFactory = new MinLoggerFactory();
        this.markerFactory = new BasicMarkerFactory();
        this.mdcAdapter = new BasicMDCAdapter(); // 或者 NOPMDCAdapter
    }

    @Override
    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    @Override
    public IMarkerFactory getMarkerFactory() {
        return markerFactory;
    }

    @Override
    public MDCAdapter getMDCAdapter() {
        return mdcAdapter;
    }

    @Override
    public String getRequestedApiVersion() {
        return REQUESTED_API_VERSION;
    }
}
