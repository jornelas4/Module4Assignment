package edu.wctc;

import java.io.Serializable;

//Wall class that implements serializable as interface
public class Wall implements Serializable {

    //Fields
    private double width;
    private double height;

    //Contructor that initializes width and height fields with it's parameters
    public Wall(double width, double height)
    {
        this.width = width;
        this.height = height;

    }

    //Returns the width field.
    public double getWidth() {
        return width;
    }

    //Returns the height field.
    public double getHeight() {
        return height;
    }

    //	Returns the calculated area of the wall.
    public double getArea() {
        double area = height * width;
        return  area;
    }
}
