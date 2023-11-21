package org.bikeshare.view.showwaypoints;


import org.bikeshare.model.business.manager.BikeShareManager;
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
    showWaypointsJFrame.getReturnButton().addActionListener(this);
       
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

    if (event.getSource().equals(showWaypointsJFrame.getReturnButton()))
      return_actionPerformed(event);
  }
  

 private void return_actionPerformed(ActionEvent event) {
  showWaypointsJFrame.setVisible(false);
  showWaypointsJFrame.dispose();
 }

  
}