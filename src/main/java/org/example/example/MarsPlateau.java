package org.example.example;


/**
 * Represents a rectangular plateau on Mars defined by its length and width.
 * This is implemented as a Java record which provides a compact syntax for immutable data objects.
 *
 * <p>The {@code MarsPlateau} class includes methods to obtain the dimensions of the plateau
 * and provides a string representation of the object for debugging or logging purposes.</p>
 *
 * @param length the length of the plateau (must be a non-negative integer)
 * @param width  the width of the plateau (must be a non-negative integer)
 */
public record MarsPlateau(Integer length, Integer width) {

    /**
     * Returns a string representation of the {@code MarsPlateau}.
     * The format is "MarsPlateau [length={length}, width={width}]".
     *
     * @return the string representation of this {@code MarsPlateau}
     */
    @Override
    public String toString() {
        return "MarsPlateau [length=" + length + ", width=" + width + "]";
    }

    /**
     * Retrieves the length of the plateau.
     *
     * @return the length of the plateau
     */
    @Override
    public Integer length() {
        return length;
    }

    /**
     * Retrieves the width of the plateau.
     *
     * @return the width of the plateau
     */
    @Override
    public Integer width() {
        return width;
    }


}

