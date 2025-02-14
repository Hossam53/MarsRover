package org.example.example;

public class MarsController {
    private String movement;

    public MarsController(String movement) {
        this.movement = movement;
    }



    public void convertStringMovement(String movement, MarsRover marsRover) {
        for (int i = 0; i < movement.length(); i++) {
            switch (movement.charAt(i)) {
                case 'L' -> {
                    marsRover.setOrientation(marsRover.getOrientation().previous());

                }
                case 'R' -> {
                    marsRover.setOrientation(marsRover.getOrientation().next());
                }
                case 'M' -> {
                  updateCoords(marsRover.getXcoord(), marsRover.getYcoord(), marsRover);

                }

            }



        }
    }

    public void updateCoords(Integer xcoord, Integer ycoord, MarsRover marsRover) {
      switch (marsRover.getOrientation()){
        case Orientation.N -> {
          marsRover.setXcoord(xcoord);
          marsRover.setYcoord(ycoord+1);

        }
        case Orientation.S -> {
          marsRover.setXcoord(xcoord);
          marsRover.setYcoord(ycoord-1);
        }
        case Orientation.E -> {
          marsRover.setXcoord(xcoord-1);
          marsRover.setYcoord(ycoord);
        }
        case Orientation.W -> {
          marsRover.setXcoord(xcoord+1);
          marsRover.setYcoord(ycoord);
        }
      }


    }


}
