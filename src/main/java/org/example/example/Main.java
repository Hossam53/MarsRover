package org.example.example;

import java.util.Scanner;

/**
 * The Main class serves as the entry point for the Mars Rover program.
 * It allows users to interact with the program through a command-line interface,
 * providing inputs to define a plateau, initialize a rover, and execute movement commands.
 * The program validates user inputs and ensures the rover's movements respect the plateau boundaries.
 */

public class Main {
    // Prompt message to ask users for plateau size
    private static final String ENTER_PLATEAU_SIZE_PROMPT = "Enter plateau size (e.g., '5 5'):";

    // Prompt message to ask users for the initial Mars rover coordinates and orientation
    private static final String ENTER_ROBOT_COORDS_PROMPT =
            "Enter robot coordinates and orientation (e.g., '1 2 N'):";

    // Prompt message to ask users for movement commands for the Mars rover
    private static final String ENTER_MOVEMENT_COMMANDS_PROMPT =
            "Enter robot movement commands (e.g., 'LMLMLMLMM'):";

    /**
     * The main method serves as the entry point of the application.
     * It orchestrates the process of getting the plateau dimensions, initializing
     * the Mars rover, and processing user-specified movement commands.
     *
     * @param args the command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompts the user to input the plateau dimensions
        MarsPlateau plateau = getPlateauDimensions(scanner);
        System.out.println("Plateau created: " + plateau);

        // Prompts the user to input the initial coordinates and orientation of the Mars rover
        MarsRover marsRover = getMarsRover(scanner);
        System.out.println("Rover initialized at: " + marsRover);

        // Processes movement commands entered by the user
        processRoverCommands(scanner, plateau, marsRover);
        scanner.close();
    }

    /**
     * This method repeatedly prompts the user to input the Mars plateau dimensions
     * until valid input is entered. The expected format is two integers separated by a space.
     *
     * @param scanner the scanner object to read user input
     * @return a MarsPlateau object representing the width and length of the plateau
     */
    private static MarsPlateau getPlateauDimensions(Scanner scanner) {
        while (true) {
            try {
                System.out.println(ENTER_PLATEAU_SIZE_PROMPT);
                String input = scanner.nextLine();
                String[] parts = input.split(" ");

                // Ensure that exactly two parts are provided
                if (parts.length != 2) {
                    throw new IllegalArgumentException(
                            "Invalid plateau dimensions. Please use the format 'width height'.");
                }

                // Parse the inputs as integers
                int length = Integer.parseInt(parts[0]); // The plateau's width
                int height = Integer.parseInt(parts[1]); // The plateau's height
                return new MarsPlateau(length, height);
            } catch (Exception e) {
                // Show an error message and prompt the user to try again
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    /**
     * This method repeatedly prompts the user to input the Mars rover's initial position
     * and orientation until valid input is provided. The expected format is two integers
     * and a single character representing the x-coordinate, y-coordinate, and orientation.
     *
     * @param scanner the scanner object to read user input
     * @return a MarsRover object initialized with the provided coordinates and orientation
     */
    private static MarsRover getMarsRover(Scanner scanner) {
        while (true) {
            try {
                System.out.println(ENTER_ROBOT_COORDS_PROMPT);
                String input = scanner.nextLine();
                String[] parts = input.split(" ");

                // Ensure that exactly three parts are provided
                if (parts.length != 3) {
                    throw new IllegalArgumentException(
                            "Invalid robot position. Please use the format 'x y orientation'.");
                }

                // Parse the inputs as integers and a character
                int x = Integer.parseInt(parts[0]); // The x-coordinate of the rover
                int y = Integer.parseInt(parts[1]); // The y-coordinate of the rover
                char orientation = parts[2].charAt(0); // The orientation

                return new MarsRover(x, y, orientation);
            } catch (Exception e) {
                // Show an error message and prompt the user to try again
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    /**
     * This method repeatedly prompts the user to input a series of movement commands
     * for the Mars rover. It validates and processes the commands, updating the rover's position
     * and orientation.
     * @param scanner   the scanner object to read user input
     * @param plateau   the MarsPlateau object representing the boundaries of the plateau
     * @param marsRover the MarsRover object to be controlled
     */
    private static void processRoverCommands(Scanner scanner, MarsPlateau plateau,
                                             MarsRover marsRover) {
        while (true) {
            try {
                System.out.println(ENTER_MOVEMENT_COMMANDS_PROMPT);
                String commands = scanner.nextLine();

                // Create a MarsController instance to handle the movement commands
                MarsController controller = new MarsController(commands, plateau);

                // Convert and execute the movement commands for the given Mars rover
                controller.convertStringMovement(marsRover);

                // Print the rover's updated position and orientation after executing commands
                System.out.println("Updated Rover Position: " + marsRover);
                break;
            } catch (Exception e) {
                // Show an error message and prompt the user to try again
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }
}
