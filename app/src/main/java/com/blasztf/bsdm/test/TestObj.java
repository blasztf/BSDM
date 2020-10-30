package com.blasztf.bsdm.test;

public abstract class TestObj {
    private final TestLog mLogger;

    protected TestObj(TestLog logger) {
        mLogger = logger;
    }

    protected TestLog getLogger() {
        return mLogger;
    }

    protected abstract void start();
}
