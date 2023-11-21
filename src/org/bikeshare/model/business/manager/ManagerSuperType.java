package org.bikeshare.model.business.manager;

import org.bikeshare.model.business.exception.PropertyFileNotFoundException;
import org.bikeshare.model.domain.TripComposite;
import org.bikeshare.model.services.manager.PropertyManager;

abstract class ManagerSuperType {

    /**
     * What you seeing below, is called a static initializer block,
     * which gets executed at the time when the class that contains it or extends it is referenced.
     *
     * What we hope to achieve in this application is that when the FleetRentalManager(which extends this class)
     * is referenced, we want the application properties to be loaded up so the properties contents are available
     * for use by all tiers under the business tier.
     *
     * Reference site on static initializer block:
     * http://www.developer.com/java/other/article.php/2238491/The-Essence-of-OOP-using-Java-Static-Initializer-Blocks.htm
     *
     */
    static
    {
        try
        {
            ManagerSuperType.loadProperties();
        }
        catch (PropertyFileNotFoundException propertyFileNotFoundException)
        {
            System.out.println ("Application Properties failed to be loaded - Application exiting...");
            System.exit(1); // since we can't load the properties and this being crucial we'll exit the application!
        }
    } // end of static initializer block

    /**
     * Generic method that all clients of this class can call to perform certain actions.
     *
     * @param commandString
     *                      Holds the service name to be invoked
     * @param tripComposite
     *                      Holds application specific domain state
     * @return
     *         false
     *              if action failed
     *         true
     *              if action is successful
     */
    public abstract boolean performAction(String commandString, TripComposite tripComposite);

    public abstract String[] performAction(String commandString);

    /**
     * Loads the property file into memory so its available for use by all tiers (business and below)
     * @throws PropertyFileNotFoundException
     *                                Properties file could bot be loaded.
     */
    public static void loadProperties () throws PropertyFileNotFoundException
    {

        //this just pulls the hard coded property file location
        //there might be better ways to do this
        String propertyFileLocation = "config/application.properties";;

        if (propertyFileLocation != null)
        {
            PropertyManager.loadProperties(propertyFileLocation);
        }
        else
        {
            System.out.println("Property file location not set. Passed in value is: " + propertyFileLocation + ".");
            throw new PropertyFileNotFoundException ("Property file location not set", null);
        }


    }

}

