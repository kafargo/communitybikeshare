package org.bikeshare.view.showwaypoints;


import org.bikeshare.model.domain.Rider;

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

        this.setSize(200,200);
        this.setVisible(true); 
    }

 private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jList = new javax.swing.JList<>();
    jButtonOk = new javax.swing.JButton();
    jButtonCancel = new javax.swing.JButton();

    ShowWaypointsJFrameController showWaypointsJFrameController = new ShowWaypointsJFrameController(this);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Waypoints");
    setFont(new java.awt.Font("Comic Sans MS", 0, 10)); // NOI18N
    getContentPane().setLayout(null);

    jPanel1.setBackground(new java.awt.Color(233, 233, 246));
    jPanel1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
    jPanel1.setLayout(null);

     jButtonCancel.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
     jButtonCancel.setText("Cancel");
     jPanel1.add(jButtonCancel);
     jButtonCancel.setBounds(30, 200, 80, 25);

     jButtonOk.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
     jButtonOk.setText("Ok");
     jPanel1.add(jButtonOk);
     jButtonOk.setBounds(95, 140, 100, 100);

    jList.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
    jList.setListData(showWaypointsJFrameController.showWaypoints());
    jPanel1.add(jList);
    jList.setBounds(30, 30, 100, 100);

    getContentPane().add(jPanel1);
    jPanel1.setBounds(0, 0, 120, 120);

    pack();
 }

    /**
     * Returns a Rider domain object populated with user entered
     * data.
     */

 public javax.swing.JButton getOkButton()
 {
     return jButtonOk;
 }

 public javax.swing.JButton getCancelButton()
 {
     return jButtonCancel;
 }


 private javax.swing.JButton jButtonCancel;
 private javax.swing.JButton jButtonOk;
 private javax.swing.JList<String> jList;
 private javax.swing.JPanel jPanel1;
    
}
