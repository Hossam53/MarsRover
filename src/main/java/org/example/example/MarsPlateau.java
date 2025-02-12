package org.example.example;

public class MarsPlateau {

    private Integer length;
    private Integer width;

    public MarsPlateau(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }
    public Integer getLength() {
        return length;
    }

    public Integer getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "MarsPlateau [length=" + length + ", width=" + width + "]";
    }







}
