package org.bikeshare.model.services.exceptions;

/**
 * This is an exception to catch an error where a user tries to checkin a bike but they have no valid bike to checkin!
 */
public class RiderCheckinException extends Exception{

    public RiderCheckinException(final String s)
    {
        super(s);
    }
}
