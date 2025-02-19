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


    public Orientation convertOrientation(char orientation) {
        return switch (orientation) {
            case 'N' -> Orientation.N;
            case 'S' -> Orientation.S;
            case 'E' -> Orientation.E;
            case 'W' -> Orientation.W;
            default -> null;
        };
    }


    @Override
    public String toString() {
        return getXcoord() + " " + getYcoord() + " " + getOrientation();
    }

    public Integer getXcoord() {
        return xcoord;
    }

    public void setXcoord(Integer xcoord) {
        this.xcoord = xcoord;
    }

    public Integer getYcoord() {
        return ycoord;
    }

    public void setYcoord(Integer ycoord) {
        this.ycoord = ycoord;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}

