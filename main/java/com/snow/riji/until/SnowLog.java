package com.snow.riji.until;

import android.os.SystemClock;
import android.util.Log;

public final class SnowLog {

    private static final String TAG = "kneeRehabilitation";

    /** Local flag for ERROR log level. */
    public static final boolean ERROR = true;

    /** Local flag for WARN log level. */
    public static final boolean WARN = true;

    /** Local flag for INFO log level. */
    public static final boolean INFO = true;

    /** Value of system prop for VERBOSE log level */
    public static final boolean VERBOSE = Log.isLoggable(TAG, Log.VERBOSE);

    /** Value of system prop for DEBUG log level */
    public static final boolean DEBUG = true;

    public static void e(final String tag, final String message) {
        if (ERROR) {
            Log.e(TAG, tag + ":" + message);
        }
    }

    /**
     * Log a message and an exception with ERROR level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void e(final String tag, final String message, final Throwable throwable) {
        if (ERROR) {
            Log.e(TAG, tag + ": " + message, throwable);
        }
    }

    /**
     * Log a message with WARN level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     */
    public static void w(final String tag, final String message) {
        if (WARN) {
            Log.w(TAG, tag + ": " + message);
        }
    }

    /**
     * Log an exception with WARN level.
     *
     * @param tag Used to identify the source of a log message.
     * @param throwable An exception to log
     */
    public static void w(final String tag, final Throwable throwable) {
        if (WARN) {
            Log.w(TAG, tag + ": " + throwable);
        }
    }

    /**
     * Log a message and an exception with WARN level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void w(final String tag, final String message, final Throwable throwable) {
        if (WARN) {
            Log.w(TAG, tag + ": " + message, throwable);
        }
    }

    /**
     * Log a message with INFO level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     */
    public static void i(final String tag, final String message) {
        if (INFO) {
            Log.i(TAG, tag + ": " + message);
        }
    }

    /**
     * Log a message with DEBUG level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     */
    public static void d(final String tag, final String message) {
        if (DEBUG) {
            Log.d(TAG, tag + ": " + message);
        }
    }

    /**
     * Log a message and an exception with DEBUG level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void d(final String tag, final String message, final Throwable throwable) {
        if (DEBUG) {
            Log.d(TAG, tag + ": " + message, throwable);
        }
    }

    /**
     * Log end log of the method .
     *
     * @param tag Used to identify the source of a log message.
     */
    public static void begin(final String tag) {
        if (DEBUG) {
            Log.d(TAG, tag + ": " + getMethodName() + " begin [" + SystemClock.elapsedRealtime()
                    + "]");
        }
    }

    /**
     * Log beginning log of the method .
     *
     * @param tag Used to identify the source of a log message.
     */
    public static void end(final String tag) {
        if (DEBUG) {
            long t = SystemClock.elapsedRealtime();
            Log.d(TAG, tag + ": " + getMethodName() + " end   [" + t + "]");
        }
    }

    /**
     * Log a method name in which this method is called.
     *
     * @param tag Used to identify the source of a log message.
     */
    public static void method(final String tag) {
        if (DEBUG) {
            Log.d(TAG, tag + ": " + getMethodName());
        }
    }

    /**
     * Log a message with VERBOSE level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     */
    public static void v(final String tag, final String message) {
        if (VERBOSE) {
            Log.v(TAG, tag + ": " + message);
        }
    }

    /**
     * Log a message and an exception with VERBOSE level.
     *
     * @param tag Used to identify the source of a log message.
     * @param message The message you would like logged.
     * @param throwable An exception to log
     */
    public static void v(final String tag, final String message, final Throwable throwable) {
        if (VERBOSE) {
            Log.v(TAG, tag + ": " + message, throwable);
        }
    }

    /**
     * Returns method name in which logging method is called.
     *
     * @return method name
     */
    private static String getMethodName() {
        Exception e = new Exception();
        StackTraceElement[] list = e.getStackTrace();
        String method = "";
        if (list != null && list.length > 2) {
            method = list[2].getMethodName();
        }
        return method;
    }

    /**
     * Constructor.
     */
    private SnowLog() {
    }

}
