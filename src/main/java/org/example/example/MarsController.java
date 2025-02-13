package org.example.example;

public class MarsController {
  private String movement;

  public MarsController(String movement) {
    this.movement = movement;
  }

  public Movement convertMovement(Character movement) {
    return switch (movement) {
      case 'L' -> Movement.L;
      case 'R' -> Movement.R;
      case 'M' -> Movement.M;
      default -> null;
    };
  }

  public void convertStringMovement(String movement) {
    for (int i =0; i<movement.length(); i++) {
      System.out.println(convertMovement(movement.charAt(i)));



    }


  }

}
