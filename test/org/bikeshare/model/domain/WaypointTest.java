package org.bikeshare.model.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WaypointTest {

    @Test
    public void validateTest() {
        Waypoint waypoint = new Waypoint("test",23.987,45.1233,"COS", 10);
        assertTrue("Check for valid waypoint", waypoint.validate());
        System.out.println("Waypoint Validate Test: PASSED");
    }
}
