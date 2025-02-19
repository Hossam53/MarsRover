package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    @Test
    void testnext() {
        assertEquals(Orientation.E.next(), Orientation.S);

    }

    @Test
    void testprevious() {
        assertEquals(Orientation.E.previous(), Orientation.N);
    }

}