package org.bikeshare.view.registerriderjframe;


import org.bikeshare.model.business.manager.BikeShareManager;
import org.bikeshare.model.domain.Rider;
import org.bikeshare.model.domain.TripComposite;
import org.bikeshare.view.MessageDialog;
import org.bikeshare.view.Utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * RegisterRiderJFrameController.java
 *
 * Listens and handles actions generated from RegisterRiderJFrame.java
 * 
 * @author Alex.Fargo
 */

public class RegisterRiderJFrameController
        implements ActionListener 
{

	private RegisterRiderJFrame registerRiderJFrame;
	
    /** Creates a new instance of RegisterRiderJFrameController */
    public RegisterRiderJFrameController() {
    }

    
  public RegisterRiderJFrameController(RegisterRiderJFrame registerRiderJFrame)
  {
    this.registerRiderJFrame = registerRiderJFrame;

    //add all the action listeners here
    registerRiderJFrame.getOkButton().addActionListener(this);
    registerRiderJFrame.getCancelButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(registerRiderJFrame);
    registerRiderJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside RegisterRiderJFrameController::actionPerformed");
    
    if (event.getSource().equals(registerRiderJFrame.getOkButton()))
     ok_actionPerformed(event);
    else if (event.getSource().equals(registerRiderJFrame.getCancelButton()))
      cancel_actionPerformed(event);
  }
  

 private void cancel_actionPerformed(ActionEvent event) {
  registerRiderJFrame.setVisible(false);
  registerRiderJFrame.dispose();
 }


 private void ok_actionPerformed(ActionEvent event) {

      Rider rider = registerRiderJFrame.getSelectedData();
    
     TripComposite tripComposite = new TripComposite();
     tripComposite.setRider(rider);
     
 	 BikeShareManager bikeShareManager = BikeShareManager.getInstance();
 	 if (bikeShareManager != null)
 	 {	 
	 	 boolean action =  bikeShareManager.performAction("RegisterRider", tripComposite);
	     
	
	     if (action)
	     {	 
	       MessageDialog dlg = new MessageDialog( "Registration Confirmation" , "You are successfully registered!");    
	       Utils.centerWindow(dlg);
	       dlg.setModal(true);
	       dlg.show();
	       
	       // tear down registration dialog
	       registerRiderJFrame.setVisible(false);
	       registerRiderJFrame.dispose();
	
	     } 
	     else
	     {
	         MessageDialog dlg = new MessageDialog( "Registration Confirmation" , "Registration Failed. Please try back later!");    
	         Utils.centerWindow(dlg);
	         dlg.setModal(true);
	         dlg.show();
	    	 
	     }
 	 }
     else
     {
         MessageDialog dlg = new MessageDialog( "Internal Error" , "Registration Failed. Please try back later!");    
         Utils.centerWindow(dlg);
         dlg.setModal(true);
         dlg.show();
    	 
     }
 	 
 }

  
} //end class   