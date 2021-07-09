package com.xyz.base.common.util;

import org.slf4j.Logger;

import java.text.MessageFormat;

/**
 * 日志工具
 */
public class LoggerUtil {

    private LoggerUtil() {
    }

    public static void debug(Logger logger, String template, Object... parameters) {
        if (logger.isDebugEnabled()) {
            logger.debug(addThreadId(MessageFormat.format(template, parameters)));
        }
    }

    public static void info(Logger logger, String template, Object... parameters) {
        if (logger.isInfoEnabled()) {
            logger.info(addThreadId(MessageFormat.format(template, parameters)));
        }
    }

    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        if (logger.isWarnEnabled()) {
            logger.warn(addThreadId(MessageFormat.format(template, parameters)), e);
        }
    }

    public static void warn(Logger logger, String template, Object... parameters) {
        if (logger.isWarnEnabled()) {
            logger.warn(addThreadId(MessageFormat.format(template, parameters)));
        }
    }

    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        if (logger.isErrorEnabled()) {
            logger.error(addThreadId(MessageFormat.format(template, parameters)), e);
        }
    }

    public static void error(Logger logger, String template, Object... parameters) {
        if (logger.isErrorEnabled()) {
            logger.error(addThreadId(MessageFormat.format(template, parameters)));
        }
    }

    private static String addThreadId(String msg) {
        return "[" + Thread.currentThread().getId() + "]---" + msg;
    }
}
