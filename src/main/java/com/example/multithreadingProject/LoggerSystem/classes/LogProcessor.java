package com.example.multithreadingProject.LoggerSystem.classes;

public abstract class LogProcessor {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR = 3;

    private final LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    public void log(int logLevel, String message) {
        if (nextLogProcessor != null) {
            nextLogProcessor.log(logLevel, message);
        }
    }
}
