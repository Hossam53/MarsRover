package org.example.example;

import java.util.Scanner;

public class Main {
    private static final String ENTER_PLATEAU_SIZE_PROMPT = "Enter plateau size (e.g., '5 5'):";
    private static final String ENTER_ROBOT_COORDS_PROMPT =
        "Enter robot coordinates and orientation (e.g., '1 2 N'):";
    private static final String ENTER_MOVEMENT_COMMANDS_PROMPT =
        "Enter robot movement commands (e.g., 'LMLMLMLMM'):";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get plateau dimensions
        MarsPlateau plateau = getPlateauDimensions(scanner);
        System.out.println("Plateau created: " + plateau);

        // Get initial robot coordinates and orientation
        MarsRover marsRover = getMarsRover(scanner);
        System.out.println("Rover initialized at: " + marsRover);

        // Get movement commands and process them
        processRoverCommands(scanner, plateau, marsRover);
        scanner.close();
    }

    private static MarsPlateau getPlateauDimensions(Scanner scanner) {
        while (true) {
            try {
                System.out.println(ENTER_PLATEAU_SIZE_PROMPT);
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 2) {
                    throw new IllegalArgumentException(
                        "Invalid plateau dimensions. Please use the format 'width height'.");
                }
                int length = Integer.parseInt(parts[0]);
                int height = Integer.parseInt(parts[1]);
                return new MarsPlateau(length, height);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    private static MarsRover getMarsRover(Scanner scanner) {
        while (true) {
            try {
                System.out.println(ENTER_ROBOT_COORDS_PROMPT);
                String input = scanner.nextLine();
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException(
                        "Invalid robot position. Please use the format 'x y orientation'.");
                }
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                char orientation = parts[2].charAt(0);

                return new MarsRover(x, y, orientation);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

    private static void processRoverCommands(Scanner scanner, MarsPlateau plateau,
                                             MarsRover marsRover) {
        while (true) {
            try {
                System.out.println(ENTER_MOVEMENT_COMMANDS_PROMPT);
                String commands = scanner.nextLine();

                MarsController controller = new MarsController(commands, plateau);
                controller.convertStringMovement(marsRover);

                System.out.println("Updated Rover Position: " + marsRover);
                break;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + " Try again.");
            }
        }
    }

}