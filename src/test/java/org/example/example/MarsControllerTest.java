package org.example.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MarsControllerTest {


  @Test
  void testConvertStringMovement_LeftTurn() {
    MarsRover marsRover = new MarsRover(0, 0, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("L", plateau);
    controller.convertStringMovement(marsRover);

    Assertions.assertEquals(Orientation.W, marsRover.getOrientation());
  }

  @Test
  void testConvertStringMovement_RightTurn() {
    MarsRover marsRover = new MarsRover(0, 0, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("R", plateau);
    controller.convertStringMovement(marsRover);

    Assertions.assertEquals(Orientation.E, marsRover.getOrientation());
  }


  @Test
  void testConvertStringMovement_MoveForward() {
    MarsRover marsRover = new MarsRover(2, 2, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);
    controller.convertStringMovement(marsRover);

    Assertions.assertEquals(2, marsRover.getXcoord());
    Assertions.assertEquals(3, marsRover.getYcoord());
  }


  @Test
  void testConvertStringMovement_IllegalCharacter_ThrowsException() {
    MarsRover marsRover = new MarsRover(0, 0, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("Z", plateau);

    Assertions.assertThrows(IllegalStateException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }


  @Test
  void testConvertStringMovement_OutOfPlateau_ThrowsException() {
    MarsRover marsRover = new MarsRover(0, 0, 'S');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }

  @Test
  void testConvertStringMovement_MultipleCommands() {
    MarsRover marsRover = new MarsRover(1, 2, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("LMLMLMLMM", plateau);
    controller.convertStringMovement(marsRover);

    Assertions.assertEquals(1, marsRover.getXcoord());
    Assertions.assertEquals(3, marsRover.getYcoord());
    Assertions.assertEquals(Orientation.N, marsRover.getOrientation());
  }

  @Test
  void testConvertStringMovement_AnotherMultipleCommands() {
    MarsRover marsRover = new MarsRover(3, 3, 'E');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("MMRMMRMRRM", plateau);
    controller.convertStringMovement(marsRover);

    Assertions.assertEquals(5, marsRover.getXcoord());
    Assertions.assertEquals(1, marsRover.getYcoord());
    Assertions.assertEquals(Orientation.E, marsRover.getOrientation());
  }

  @Test
  void testConvertStringMovement_OutOfBounds_North_ThrowsException() {
    MarsRover marsRover = new MarsRover(0, 5, 'N');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }

  @Test
  void testConvertStringMovement_OutOfBounds_South_ThrowsException() {
    MarsRover marsRover = new MarsRover(0, 0, 'S');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }

  @Test
  void testConvertStringMovement_OutOfBounds_East_ThrowsException() {
    MarsRover marsRover = new MarsRover(5, 0, 'E');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }

  @Test
  void testConvertStringMovement_OutOfBounds_West_ThrowsException() {
    MarsRover marsRover = new MarsRover(0, 0, 'W');
    MarsPlateau plateau = new MarsPlateau(5, 5);
    MarsController controller = new MarsController("M", plateau);

    Assertions.assertThrows(IllegalArgumentException.class, () -> {
      controller.convertStringMovement(marsRover);
    });
  }
}