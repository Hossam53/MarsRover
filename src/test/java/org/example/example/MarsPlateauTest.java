package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsPlateauTest {
  @Test
  public void testConstructor() {
    MarsPlateau plateau = new MarsPlateau(3, 7);
    assertEquals(3, plateau.length());
    assertEquals(7, plateau.width());
  }

  @Test
  public void testToString() {
    MarsPlateau plateau = new MarsPlateau(5, 5);
    assertEquals("MarsPlateau [length=5, width=5]", plateau.toString());
  }

  @Test
  public void testToStringWithNullValues() {
    MarsPlateau plateau = new MarsPlateau(null, null);
    assertEquals("MarsPlateau [length=null, width=null]", plateau.toString());
  }

  @Test
  public void testToStringWithZeroValues() {
    MarsPlateau plateau = new MarsPlateau(0, 0);
    assertEquals("MarsPlateau [length=0, width=0]", plateau.toString());
  }

}