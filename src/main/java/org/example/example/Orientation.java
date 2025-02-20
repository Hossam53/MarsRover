package org.example.example;

/**
 * Enumeration representing the four cardinal orientations: North, East, South, and West.
 * Provides methods to get the next and previous orientations in a circular sequence.
 */
public enum Orientation {
    /**
     * Orientation pointing to the North.
     */
    N,

    /**
     * Orientation pointing to the East.
     */
    E,

    /**
     * Orientation pointing to the South.
     */
    S,

    /**
     * Orientation pointing to the West.
     */
    W;

    /**
     * An array holding all possible orientation values.
     * Useful for iterating through or accessing orientations based on their order.
     */
    static public final Orientation[] values = values();

    /**
     * Returns the next orientation in the sequence.
     * The sequence loops from W (West) back to N (North).
     *
     * @return the next {@code Orientation} in a circular sequence.
     */
    public Orientation next() {
        return values[(this.ordinal() + 1) % values.length];
    }

    /**
     * Returns the previous orientation in the sequence.
     * The sequence loops from N (North) back to W (West).
     *
     * @return the previous {@code Orientation} in a circular sequence.
     */
    public Orientation previous() {
        return values[(this.ordinal() - 1 + values.length) % values.length];
    }
}


