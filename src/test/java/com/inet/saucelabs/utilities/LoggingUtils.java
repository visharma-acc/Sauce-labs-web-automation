package com.inet.saucelabs.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtils {

	private static final Logger log= LogManager.getLogger();
	
	  public static void info(Class<?> clazz, String message) {
	        log.info(formatMessage(clazz, message));
	    }

	    public static void error(Class<?> clazz, String message) {
	        log.error(formatMessage(clazz, message));
	    }

	    private static String formatMessage(Class<?> clazz, String message) {
	        return "[" + clazz.getSimpleName() + "] " + message;
	    }
	
}
