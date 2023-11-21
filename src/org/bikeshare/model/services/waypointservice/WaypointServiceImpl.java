package org.bikeshare.model.services.waypointservice;

import org.bikeshare.model.domain.Waypoint;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WaypointServiceImpl implements IWaypointService {
    @Override
    public String[] showWaypoints() {

        final String DATABASE_URL = "jdbc:mysql://localhost:3306/bike_share_DB";
        final String USER = "root";
        final String PASSWORD = "P@ssw0rd";
        ArrayList<String> waypointArrayList = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT WaypointName FROM Waypoint;");
            while(rs.next())
                waypointArrayList.add(rs.getString(1));
            con.close();
        }catch(Exception e){ System.out.println(e);}

        return waypointArrayList.toArray(new String[0]);
    }

    @Override
    public String[] showWaypointBikes(Waypoint waypoint) {
        return new String[0];
    }
}
