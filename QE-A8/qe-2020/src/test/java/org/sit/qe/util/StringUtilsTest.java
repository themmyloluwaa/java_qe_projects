package org.sit.qe.util;

import com.sun.org.apache.xpath.internal.operations.String.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    String testStringValue = "dogs!or!cat";


        @Test
    void testOneForSplit () {
        String[] expected = new String[]{testStringValue};
        assertArrayEquals(expected, StringUtils.split(testStringValue,'-',0 ));
    }

    @Test
    void testTwoForSplit () {
        String[] expected = new String[]{"dogs", "or", "cat"};
        assertArrayEquals(expected, StringUtils.split(testStringValue,'!',6 ));
    }

    @Test
    void testThreeForSplit() {
        String[] expected = new String[]{ };
        assertArrayEquals(expected, StringUtils.split("zzzzzzzz",'z',0 ));
    }

    @Test
    void testFourForSplit () {
        String[] expected = new String[]{"d","gs!","r!cat"};
        assertArrayEquals(expected, StringUtils.split(testStringValue,'o',-3 ));
    }

    @Test
    void testFiveForSplit () {
        String[] expected = new String[]{ "dogs", "or","cat"};
        assertArrayEquals(expected, StringUtils.split(testStringValue,'!',0 ));
    }

    @Test
    void testSixForSplit() {
        String[] expected = new String[]{"dogs","or!cat"};
        assertArrayEquals(expected, StringUtils.split(testStringValue,'!', 2));
    }
}
