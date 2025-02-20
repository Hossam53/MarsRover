package org.example.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MarsControllerTest {

    // Test for left turn command "L"
    @Test
    void testConvertStringMovement_LeftTurn() {
        MarsRover marsRover = new MarsRover(0, 0, 'N'); // Initialize rover at (0, 0) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("L", plateau); // Command "L" to turn left
        controller.convertStringMovement(marsRover);

        Assertions.assertEquals(Orientation.W, marsRover.getOrientation()); // Verify orientation is West
    }

    // Test for right turn command "R"
    @Test
    void testConvertStringMovement_RightTurn() {
        MarsRover marsRover = new MarsRover(0, 0, 'N'); // Initialize rover at (0, 0) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("R", plateau); // Command "R" to turn right
        controller.convertStringMovement(marsRover);

        Assertions.assertEquals(Orientation.E, marsRover.getOrientation()); // Verify orientation is East
    }

    // Test for move forward command "M"
    @Test
    void testConvertStringMovement_MoveForward() {
        MarsRover marsRover = new MarsRover(2, 2, 'N'); // Initialize rover at (2, 2) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward
        controller.convertStringMovement(marsRover);

        Assertions.assertEquals(2, marsRover.getXcoord()); // Verify x-coordinate remains the same
        Assertions.assertEquals(3, marsRover.getYcoord()); // Verify y-coordinate increments by 1
    }

    // Test for an illegal command
    @Test
    void testConvertStringMovement_IllegalCharacter_ThrowsException() {
        MarsRover marsRover = new MarsRover(0, 0, 'N'); // Initialize rover at (0, 0) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("Z", plateau); // Command "Z" is invalid

        Assertions.assertThrows(IllegalStateException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }

    // Test for moving outside plateau boundaries
    @Test
    void testConvertStringMovement_OutOfPlateau_ThrowsException() {
        MarsRover marsRover = new MarsRover(0, 0, 'S'); // Initialize rover at (0, 0) facing South
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }

    // Test multiple commands including turns and moves
    @Test
    void testConvertStringMovement_MultipleCommands() {
        MarsRover marsRover = new MarsRover(1, 2, 'N'); // Initialize rover at (1, 2) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("LMLMLMLMM", plateau); // Execute series of commands
        controller.convertStringMovement(marsRover);

        Assertions.assertEquals(1, marsRover.getXcoord()); // Final x-coordinate
        Assertions.assertEquals(3, marsRover.getYcoord()); // Final y-coordinate
        Assertions.assertEquals(Orientation.N, marsRover.getOrientation()); // Final orientation
    }

    // Test another set of multiple commands
    @Test
    void testConvertStringMovement_AnotherMultipleCommands() {
        MarsRover marsRover = new MarsRover(3, 3, 'E'); // Initialize rover at (3, 3) facing East
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("MMRMMRMRRM", plateau); // Execute series of commands
        controller.convertStringMovement(marsRover);

        Assertions.assertEquals(5, marsRover.getXcoord()); // Final x-coordinate
        Assertions.assertEquals(1, marsRover.getYcoord()); // Final y-coordinate
        Assertions.assertEquals(Orientation.E, marsRover.getOrientation()); // Final orientation
    }

    // Test for attempting to move out of the plateau's north boundary
    @Test
    void testConvertStringMovement_OutOfBounds_North_ThrowsException() {
        MarsRover marsRover = new MarsRover(0, 5, 'N'); // Initialize rover at (0, 5) facing North
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }

    // Test for attempting to move out of the plateau's south boundary
    @Test
    void testConvertStringMovement_OutOfBounds_South_ThrowsException() {
        MarsRover marsRover = new MarsRover(0, 0, 'S'); // Initialize rover at (0, 0) facing South
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }

    // Test for attempting to move out of the plateau's east boundary
    @Test
    void testConvertStringMovement_OutOfBounds_East_ThrowsException() {
        MarsRover marsRover = new MarsRover(5, 0, 'E'); // Initialize rover at (5, 0) facing East
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }

    // Test for attempting to move out of the plateau's west boundary
    @Test
    void testConvertStringMovement_OutOfBounds_West_ThrowsException() {
        MarsRover marsRover = new MarsRover(0, 0, 'W'); // Initialize rover at (0, 0) facing West
        MarsPlateau plateau = new MarsPlateau(5, 5); // Create plateau of dimensions 5x5
        MarsController controller = new MarsController("M", plateau); // Command "M" to move forward

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            controller.convertStringMovement(marsRover); // Verify exception is thrown
        });
    }
}