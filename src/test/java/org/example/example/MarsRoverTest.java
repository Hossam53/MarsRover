package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MarsRoverTest {

    // Test to ensure the toString method returns the correct string representation of MarsRover
    @Test
    public void testToString() {
        MarsRover marsRover = new MarsRover(5, 10, 'N');
        assertEquals("5 10 N", marsRover.toString());
    }

    // Test setting and getting the x-coordinate of MarsRover
    @Test
    public void testSetAndGetXcoord() {
        MarsRover marsRover = new MarsRover(0, 0, 'N');
        marsRover.setXcoord(3);
        assertEquals(3, marsRover.getXcoord());
    }

    // Test setting and getting the y-coordinate of MarsRover
    @Test
    public void testSetAndGetYcoord() {
        MarsRover marsRover = new MarsRover(0, 0, 'N');
        marsRover.setYcoord(4);
        assertEquals(4, marsRover.getYcoord());
    }

    // Test setting and getting the orientation of MarsRover
    @Test
    public void testSetAndGetOrientation() {
        MarsRover marsRover = new MarsRover(0, 0, 'N');
        marsRover.setOrientation(Orientation.W);
        assertEquals(Orientation.W, marsRover.getOrientation());
    }

    // Test the 'next' method of Orientation to ensure it cycles correctly
    @Test
    public void testOrientationNext() {
        assertEquals(Orientation.E, Orientation.N.next());
        assertEquals(Orientation.S, Orientation.E.next());
        assertEquals(Orientation.W, Orientation.S.next());
        assertEquals(Orientation.N, Orientation.W.next());
    }

    // Test the 'previous' method of Orientation to ensure it cycles correctly
    @Test
    public void testOrientationPrevious() {
        assertEquals(Orientation.W, Orientation.N.previous());
        assertEquals(Orientation.N, Orientation.E.previous());
        assertEquals(Orientation.E, Orientation.S.previous());
        assertEquals(Orientation.S, Orientation.W.previous());
    }

    // Test if the convertOrientation method correctly converts 'N' to Orientation.N
    @Test
    public void testConvertOrientationN() {
        MarsRover marsRover = new MarsRover(0, 0, 'N');
        assertEquals(Orientation.N, marsRover.getOrientation());
    }

    // Test if the convertOrientation method correctly converts 'W' to Orientation.W
    @Test
    public void testConvertOrientationW() {
        MarsRover marsRover = new MarsRover(0, 0, 'W');
        assertEquals(Orientation.W, marsRover.getOrientation());
    }

    // Test if the convertOrientation method correctly converts 'S' to Orientation.S
    @Test
    public void testConvertOrientationS() {
        MarsRover marsRover = new MarsRover(0, 0, 'S');
        assertEquals(Orientation.S, marsRover.getOrientation());
    }

    // Test if the convertOrientation method correctly converts 'E' to Orientation.E
    @Test
    public void testConvertOrientationE() {
        MarsRover marsRover = new MarsRover(0, 0, 'E');
        assertEquals(Orientation.E, marsRover.getOrientation());
    }

    // Test if the convertOrientation method returns null for invalid orientation inputs
    @Test
    public void testConvertOrientationInvalid() {
        MarsRover marsRover = new MarsRover(0, 0, 'A');
        assertNull(marsRover.getOrientation());
    }
}