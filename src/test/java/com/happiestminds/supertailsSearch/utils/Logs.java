package com.happiestminds.supertailsSearch.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {
    static final Logger logger = LogManager.getLogger(Logs.class.getName());
    
    public static final String ANSI_GREEN = "\u001B[32m"; // Green color for logging
    public static final String ANSI_CYAN = "\u001B[36m"; // cyan color for info
	public static final String ANSI_YELLOW = "\u001b[33m";// sets yellow color
	public static final String ANSI_RED = "\u001B[31m";// sets red color
    public static final String ANSI_RESET = "\u001B[0m"; // Resets color in console

    public static void log(String status, String customMessage) {
        switch (status.toLowerCase()) {
            case "pass":
                logger.info(ANSI_GREEN + customMessage + ANSI_RESET);
                break;
            case "trace":
                logger.trace(ANSI_GREEN + customMessage + ANSI_RESET);
                break;
            case "info":
                logger.info(ANSI_CYAN + customMessage + ANSI_RESET);
                break;
            case "error":
                logger.error(ANSI_RED + customMessage + ANSI_RESET);
                break;
            case "warn":
                logger.warn(ANSI_YELLOW + customMessage + ANSI_RESET);
                break;
            case "fatal":
                logger.fatal(ANSI_RED + customMessage + ANSI_RESET);
                break;
            default:
                System.out.println("invalid status");
                break;
        }
    }

	
}

