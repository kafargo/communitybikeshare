package org.bikeshare.model.services.exceptions;

/**
 * This is an exception for if a bike is attempted to have its usage updated to a state its already in
 */

public class BikeUsageException extends Exception{

    public BikeUsageException(final String s)
    {
        super(s);
    }
}
