package org.sit.qe.util;

import java.util.*;

public class StringUtils {


    private static final String EMPTY = "";

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
        } else {
          System.out.println("Going to chomp " + str);
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
     * an error to pass in a start index past the last index of the list
     * @param endIndex the index to stop joining from (exclusive). It is
     * an error to pass in an end index past the last index of the list + 1
     * @return the joined String, {@code null} if null list input, {@code ""} if
     * the interval size defined by {@code startIndex} and {@code endIndex} is
     * less than or equal to zero
     * @throws IndexOutOfBoundsException
     *      if {@code startIndex} or {@code endIndex} are illegal, legal values
     *      are defined by
     *      {@code startIndex} == 0 if list.size() == 0,
     *       0 <= {@code startIndex} < list.size() if list.size() > 0, and
     *       0 <= {@code endIndex} <= list.size()
     *       (empty {@code list} values are special case, which only allows
     *       {@code startIndex} == 0 and {@code endIndex} == 0)
     * @since 3.8
     */
    public static String join(final List<String> list, final String separator, final int startIndex, final int endIndex) {
        if (list == null) {
            return null;
        }
        else {
            if (startIndex < 0 ||
                    (startIndex >= list.size() && list.size() > 0) || // handle non-empty lists
                    (startIndex > 0 && list.size() == 0) // handle empty lists
                    || endIndex < 0 || endIndex > list.size()) {
                throw new IndexOutOfBoundsException();
            }
            final int noOfItems = endIndex - startIndex;
            if (noOfItems <= 0) {
                return EMPTY;
            }
            final List<?> subList = list.subList(startIndex, endIndex);
            final Iterator<?> subListIterator = subList.iterator();
            final Object first = subListIterator.next();
            if (!subListIterator.hasNext()) {
                return Objects.toString(first, "");
            }

            // two or more elements
            final StringBuilder buf = new StringBuilder();
            if (first != null) {
                buf.append(first);
            }

            while (subListIterator.hasNext()) {
                if (separator != null) {
                    buf.append(separator);
                }
                final Object obj = subListIterator.next();
                if (obj != null) {
                    buf.append(obj);
                }
            }
            return buf.toString();
        }
    }
}
