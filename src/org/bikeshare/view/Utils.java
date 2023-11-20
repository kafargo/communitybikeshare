package org.bikeshare.view;

import java.awt.*;

/**
* Ideally this class should in a package under org.communitybikeshare.view
*
*/
public class Utils {

    /**
     * Centers the window
     * @param comp Component
     */
    public static void centerWindow(Component comp) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Dimension frameSize = comp.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    comp.setLocation( (screenSize.width - frameSize.width) / 2,
                     (screenSize.height - frameSize.height) / 2);
  }

}
