package org.bikeshare.view.showwaypoints;


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

public class ShowWaypointsJFrameController
        implements ActionListener 
{

	private ShowWaypointsJFrame showWaypointsJFrame;
	
    /** Creates a new instance of RegisterRiderJFrameController */
    public ShowWaypointsJFrameController() {
    }

    
  public ShowWaypointsJFrameController(ShowWaypointsJFrame showWaypointsJFrame)
  {
    this.showWaypointsJFrame = showWaypointsJFrame;

    //add all the action listeners here
    showWaypointsJFrame.getOkButton().addActionListener(this);
    showWaypointsJFrame.getCancelButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(showWaypointsJFrame);
    showWaypointsJFrame.setVisible(true);
  }

  public String[] showWaypoints(){
      BikeShareManager bikeShareManager = BikeShareManager.getInstance();
      return bikeShareManager.performAction("GetWaypoints");
  }

  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside ShowWaypointsJFrameController::actionPerformed");
    
    if (event.getSource().equals(showWaypointsJFrame.getOkButton()))
     ok_actionPerformed(event);
    else if (event.getSource().equals(showWaypointsJFrame.getCancelButton()))
      cancel_actionPerformed(event);
  }
  

 private void cancel_actionPerformed(ActionEvent event) {
  showWaypointsJFrame.setVisible(false);
  showWaypointsJFrame.dispose();
 }


 private void ok_actionPerformed(ActionEvent event) {
     showWaypointsJFrame.setVisible(false);
     showWaypointsJFrame.dispose();
 }

  
}