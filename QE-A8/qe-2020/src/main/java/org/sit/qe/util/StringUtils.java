package org.sit.qe.util;

import java.util.*;

public class StringUtils {

    /**
     * This is a simplified version of Java's split method on strings. Instead
     * of a regex, we use a single character to split. The implementation is
     * taken and adapted from OpenJDK's implementation of the method (see also
     * version 7 of the OpenJDK http://hg.openjdk.java.net/jdk7u/jdk7u6/jdk/file/8c2c5d63a17e/src/share/classes/java/lang/String.java).
     *
     * The following documentation is also taken and adapted from the OpenJDK.
     *
     * Splits this string around occurences of the given character
     * {@code delim}.
     *
     * The array returned by this method contains each substring of this
     * string that is terminated by the given delimiting character or is
     * terminated by the end of the string. The substrings in the array are in
     * the order in which they occur in this string. If the character is not
     * included in the input then the resulting array has just one element,
     * namely the input string.
     *
     * The <tt>limit</tt> parameter controls the number of times the
     * delimiter is checked and therefore affects the length of the resulting
     * array.  If the limit n is greater than zero then the delimiter
     * will be checked at most n-1 times, the array's
     * length will be no greater than n, and the array's last entry
     * will contain all input beyond the last matched delimiter.  If <i>n</i>
     * is non-positive then the pattern will be applied as many times as
     * possible and the array can have any length.  If <i>n</i> is zero then
     * the pattern will be applied as many times as possible, the array can
     * have any length, and trailing empty strings will be discarded.
     *
     * The string <tt>"boo:and:foo"</tt>, for example, yields the
     * following results with these parameters:
     *
     * Delimiter, Limit, Result
     * :, 2, { "boo", "and:foo" }
     * Delimiter, Limit, Result
     * :, 5, { "boo", "and", "foo" }
     * Delimiter, Limit, Result
     * :, -2, { "boo", "and", "foo" }
     * Delimiter, Limit, Result
     * o, 5, { "b", "", ":and:f", "", "" }
     * Delimiter, Limit, Result
     * o, -2, { "b", "", ":and:f", "", "" }
     * Delimiter, Limit, Result
     * o, 0, { "b", "", ":and:f" }
     *
     *
     * @param s the string that should be split
     *
     * @param delim the delimiter that should be used for splitting
     *
     * @param  limit
     *         the result threshold, as described above
     *
     * @return  the array of strings computed by splitting this string
     *          around matches of the given regular expression
     *
     */
    public static String[] split(String s, char delim, int limit){
        int off = 0;
        int next = 0;
        boolean limited = limit > 0;
        ArrayList<String> list = new ArrayList<>();
        while ((next = s.indexOf(delim, off)) != -1) {
            if (!limited || list.size() < limit - 1) {
                list.add(s.substring(off, next));
                off = next + 1;
            } else {    // last one
                //assert (list.size() == limit - 1);
                list.add(s.substring(off, s.length()));
                off = s.length();
                break;
            }
        }
        // If no match was found, return this
        if (off == 0)
            return new String[]{s};

        // Add remaining segment
        if (!limited || list.size() < limit)
            list.add(s.substring(off, s.length()));

        // Construct result
        int resultSize = list.size();
        if (limit == 0)
            while (resultSize > 0 && list.get(resultSize - 1).length() == 0)
                resultSize--;
        String[] result = new String[resultSize];
        return list.subList(0, resultSize).toArray(result);
    }


}
