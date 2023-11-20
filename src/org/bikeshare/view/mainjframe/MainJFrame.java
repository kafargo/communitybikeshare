package org.bikeshare.view.mainjframe;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * MainJFrame.java
 *
 * Build the main GUI for the Bike Share App
 *
 * @author  Alex.fargo
 */
public class MainJFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 3320197207777135961L;
	
	/** Creates new form MainJFrame */
    public MainJFrame() {
        initComponents();
        
        this.setSize(200,200);
        this.setVisible(true); 
    }

 private void initComponents() {

  jMenuBar = new JMenuBar();
  setJMenuBar(jMenuBar);
  jFileMenu = new JMenu();
  JMenu jSampleMenu = new JMenu();
  jSampleMenuItem = new JMenuItem();
  jExitMenuItem = new JMenuItem();
  jPanel1 = new JPanel();
  jButtonGetAvailableBikes = new JButton();
  jButtonRegisterRider = new JButton();

    // Demoing a Combo Box
     ArrayList<String> bikeList = new ArrayList<>();
     bikeList.add("Canyon");
     bikeList.add("Specialized");
     bikeList.add("Trek");
     bikeList.add("Orbea");
     bikeList.add("Canondale");

     jBikeComboBox = new JComboBox<>(bikeList.toArray(new String[0]));

  jMenuBar.setNextFocusableComponent(jFileMenu);
  jMenuBar.setOpaque(false);

  jFileMenu.setText("File");
  jFileMenu.setFont(new Font("Comic Sans MS", 1, 11));

  jSampleMenu.setText("Sample JMenu");
  jSampleMenu.setFont(new Font("Comic Sans MS", 1, 11));

  jExitMenuItem.setFont(new Font("Comic Sans MS", 1, 11));
  jExitMenuItem.setText("Exit");

  jSampleMenuItem.setFont(new Font("Comic Sans MS", 1, 11));
  jSampleMenuItem.setText("Sample Menu Item");
  jSampleMenu.add(jSampleMenuItem);

  jFileMenu.add(jSampleMenu);
  jFileMenu.add(jExitMenuItem);

  jMenuBar.add(jFileMenu);

  setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  setTitle("Community Bike Share");
  setFont(new Font("Comic Sans MS", 0, 10));
  getContentPane().setLayout(null);

  jPanel1.setBackground(new Color(225, 225, 225));
  jPanel1.setFont(new Font("Comic Sans MS", 0, 11)); // NOI18N
  jPanel1.setLayout(null);


  jButtonGetAvailableBikes.setFont(new Font("Comic Sans MS", 1, 11)); // NOI18N
  jButtonGetAvailableBikes.setText("See Available Bikes");
  jPanel1.add(jButtonGetAvailableBikes);
  jButtonGetAvailableBikes.setBounds(20, 20, 150, 25);


  jButtonRegisterRider.setFont(new Font("Comic Sans MS", 1, 11)); // NOI18N
  jButtonRegisterRider.setText("Register Rider");
  jPanel1.add(jButtonRegisterRider);
  jButtonRegisterRider.setBounds(20, 65, 150, 25);

     // Just a demo of a Combo Box
     jPanel1.add(jBikeComboBox);
     jBikeComboBox.setBounds(20, 50, 150, 150);

  getContentPane().add(jPanel1);
  jPanel1.setBounds(0,0,400,600);

  pack();
 }
    /**
     * Functions that return the Swing Items
     */
    public javax.swing.JMenuItem getFileMenuItem()
    {
        return jSampleMenuItem;
    }

    public javax.swing.JMenuItem getExitMenuItem()
    {
        return jExitMenuItem;
    }    

    public javax.swing.JButton getGetAvailableBikesButton()
    {
        return jButtonGetAvailableBikes;
    }    

    public javax.swing.JButton getGetRegisterRiderButton()
    {
        return jButtonRegisterRider;
    }

 private javax.swing.JButton jButtonGetAvailableBikes;
 private javax.swing.JButton jButtonRegisterRider;
 private javax.swing.JMenuItem jExitMenuItem;
 private javax.swing.JMenu jFileMenu;
 private javax.swing.JMenuItem jSampleMenuItem;
 private javax.swing.JMenuBar jMenuBar;
 private javax.swing.JPanel jPanel1;
 private javax.swing.JComboBox<String> jBikeComboBox;
}
