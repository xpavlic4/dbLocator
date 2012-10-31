package com.focusmr.dblocator.client;

/**
 * Db locator generic exception.
 */
public class DbLocatorException extends RuntimeException {
    /**
     * Forward exception.
     *
     * @param e exception
     */
    public DbLocatorException(Exception e) {
        super(e);
    }
}
