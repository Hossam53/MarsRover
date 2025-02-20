package org.example.example;

/**
 * The MarsRover class represents a rover on Mars, tracking its position and orientation.
 * It provides methods to set and retrieve the rover's coordinates and orientation,
 * as well as a utility to convert a character representation of orientation into an {@link Orientation} enum.
 */
public class MarsRover {
    // The x-coordinate of the Mars Rover
    private Integer xcoord;

    // The y-coordinate of the Mars Rover
    private Integer ycoord;

    // The orientation (direction) of the Mars Rover, represented as an enum
    private Orientation orientation;

    /**
     * Constructs a MarsRover object with initial coordinates and orientation.
     *
     * @param xcoord      the initial x-coordinate of the rover
     * @param ycoord      the initial y-coordinate of the rover
     * @param orientation the initial orientation of the rover, as a character ('N', 'E', 'S', 'W')
     */
    public MarsRover(Integer xcoord, Integer ycoord, char orientation) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.orientation = convertOrientation(orientation);
    }

    /**
     * Converts a character representing an orientation ('N', 'E', 'S', 'W') into the corresponding {@link Orientation} enum.
     *
     * @param orientation the character representing the orientation
     * @return the corresponding {@link Orientation} enum, or null if the character is invalid
     */
    public Orientation convertOrientation(char orientation) {
        return switch (orientation) {
            case 'N' -> Orientation.N;
            case 'S' -> Orientation.S;
            case 'E' -> Orientation.E;
            case 'W' -> Orientation.W;
            default -> null;
        };
    }

    /**
     * Provides a string representation of the MarsRover object, showing the current coordinates and orientation.
     *
     * @return a string in the format "xcoord ycoord orientation"
     */
    @Override
    public String toString() {
        return getXcoord() + " " + getYcoord() + " " + getOrientation();
    }

    /**
     * Gets the x-coordinate of the Mars Rover.
     *
     * @return the x-coordinate
     */
    public Integer getXcoord() {
        return xcoord;
    }

    /**
     * Sets the x-coordinate of the Mars Rover.
     *
     * @param xcoord the new x-coordinate
     */
    public void setXcoord(Integer xcoord) {
        this.xcoord = xcoord;
    }

    /**
     * Gets the y-coordinate of the Mars Rover.
     *
     * @return the y-coordinate
     */
    public Integer getYcoord() {
        return ycoord;
    }

    /**
     * Sets the y-coordinate of the Mars Rover.
     *
     * @param ycoord the new y-coordinate
     */
    public void setYcoord(Integer ycoord) {
        this.ycoord = ycoord;
    }

    /**
     * Gets the current orientation of the Mars Rover.
     *
     * @return the current orientation as an {@link Orientation} enum
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     * Sets the orientation of the Mars Rover.
     *
     * @param orientation the new orientation as an {@link Orientation} enum
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}

