package org.bikeshare.model.services.waypointservice;

import org.bikeshare.model.domain.Waypoint;
import org.bikeshare.model.services.IService;

public interface IWaypointService extends IService {

    String NAME = "IWaypointService";
    String[] showWaypoints();
    String[] showWaypointBikes(Waypoint waypoint);
}
