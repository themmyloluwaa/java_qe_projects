package org.sit.qe.util;

import java.util.*;

public class StringUtils {


    private static final String EMPTY = "";
    private static final Map<Character, Integer > HEX_VALUES = new HashMap<>();
    static {
        HEX_VALUES.put('0', 0);
        HEX_VALUES.put('1', 1);
        HEX_VALUES.put('2', 2);
        HEX_VALUES.put('3', 3);
        HEX_VALUES.put('4', 4);
        HEX_VALUES.put('5', 5);
        HEX_VALUES.put('6', 6);
        HEX_VALUES.put('7', 7);
        HEX_VALUES.put('8', 8);
        HEX_VALUES.put('9', 9);
        HEX_VALUES.put('A', 10);
        HEX_VALUES.put('B', 11);
        HEX_VALUES.put('C', 12);
        HEX_VALUES.put('D', 13);
        HEX_VALUES.put('E', 14);
        HEX_VALUES.put('F', 15);
        HEX_VALUES.put('a', 10);
        HEX_VALUES.put('b', 11);
        HEX_VALUES.put('c', 12);
        HEX_VALUES.put('d', 13);
        HEX_VALUES.put('e', 14);
        HEX_VALUES.put('f', 15);
    }

    /**
     * The implementation of this method has been adapted from StringUtils in
     * Apache Commons Lang. The following documentation is taken from the
     * original implementation.
     *
     * <p>Removes one newline from end of a String if it's there,
     * otherwise leave it alone.  A newline is &quot;{@code \n}&quot;,
     * &quot;{@code \r}&quot;, or &quot;{@code \r\n}&quot;.</p>
     *
     * <p>NOTE: This method changed in 2.0.
     * It now more closely matches Perl chomp.</p>
     *
     * <pre>
     * StringUtils.chomp(null)          = null
     * StringUtils.chomp("")            = ""
     * StringUtils.chomp("abc \r")      = "abc "
     * StringUtils.chomp("abc\n")       = "abc"
     * StringUtils.chomp("abc\r\n")     = "abc"
     * StringUtils.chomp("abc\r\n\r\n") = "abc\r\n"
     * StringUtils.chomp("abc\n\r")     = "abc\n"
     * StringUtils.chomp("abc\n\rabc")  = "abc\n\rabc"
     * StringUtils.chomp("\r")          = ""
     * StringUtils.chomp("\n")          = ""
     * StringUtils.chomp("\r\n")        = ""
     * </pre>
     *
     * @param str  the String to chomp a newline from, may be null
     * @return String without newline, {@code null} if null String input
     */
    public static String chomp(final String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        if (str.length() == 1) {
            final char ch = str.charAt(0);
            if (ch == '\r' || ch == '\n') {
                return EMPTY;
            }
            return str;
        }

        int lastIdx = str.length() - 1;
        final char last = str.charAt(lastIdx);

        if (last == '\n') {
            if (str.charAt(lastIdx - 1) == '\r') {
                lastIdx--;
            }
        } else if (last != '\r') {
            lastIdx++;
        }
        return str.substring(0, lastIdx);
    }

    /**
     * The implementation of this method has been adapted from StringUtils in
     * Apache Commons Lang.
     * The following documentation has been slightly adapted from the original documentation.
     *
     * <p>Joins the string representations of the elements in the provided {@code List} 
     * into a single String containing the provided list of elements. The string representation
     * of an element is retrieved via {@code Object.toString()}.</p>
     *
     * <p>No delimiter is added before or after the list.
     * Null objects or empty strings within the array are represented by
     * empty strings.</p>
     *
     * <pre>
     * StringUtils.join(null, *)               = null
     * StringUtils.join([], *)                 = ""
     * StringUtils.join([null], *)             = ""
     * StringUtils.join(["a", "b", "c"], ';')  = "a;b;c"
     * StringUtils.join(["a", "b", "c"], null) = "abc"
     * StringUtils.join([null, "", "a"], ';')  = ";;a"
     * </pre>
     *
     * @param list  the {@code List} of values to join together, may be null
     * @param separator  the separator character to use
     * @param startIndex the first index to start joining from.  It is
     * an error to pass in a start index past the end of the list
     * @param endIndex the index to stop joining from (exclusive). It is
     * an error to pass in an end index past the end of the list
     * @return the joined String, {@code null} if null list input
     * @since 3.8
     */
    public static String join(final List<?> list, final String separator, final int startIndex, final int endIndex) {
        if (list == null) {
            return null;
        }
        final int noOfItems = endIndex - startIndex;
        if (noOfItems <= 0) {
            return EMPTY;
        }
        final List<?> subList = list.subList(startIndex, endIndex);
        return join(subList.iterator(), separator);
    }
    public static String join(final Iterator<?> iterator, final String separator) {

        // handle null, zero and one elements before building a buffer
        if (iterator == null) {
            return null;
        }
        if (!iterator.hasNext()) {
            return EMPTY;
        }
        final Object first = iterator.next();
        if (!iterator.hasNext()) {
            return Objects.toString(first, "");
        }

        // two or more elements
        final StringBuilder buf = new StringBuilder();
        if (first != null) {
            buf.append(first);
        }

        while (iterator.hasNext()) {
            if (separator != null) {
                buf.append(separator);
            }
            final Object obj = iterator.next();
            if (obj != null) {
                buf.append(obj);
            }
        }
        return buf.toString();
    }

    /**
     * This is a reimplementation of the C function cgi_decode presented in
     * "Software Testing and Analysis: Process, Principles, and Techniques" by
     * Pezzè and Young.
     * It decodes a CGI-encoded string. For more information, please refer to the original 
     * implementation. 
     *
     * @param encoded a CGI-encoded string
     * @return {@code Optional.empty()} in case of an error (malformed input),
     *         otherwise {@code Optional.of(result)}, where result is the decoded string
     */
    public static Optional<String> cgiDecode(String encoded){
        StringBuilder decodedBuilder = new StringBuilder();
        boolean ok = true;
        for(int encodedI = 0; encodedI < encoded.length(); encodedI++){
            char c = encoded.charAt(encodedI);
            if(c == '+'){
                decodedBuilder.append(' ');
            } else if(c == '%'){
                Integer digitHigh = HEX_VALUES.get(encoded.charAt(++encodedI));
                Integer digitLow = HEX_VALUES.get(encoded.charAt(++encodedI));
                if(digitHigh == null || digitLow == null){
                    ok = false;
                } else {
                    decodedBuilder.append((char)(16*digitHigh + digitLow));
                }
            } else {
                decodedBuilder.append(c);
            }
        }
        if(ok){
            return Optional.of(decodedBuilder.toString());
        } else {
            return Optional.empty();
        }
    }
}
