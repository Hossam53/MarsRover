package org.example.example;

public class MarsRover {
    private Integer xcoord;
    private Integer ycoord;

    private Orientation orientation;

    public MarsRover(Integer xcoord, Integer ycoord, char orientation) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.orientation = convertOrientation(orientation);
    }

    public Integer getAngle() {
        return switch (orientation) {
            case N -> 360;
            case S -> 180;
            case E -> 90;
            case W -> 270;
        };
    }

    public Orientation getOrientation(Integer Angle) {
        return switch (Angle){
            case 360 -> Orientation.N;
            case 90 -> Orientation.E;
            case 180 -> Orientation.S;
            case 270 -> Orientation.W;
            default -> throw new IllegalStateException("Unexpected value: " + Angle);
        };
    }

    public Orientation convertOrientation(char orientation) {
        switch (orientation) {
            case 'N':
                return Orientation.N;
                case 'S':
                    return Orientation.S;
                    case 'E':
                        return Orientation.E;
                        case 'W':
                            return Orientation.W;





        }
        return null;
    }

    @Override
    public String toString() {
        return getXcoord() + " " + getYcoord() + " " + getOrientation();
    }

    public Integer getXcoord() {
        return xcoord;
    }

    public Integer getYcoord() {
        return ycoord;
    }
    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public void setXcoord(Integer xcoord) {
        this.xcoord = xcoord;
    }
    public void setYcoord(Integer ycoord) {
        this.ycoord = ycoord;
    }
}

