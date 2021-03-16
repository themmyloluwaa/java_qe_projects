package org.sit.qe.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {
    private static final double EPSILON = 1e-6;

    @Test
    void testMean() {
        int[] values = new int[] { 1, 2, 3, 4 };
        double actual = CollectionUtils.mean(values, 0, 4);
        assertEquals(2.5, actual, EPSILON);
    }

    @Test
    void testMeanOne() {
        int[] values = new int[] { 5, 6, 7, 8 };
        double actual = CollectionUtils.mean(values, 0, 4);
        assertEquals(6.5, actual, EPSILON);
    }

    @Test
    void testMeanTwo() {
        int[] values = new int[] { 5, 6, 7, 9, 0, 12 };
        double actual = CollectionUtils.mean(values, 0, 6);
        assertEquals(6.5, actual, EPSILON);
    }

    @Test
    void testMeanThree() {
        int[] values = new int[] { -5, -6, -7, -8, -9 };
        double actual = CollectionUtils.mean(values, 0, 5);
        assertEquals(-7, actual, EPSILON);
    }
}
