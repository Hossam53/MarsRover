package org.example.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter plataeu size");
        Scanner myObj = new Scanner(System.in);
        String coords = myObj.nextLine();
        char length = coords.charAt(0);
        char height = coords.charAt(2);

        MarsPlateau plateau = new MarsPlateau( (int) length - '0', (int) height  - '0');

        System.out.println(plateau.toString());

        System.out.println("Enter robot coordinates and orientation");
        myObj = new Scanner(System.in);
        coords = myObj.nextLine();
        char xcoord = coords.charAt(0);
        char ycoord = coords.charAt(2);
        char orientation = coords.charAt(4);

        MarsRover rover = new MarsRover((int) xcoord - '0',(int) ycoord - '0',orientation);

        System.out.println(rover.toString());

        System.out.println("Enter robot movement commands");

        myObj = new Scanner(System.in);

        String movement = myObj.nextLine();

        MarsController controller = new MarsController(movement);

        controller.convertStringMovement(movement,rover);

        System.out.println(rover.toString());











    }
}