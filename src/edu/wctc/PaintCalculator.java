package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//PaintCalculator class that implements serializable as interface
public class PaintCalculator implements Serializable {

    //Field that creates an Array List for Room
    private List<Room> roomList = new ArrayList<>();

    //Creates a room object and adds arguments to the list
    public void addRoom (double length, double width, double height){
        Room room = new Room(length, width, height);
        roomList.add(room);
    }

    //Returns a String containing the areas of all rooms in the list
    @Override
    public String toString() {

        System.out.println("You are viewing rooms created");
        String display = "";

        // If statement which displays if there are no rooms to be displayed
        if( roomList.isEmpty())
            return "Currently there are no rooms that need painting";

        //for each loop that can not iterate array only moves forward and displays the value of each area
        for( Room room : roomList )

        {

            display += room.getAreas() + "\n";
        }
        return display;
    }

}
