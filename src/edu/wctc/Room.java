package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Room class that implements serializable as interface
public class Room implements Serializable {

    //Field that creates an Array List for Wall
    private List<Wall> wallList = new ArrayList<>();

    //Constructor that creates four Wall objects
    public Room(double width, double height, double length) {

        //Wall objects for each wall
        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        //Adds objects the list of Walls.
        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    //Returns the calculated area of the room.
    public double getAreas(){
        double total = 0;

        for( Wall wall : wallList  ) {
            total += wall.getArea();
        }
        return total;
    }

    //Returns a String containing the room's area.
    @Override
    public String toString() {
        return "Room with area" + "wallList=" + getAreas();
    }

}
