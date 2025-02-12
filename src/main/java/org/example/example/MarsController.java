package org.example.example;

public class MarsController {
  private String movement;

  public MarsController(String movement) {
    this.movement = movement;
  }

  private Movement convertMovement(Character movement) {
    return switch (movement) {
      case 'L' -> Movement.L;
      case 'R' -> Movement.R;
      case 'M' -> Movement.M;
      default -> null;
    };
  }
}
