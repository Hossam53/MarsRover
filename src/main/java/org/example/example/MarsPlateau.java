package org.example.example;

public record MarsPlateau(Integer length, Integer width) {

    @Override
    public String toString() {
        return "MarsPlateau [length=" + length + ", width=" + width + "]";
    }

    @Override
    public Integer length() {
        return length;
    }

    @Override
    public Integer width() {
        return width;
    }
}
