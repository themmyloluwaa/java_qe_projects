package org.sit.qe.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {

    /**
     * The implementation of this method is taken from the implementation of
     * Method indexedBinarySearch in the OpenJDK version 8 (see also
     * https://hg.openjdk.java.net/jdk8/jdk8/jdk/file/687fd7c7986d/src/share/classes/java/util/Collections.java)
     * It is slightly adapted with a simpler interface.
     * The method searches for an element in a sorted list and returns its
     * index. For the interested reader: The original (not the one below)
     * implementation of this method contains a famous bug. You may search for
     * the famous binary search bug in the JDK.
     *
     * The following documentation is also taken from OpenJDK 8, but slightly
     * adapted:
     *
     * Searches the specified list for the specified object using the binary
     * search algorithm.  The list must be sorted into ascending order
     * according to the natural ordering imposed by Comparable
     * (as by the {@code CollectionUtils.sort} method) prior to making this
     * call.  If it is not sorted, the results are undefined.  If the list
     * contains multiple elements equal to the specified object, there is no
     * guarantee which one will be found.
     *
     * For testing this means: any result for a call with an unsorted lists is
     * correct, that is, you may ignore cases with unsorted lists. Lists with
     * duplicates allow for multiple correct return values. Null as input is
     * also undefined and may raise exceptions, which is considered correct.
     *
     * This method runs in log(n) time for a "random access" list (which
     * provides near-constant-time positional access). For instance,
     * {@code java.util.ArrayList} implements fast random access.
     *
     * You may call this method, for instance, via:
     * {@code
     * List<Integer> l = new ArrayList<>();
     * l.add(1);
     * l.add(4);
     * l.add(9);
     * int index = CollectionUtils.binarySearch(l, 4);
     * // index should be 1
     * }
     *
     * @param  <T> the class of the objects in the list
     * @param  list the list to be searched.
     * @param  key the key to be searched for.
     * @return the index of the search key, if it is contained in the list;
     *         otherwise, <tt>(-(<i>insertion point</i>) - 1)</tt>.  The
     *         <i>insertion point</i> is defined as the point at which the
     *         key would be inserted into the list: the index of the first
     *         element greater than the key, or <tt>list.size()</tt> if all
     *         elements in the list are less than the specified key.  Note
     *         that this guarantees that the return value will be &gt;= 0 if
     *         and only if the key is found.
     */
    public static <T extends Comparable<T>>
    int binarySearch(List<T> list, T key) {
        int low = 0;
        int high = list.size()-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found
    }
}
