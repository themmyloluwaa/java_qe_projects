package org.sit.qe.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsChompTest {

    @Test
    void testPerfectString() {
        String actual = StringUtils.
                chomp("abc");
        assertEquals("abc", actual);
    }

    @Test
    void testOneCharString() {
        String actual = StringUtils.
                chomp("a");
        assertEquals("a", actual);
    }

    @Test
    void testNull() {
        String actual = StringUtils.
                chomp(null);
        assertEquals(null, actual);
    }

    @Test
    void testEmptyString() {
        String actual = StringUtils.
                chomp("");
        assertEquals("", actual);
    }

    @Test
    void testSlashR() {
        String actual = StringUtils.
                chomp("abc \r");
        assertEquals("abc ", actual);
    }

    @Test
    void testNewLine() {
        String actual = StringUtils.
                chomp("abc\n");
        assertEquals("abc", actual);
    }

    @Test
    void testRAndNewLine() {
        String actual = StringUtils.
                chomp("abc\r\n");
        assertEquals("abc", actual);
    }

    @Test
    void testAnotherRAndNewLine() {
        String actual = StringUtils.
                chomp("abc\r\n\r\n");
        assertEquals("abc\r\n", actual);
    }

    @Test
    void testAnotherRAndNewLine1() {
        String actual = StringUtils.
                chomp("abc\n\r");
        assertEquals("abc\n", actual);
    }

    @Test
    void testPackedStrings() {
        String actual = StringUtils.
                chomp("abc\n\rabc");
        assertEquals("abc\n\rabc", actual);
    }

    @Test
    void testOnlyR() {
        String actual = StringUtils.
                chomp("\r");
        assertEquals("", actual);
    }

    @Test
    void testOnlyN() {
        String actual = StringUtils.
                chomp("\n");
        assertEquals("", actual);
    }

    @Test
    void testOnlyRAndN() {
        String actual = StringUtils.
                chomp("\r\n");
        assertEquals("", actual);
    }
}
