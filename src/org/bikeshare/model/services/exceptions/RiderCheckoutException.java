package org.bikeshare.model.services.exceptions;

/**
 * This is an exception to catch an error where a user tries to check out a bike, but they already have a bike!
 */
public class RiderCheckoutException extends Exception{

    public RiderCheckoutException(final String s)
    {
        super(s);
    }
}
