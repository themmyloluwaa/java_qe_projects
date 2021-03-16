package org.sit.qe.util;

public class MathUtils {


    /**
     * This method is adapted from the method
     * org.apache.commons.lang3.math.NumberUtils.max in Apache Commons Lang
     * (version 3.11).
     * It returns the maximum value in an array.
     *
     * @param array  an array, must not be null or empty
     * @return the maximum value in the array
     * @throws IllegalArgumentException if {@code array} is {@code null}
     * @throws IllegalArgumentException if {@code array} is empty
     * @since 3.4 Changed signature from max(int[]) to max(int...)
     */
    public static int max(final int... array) {
        // Validates input
        if(array == null || array.length == 0)
            throw new IllegalArgumentException();

        // Finds and returns max
        int max = array[0];
        for (int j = 1; j < array.length; j++) {
            if (max != Integer.MAX_VALUE && array[j] >= max + 1) {
                max = array[j];
            }
        }

        return max;
    }
}
