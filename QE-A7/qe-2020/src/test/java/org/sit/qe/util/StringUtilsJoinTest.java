package org.sit.qe.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsJoinTest {

    @Test
    void testForMostPerfect() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String actual = StringUtils.
                join(list, null, 0, 3);
        assertEquals("abc", actual);

    }

    @Test
    void testForAnotherPerfect() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String actual = StringUtils.
                join(list, null, 2, 3);
        assertEquals("c", actual);

    }

    @Test
    void testForPerfect() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String actual = StringUtils.
                join(list, ";", 0, 3);
        assertEquals("a;b;c", actual);

    }

    @Test
    void testForLeastPerfect() {
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add("");
        list.add("c");
        String actual = StringUtils.
                join(list, ";", 0, 3);
        assertEquals(";;c", actual);

    }

    @Test
    void testForStartGreaterThanLength() {
        List<String> list = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.join(list, "*", 2, 3));

    }

    @Test
    void testForStartGreaterThanLengthOne() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.join(list, "*", 6, 0));

    }

    @Test
    void testForStartGreaterThanLengthTwo() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.join(list, "*", 3, 3));

    }

    @Test
    void testStartGreaterThanLengthThree() {
        List<String> list = new ArrayList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> StringUtils.join(list, "*", 7, 0));

    }

    @Test
    void testForEmptyList() {
        List<String> list = new ArrayList<>();
        String actual = StringUtils.
                join(list, "*", 0, 0);
        assertEquals("", actual);

    }

    @Test
    void testForNullList() {
        List<String> list = new ArrayList<>();
        list.add(null);
        String actual = StringUtils.
                join(list, "*", 0, 1);
        assertEquals("", actual);

    }

    @Test
    void testForNull() {
        String actual = StringUtils.
                join(null, "", 0, 0);
        assertEquals(null, actual);
    }

    @Test
    void testForNullListAssert() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        String actual = StringUtils.
                join(list, null, 1, 1);
        assertEquals("", actual);
    }
}