package org.bikeshare.view.mainjframe;

import org.bikeshare.view.MessageDialog;
import org.bikeshare.view.Utils;
import org.bikeshare.view.registerriderjframe.RegisterRiderJFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * MainJFrameController.java
 *
 * Listens and handles actions generated from MainJFrame.java
 * 
 * @author Alex.Fargo
 */

public class MainJFrameController 
        implements ActionListener 
{

	private MainJFrame mainJFrame;
	
    /** Creates a new instance of MainJFrameController */
    public MainJFrameController() {
    }

    
  public MainJFrameController (MainJFrame mainJFrame)
  {
    this.mainJFrame = mainJFrame;

    //add all the action listeners here
    mainJFrame.getFileMenuItem().addActionListener(this);
    mainJFrame.getExitMenuItem().addActionListener(this);
    mainJFrame.getGetAvailableBikesButton().addActionListener(this);
    mainJFrame.getGetRegisterRiderButton().addActionListener(this);
       
    // center the frame
    Utils.centerWindow(mainJFrame);
    mainJFrame.setVisible(true);
  }

  /*
   *  (non-Javadoc)
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  public void actionPerformed(ActionEvent event) 
  {

    System.out.println ("Inside MainJFrameController::actionPerformed");
    
    if (event.getSource().equals(mainJFrame.getFileMenuItem()))
      menuSampleOpen_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getExitMenuItem()))
      menuExit_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getGetAvailableBikesButton()))
      getAvailableBikes_actionPerformed(event);
    else if (event.getSource().equals(mainJFrame.getGetRegisterRiderButton()))
      getRegisterRider_actionPerformed(event);
  }

  /**
   * Processes File Menu | Sample JMenu | Sample Menu Item action
   *
   * @param actionEvent ActionEvent
   */
  void menuSampleOpen_actionPerformed(ActionEvent actionEvent)
  {

    MessageDialog dlg = new MessageDialog( "Example", " Nothing to see here!");
    Utils.centerWindow(dlg);
    dlg.setModal(true);
    dlg.show();

  } //end menuFileOpen_actionPerformed


  /**
   * Exits the app
   */
  void menuExit_actionPerformed(ActionEvent actionEvent)
  {

      System.out.println ("You Clicked on the Exit App!");
      System.exit(1);
  }
  
  
/**
   * Processes Get Available Bikes action
   *
   * @param actionEvent ActionEvent
   */
  void getAvailableBikes_actionPerformed(ActionEvent actionEvent)
  {
     System.out.println("Inside MainJFrameController");
     MessageDialog dlg = new MessageDialog( "Bike Availability", "Not Implemented Yet!");
     Utils.centerWindow(dlg);
     dlg.setModal(true);
     dlg.show();

  } //end menuFileOpen_actionPerformed

 private void getRegisterRider_actionPerformed(ActionEvent event) {

  RegisterRiderJFrame registerRiderJFrame = new RegisterRiderJFrame();
  registerRiderJFrame.show();
 }

  
} //end class   