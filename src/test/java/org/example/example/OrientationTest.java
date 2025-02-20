package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {

    @Test
    void testnext() {
        // Verify that the next orientation after North is East
        assertEquals(Orientation.N.next(), Orientation.E);

        // Verify that the next orientation after East is South
        assertEquals(Orientation.E.next(), Orientation.S);

        // Verify that the next orientation after South is West
        assertEquals(Orientation.S.next(), Orientation.W);

        // Verify that the next orientation after West is North
        assertEquals(Orientation.W.next(), Orientation.N);
    }

    @Test
    void testprevious() {
        // Verify that the previous orientation before East is North
        assertEquals(Orientation.E.previous(), Orientation.N);
    }
}