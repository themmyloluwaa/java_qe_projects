package org.sit.qe.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CollectionUtilsTest {

    // convenience method to create lists for testing, use like
    // List<Integer> = list(1,2,3);
    public List<Integer> list(int... ints){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : ints)
            list.add(i);
        return list;
    }

    @Test
    void testBinarySearch() {
        List<Integer> arrayList = list(1,2,3);
        assertEquals(0, CollectionUtils.binarySearch(arrayList,1));
    }

    @Test
    void testBinarySearchOne() {
        List<Integer> arrayList = list(2, 3, 60, 100);
        assertEquals(2, CollectionUtils.binarySearch(arrayList,60));
    }

    @Test
    void testBinarySearchTwo() {
        List<Integer> arrayList = list(30,30,30,50,50,56,7880);
        assertEquals(5, CollectionUtils.binarySearch(arrayList,56));
    }

    @Test
    void testBinarySearchThree() {
        List<Integer> arrayList = list();
        assertEquals(-1, CollectionUtils.binarySearch(arrayList,56));
    }

    @Test
    void testBinarySearchFour() {
        List<Integer> arrayList = list(89, 100, 321, 569, 890, 900, 900, 1200, 3030, 5000, 7450);
        assertEquals(4, CollectionUtils.binarySearch(arrayList,890));
    }

    @Test
    void testBinarySearchFive() {
        List<Integer> arrayList = list(2, 3, 11, 30, 30, 30, 40, 45, 50, 50, 56, 56, 60, 69, 89, 89, 90, 100, 321, 569, 890, 900, 900, 1200, 3030, 5000, 7450, 7880);
        assertEquals(27, CollectionUtils.binarySearch(arrayList,7880));
    }

    @Test
    void testBinarySearchSix() {
        List<Integer> arrayList = list(2, 3, 11, 30, 30, 30, 40, 45, 50, 50);
        assertEquals(4, CollectionUtils.binarySearch(arrayList,30));
    }

    @Test
    void testBinarySearchSeven() {
        List<Integer> arrayList = list(200, 590, 690, 721, 862, 862, 915);
        assertEquals(-1, CollectionUtils.binarySearch(arrayList,100));
    }


}
