package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    //Fields that creates new scanner object to read in input.
    private static Scanner keyboard = new Scanner(System.in);

    //Field that brings in the Paint calculator object and initializes it
    private static PaintCalculator paintCalculator;


    public static void main(String[] args) {

        //New Paint calculator object created to bring in the Paint Calculator object
        paintCalculator = new PaintCalculator();

        // Initializes selection to 0
        int selection = 0;

        // do while loop to go through menu depending on what user selects
        do {
            printMenu();
            System.out.println("Enter selection: ");
            selection = Integer.parseInt(keyboard.nextLine());

            switch (selection){
                case 1:
                    createRoom();
                    break;
                case 2:
                    System.out.println(paintCalculator);
                    break;
                case 3:
                    readFile();
                    break;
                case 4:
                    writeFile();
                    break;
            }
        } while(selection != 5);

    }

    // Prints menu for user to view an choose
    private static void printMenu(){
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");
    }

    //Prints a prompt for the user to enter the given dimension and returns their response.
    private static double promptForDimension(String dimensionName){
        System.out.print("Enter the room's" + " " + dimensionName);
        double length = Double.parseDouble(keyboard.nextLine());
        return length;
    }

    //Prompts the user to enter length, width, and height.
    // Tells the paint calculator to add a room using given dimensions.
    private static void createRoom(){
        double length = promptForDimension("length: ");
        double width = promptForDimension("width: ");
        double height = promptForDimension("height: ");
        paintCalculator.addRoom(length, width, height);
    }

    //Reads a paint calculator object from a file and sets it to the field.
    // Using exception handling, prints an error if the file cannot be read.
    private static void readFile(){
        try (
                FileInputStream fis = new FileInputStream("paintCalculator.obj");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            paintCalculator = (PaintCalculator) ois.readObject();
            System.out.println("You read the file!");
        } catch (IOException | ClassNotFoundException e) {
            // e.printStackTrace();
            System.out.println("File can't be read.");
        }
    }

    //Writes the paint calculator field to a file.
    // Using exception handling, prints an error if the file cannot be written.
    private static void writeFile(){
        try (
                FileOutputStream fos = new FileOutputStream("paintCalculator.obj");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(paintCalculator);
            System.out.println("You wrote into file!");

        } catch (IOException e) {
            // e.printStackTrace();
            System.out.println("File can't be read.");
        }



    }
}
