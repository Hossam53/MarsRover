package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsPlateauTest {

    // Test the constructor and ensure the dimensions are correctly set
    @Test
    public void testConstructor() {
        MarsPlateau plateau = new MarsPlateau(3, 7);
        assertEquals(3, plateau.length()); // Verify the length is correctly set
        assertEquals(7, plateau.width());  // Verify the width is correctly set
    }

    // Test the toString method with non-null values
    @Test
    public void testToString() {
        MarsPlateau plateau = new MarsPlateau(5, 5);
        assertEquals("MarsPlateau [length=5, width=5]", plateau.toString());
    }

    // Test the toString method when null values are passed
    @Test
    public void testToStringWithNullValues() {
        MarsPlateau plateau = new MarsPlateau(null, null);
        assertEquals("MarsPlateau [length=null, width=null]", plateau.toString());
    }

    // Test the toString method with zero values
    @Test
    public void testToStringWithZeroValues() {
        MarsPlateau plateau = new MarsPlateau(0, 0);
        assertEquals("MarsPlateau [length=0, width=0]", plateau.toString());
    }

}