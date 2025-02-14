package org.example.example;


public enum Orientation {
    N, E, S, W;

    static public final Orientation[] values = values();

    public Orientation next() {
        return values[(this.ordinal() + 1) % values.length];
    }

    public Orientation previous() {
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }

}


