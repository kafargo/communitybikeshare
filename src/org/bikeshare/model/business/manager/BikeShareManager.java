package org.bikeshare.model.business.manager;

import org.bikeshare.model.business.exception.ServiceLoadException;
import org.bikeshare.model.domain.TripComposite;
import org.bikeshare.model.services.exceptions.RiderCheckoutException;
import org.bikeshare.model.services.factory.ServiceFactory;
import org.bikeshare.model.services.loginservice.ILoginService;
import org.bikeshare.model.services.riderservice.IRiderService;

public class BikeShareManager extends ManagerSuperType {

    private static BikeShareManager _instance;

    /**
     * keep the constructor private to prevent instantiation by outside callers.
     */
    private BikeShareManager() {
        // construct object . . .
    }

    /**
     * Assures that there is only one BikeShareManager created.
     *
     * @return BikeShareManager instance
     */
    public static synchronized BikeShareManager getInstance() {
        if (_instance == null) {
            _instance = new BikeShareManager();
        }
        return _instance;
    }

    /**
     * Generic method that all clients of this class can call to perform certain
     * actions.
     *
     * @param commandString
     *            Holds the service name to be invoked *
     * @param tripComposite
     *            Holds application specific domain state
     * @return false if action failed true if action is successful
     */
    @Override
    public boolean performAction(String commandString,
                                 TripComposite tripComposite) {
        boolean action = false;
        if (commandString.equals("RegisterRider")) {
            action = registerRider(IRiderService.NAME, tripComposite);
        }
        else if (commandString.equals("CheckoutBike")) {
            action = checkoutBike(IRiderService.NAME, tripComposite);
        }

        return action;
    }

    /**
     * Method delegates to the ServiceFactory to execute a service. Good part of
     * this approach is that the Manager knows the service by a string name -
     * thus achieving the decoupling effect that we so desire in the MVC
     * approach.
     *
     * @param commandString
     *            contains the service that needs to be performed
     * @param tripComposite
     *            contains the customer registration info needed
     *
     *            QUESTION TO STUDENTS: IS THIS WORTH PROPAGATING EXCEPTION TO
     *            CALLER(View/Controller), OR SHOULD IT BE HANDLED LIKE BELOW?
     *            Would propagating exception to the View/Controller in this tie
     *            Presentation Layer to Model semantics? Is that considered
     *            tight coupling?
     *
     */
    public boolean registerRider(String commandString,
                                  TripComposite tripComposite) {
        boolean isRegistered = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IRiderService iRiderService;

        try {
            iRiderService = (IRiderService) serviceFactory
                    .getService(commandString);
            isRegistered = iRiderService
                    .registerNewRider(tripComposite);
        } catch (ServiceLoadException e1) {
            System.out.println("registerRider failed");
        }

        return isRegistered;

    }

    public boolean checkoutBike(String commandString,
                                 TripComposite tripComposite) {
        boolean succcessfulCheckout = false;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IRiderService iRiderService;

        try {
            iRiderService = (IRiderService) serviceFactory
                    .getService(commandString);
            succcessfulCheckout = iRiderService
                    .checkoutBike(tripComposite);
        } catch (ServiceLoadException | RiderCheckoutException e) {
            System.out.println("checkoutBike failed");
        }

        return succcessfulCheckout;

    }


}
