package org.example.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    @Test
    void testnext() {
      assertEquals(Orientation.N.next(), Orientation.E);
      assertEquals(Orientation.E.next(), Orientation.S);
      assertEquals(Orientation.S.next(), Orientation.W);
      assertEquals(Orientation.W.next(), Orientation.N);

    }

  @Test
  void testprevious() {
        assertEquals(Orientation.E.previous(), Orientation.N);
    }

}