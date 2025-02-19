package org.example.example;

public class MarsController {
    private final String movement;

    private final MarsPlateau plateau;

    public MarsController(String movement, MarsPlateau plateau) {
        this.movement = movement;
        this.plateau = plateau;

    }


    public void convertStringMovement(MarsRover marsRover) {
        for (int i = 0; i < movement.length(); i++) {
            switch (movement.charAt(i)) {
                case 'L' -> marsRover.setOrientation(marsRover.getOrientation().previous());
                case 'R' -> marsRover.setOrientation(marsRover.getOrientation().next());
                case 'M' -> updateCoords(marsRover.getXcoord(), marsRover.getYcoord(), marsRover);

                default -> throw new IllegalStateException("Unexpected value: " + movement.charAt(i));
            }


        }
    }

    public void updateCoords(Integer xcoord, Integer ycoord, MarsRover marsRover) {
        switch (marsRover.getOrientation()) {
            case Orientation.N -> {
                if (ycoord + 1 <= plateau.length()) {
                    marsRover.setXcoord(xcoord);
                    marsRover.setYcoord(ycoord + 1);

                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }

            }
            case Orientation.S -> {
                if (ycoord - 1 >= 0) {
                    marsRover.setXcoord(xcoord);
                    marsRover.setYcoord(ycoord - 1);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }


            }
            case Orientation.E -> {
                if (xcoord + 1 <= plateau.width()) {
                    marsRover.setXcoord(xcoord + 1);
                    marsRover.setYcoord(ycoord);
                } else {
                    throw new IllegalArgumentException("Coordinates out of bounds");
                }
            }
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
