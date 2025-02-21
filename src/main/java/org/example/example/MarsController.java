package org.example.example;

/**
 * The {@code MarsController} class is responsible for controlling the movement of a Mars Rover
 * on a given {@link MarsPlateau} based on a string of commands. It validates the movements
 * to ensure the rover stays within the bounds of the plateau.
 */
public class MarsController {
    /**
     * A string representing the movement commands for the Mars Rover (e.g., "LMLMR").
     */
    private final String movement;

    /**
     * The Mars Plateau on which the rover operates.
     */
    private final MarsPlateau plateau;

    /**
     * Constructs a new {@code MarsController} with the given movement commands and plateau.
     *
     * @param movement the string of movement commands
     * @param plateau  the Mars Plateau on which movements are performed
     */
    public MarsController(String movement, MarsPlateau plateau) {
        this.movement = movement;
        this.plateau = plateau;
    }

    /**
     * Processes the movement string and executes the corresponding commands on the given {@code MarsRover}.
     *
     * <p>If an invalid command is encountered, an {@link IllegalStateException} is thrown.
     *
     * @param marsRover the Mars Rover to move based on the movement string
     * @throws IllegalStateException if an invalid command is found in the movement string
     */
    public void convertStringMovement(MarsRover marsRover) {
        for (int i = 0; i < movement.length(); i++) {
            switch (movement.charAt(i)) {
                //'L' - Turn the rover left (counterclockwise).
                case 'L' -> marsRover.setOrientation(marsRover.getOrientation().previous());
                //'R' - Turn the rover right (clockwise).
                case 'R' -> marsRover.setOrientation(marsRover.getOrientation().next());
                //'M' - Move the rover one step forward in the current direction.
                case 'M' -> updateCoords(marsRover.getXcoord(), marsRover.getYcoord(), marsRover);
                default -> throw new IllegalStateException("Unexpected value: " + movement.charAt(i));
            }
        }
    }

    /**
     * Updates the coordinates of the Mars Rover based on its current orientation.
     *
     * <p>The method validates that the rover does not move out of the bounds of the plateau.
     * If the movement causes the rover to exceed the plateau boundaries, an
     * {@link IllegalArgumentException} is thrown.
     * @param xcoord    the current X-coordinate of the Mars Rover
     * @param ycoord    the current Y-coordinate of the Mars Rover
     * @param marsRover the Mars Rover whose coordinates are being updated
     * @throws IllegalArgumentException if the new coordinates are out of the plateau bounds
     */
    public void updateCoords(Integer xcoord, Integer ycoord, MarsRover marsRover) {
        switch (marsRover.getOrientation()) {
            //North ('N'): Increment the Y-coordinate.
            case Orientation.N -> {
                if (ycoord + 1 <= plateau.length()) {
                    marsRover.setXcoord(xcoord);
                    marsRover.setYcoord(ycoord + 1);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }
            }
            //South ('S'): Decrement the Y-coordinate.
            case Orientation.S -> {
                if (ycoord - 1 >= 0) {
                    marsRover.setXcoord(xcoord);
                    marsRover.setYcoord(ycoord - 1);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }
            }
            //East ('E'): Increment the X-coordinate.
            case Orientation.E -> {
                if (xcoord + 1 <= plateau.width()) {
                    marsRover.setXcoord(xcoord + 1);
                    marsRover.setYcoord(ycoord);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }
            }
            //West ('W'): Decrement the X-coordinate.
            case Orientation.W -> {
                if (xcoord - 1 >= 0) {
                    marsRover.setXcoord(xcoord - 1);
                    marsRover.setYcoord(ycoord);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }
            }
        }
    }
}
