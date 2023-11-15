package org.bikeshare.model.domain;

import junit.framework.TestCase;
import org.junit.Test;

public class WaypointTest extends TestCase {

    public void testValidateTest() {
        Waypoint waypoint = new Waypoint("test",23.987,45.1233,"COS", 10);
        assertTrue("Check for valid waypoint", waypoint.validate());
        System.out.println("Waypoint Validate Test: PASSED");
    }
}
