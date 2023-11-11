package org.bikeshare.model.services.factory;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.services.IService;

/**
 * This factory class does a interesting operation which by taking a string name
 * of a service, creates a class equivalent of it and returns it in this classes
 * interface form.
 *
 * Important to note here that all Service classes
 * (org.bikeshare.model.services.*) implement IService interface.
 *
 * Hence, the getService method when done, instead of returning IRiderService
 * it returns a IService interface class which continues
 * the decoupling theme of MVC so the calling classes don't deal with a concrete
 * implementation class but its interface.
 *
 * Advantage of this is that the caller knows of only the interface the
 * underlying implementation can change without impacting any classes in the
 * upper tiers.
 *
 */

public class ServiceFactory {

    /**
     * This is a singleton https://www.geeksforgeeks.org/singleton-class-java/
     */
    private ServiceFactory() {
        }

        private static ServiceFactory serviceFactory = new ServiceFactory();

        public static ServiceFactory getInstance() {
            return serviceFactory;
        }

        /**
         *
         * @param serviceName
         * @return
         * @throws ServiceLoadException
         */
        public IService getService(String serviceName) throws ServiceLoadException {
            try {
                // Class is a parametrizable class. By writing Class<?>, we're declaring a Class object
                // which can be of any type (? is a wildcard).
                // Reference about Generics and Wildcards:http://docs.oracle.com/javase/tutorial/java/generics/wildcards.html
                Class<?> c = Class.forName(getImplName(serviceName));
                return (IService) c.newInstance();
            } catch (Exception excp) {
                serviceName = serviceName + " not loaded";
                throw new ServiceLoadException(serviceName);
            }
        }

        /**
         *
         * @param serviceName
         * @return
         * @throws Exception
         */
        private String getImplName(String serviceName) throws Exception {

            java.util.Properties props = new java.util.Properties();

            String propertyFileLocation = "config/application.properties";

            System.out.println("Property File Location passed : " + propertyFileLocation);
            java.io.FileInputStream fis = new java.io.FileInputStream(propertyFileLocation);

            props.load(fis);
            fis.close();
            return props.getProperty(serviceName);
        }

    }


