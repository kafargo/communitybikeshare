package org.bikeshare.view;

import org.bikeshare.view.mainjframe.MainJFrame;
import org.bikeshare.view.mainjframe.MainJFrameController;

import javax.swing.*;

/**
 * ViewDriver.java
 *
 * Driver class that starts the GUI (View) of the Community Bike Share application.
 *
 */
public class ViewDriver {
    
    /** Creates a new instance of ViewDriver */
    public ViewDriver() 
    {
     //set OS lookd and feel
       try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       }
       catch (Exception e) {
         e.printStackTrace();
       }
       // Following MVC approach here.

        //create view class
        MainJFrame mainJFrame = new MainJFrame();
       
        // Create Controller class and set the view
        MainJFrameController mainJFrameController = new MainJFrameController(mainJFrame);
        
    }
    
  /**
  * View entry point.
  *
  * @param args String[] - Arguments that can be passed to the Application
  */
 public static void main(String[] args) {
   new ViewDriver();
 }
    
}
