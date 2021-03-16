package org.sit.qe.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @Test
    void testOneWithNull() {
    assertThrows(IllegalArgumentException.class, () -> MathUtils.max(null));
    }

    @Test

    void testTwoWithEmptyArray() {
        int[] arrValue = new int [] {};
        assertThrows(IllegalArgumentException.class, () -> MathUtils.max(arrValue));
    }

    @Test
    void testThreeWithOrderedValues() {
        int[] arrValues = new int[] {78,90,300,980,5000};
        assertEquals(5000,MathUtils.max(arrValues));
    }

    @Test
    void testFourWithReversedValues() {
        int[] arrValues = new int[] {5, 4,3,2,1,0};
        assertEquals(5,MathUtils.max(arrValues));
    }

    @Test
    void testFiveWithUnorderedValues() {
        int[] arrValues = new int[] {1,60,2,68,1,45,76,2000,48,32,-1};
        assertEquals(2000, MathUtils.max(arrValues));
    }

    @Test
    void  testSixWithNegativeValues() {
        int[] arrValues = new  int[] {-19,-21,-30,-56,-100};
        assertEquals(-19, MathUtils.max(arrValues));
    }

    @Test
    void testSevenWithIntegerMax() {
        int[] arrValues = new int[] {10000, 2147483637 , 2147483646, 2147483647};
        assertEquals(2147483647, MathUtils.max(arrValues));
    }


    @Test
    void testEightWithIntegerMaxSingle() {
        int[] arrValues = new int[] {2147483647,0};
        assertEquals(2147483647, MathUtils.max(arrValues));
    }

}
