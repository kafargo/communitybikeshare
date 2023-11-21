package org.bikeshare.view.showwaypoints;


/**
 * RegisterCustomerJFrame.java
 *
 * UI to capture customer registration information.
 *
 * @author  Alex.Fargo
 */
public class ShowWaypointsJFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = -685641941903021280L;

    public ShowWaypointsJFrame() {
        initComponents();

        this.setSize(170,220);
        this.setVisible(true); 
    }

 private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jList = new javax.swing.JList<>();
    jButtonReturn = new javax.swing.JButton();

    ShowWaypointsJFrameController showWaypointsJFrameController = new ShowWaypointsJFrameController(this);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Waypoints");
    setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
    getContentPane().setLayout(null);

    jPanel1.setBackground(new java.awt.Color(233, 233, 246));
    jPanel1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
    jPanel1.setLayout(null);

     jButtonReturn.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
     jButtonReturn.setText("Cancel");
     jPanel1.add(jButtonReturn);
     jButtonReturn.setBounds(40, 140, 80, 25);


    jList.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
    jList.setListData(showWaypointsJFrameController.showWaypoints());
    jPanel1.add(jList);
    jList.setBounds(30, 30, 100, 100);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(0, 0, 170, 220);

    pack();
 }

    /**
     * Returns a Rider domain object populated with user entered
     * data.
     */

 public javax.swing.JButton getReturnButton()
 {
     return jButtonReturn;
 }


 private javax.swing.JButton jButtonReturn;
 private javax.swing.JList<String> jList;
 private javax.swing.JPanel jPanel1;
    
}
