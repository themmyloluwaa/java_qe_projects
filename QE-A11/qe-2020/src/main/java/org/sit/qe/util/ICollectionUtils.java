package org.sit.qe.util;

public interface ICollectionUtils {
    /**
     * This method computes the powerset of a given set of integers given as an
     * array. The power set of a set A is the set of all subsets of A. Since
     * there are 2^|A| subsets, where |A| is the cardinality of A, the method
     * should only be called with small input sets.
     * The method's behavior is undefined for inputs that contain duplicates.
     *
     * Example: suppose that set = new int[]{1,2}. Then, the result should
     * include exactly the sets {}, {1}, {2}, {1,2}, which are in integer
     * array representation: new int[]{}, new int[]{1}, new int[]{2},
     * new int[]{1,2}. Note that new int[]{1,2} and new int[]{2,1} are
     * the same set.
     *
     * @param set a set of integers
     * @return the power set of the input set
     */
    int[][] powerSet(int [] set);

    /**
     * This method takes an integer array as inputs and turns it into a set,
     * that is, it removes duplicate values.
     *
     * @param values integers, potentially with duplicate values
     * @return a set of integers (without duplicates)
     */
    int[] toSet(int[] values);

    /**
     * This method determines the smallest element in an integer array and
     * returns its index. If the smallest element occurs multiple times, the
     * index of any occurrence may be returned. The method's behavior is
     * undefined for null input and it returns -1 if the input array has a
     * length of zero.
     *
     * @param values an array of integers
     * @return the index of the smallest element
     */
    int minArrayIndex(int[] values);
    /**
     * This method implements the computation of the set difference (also
     * denoted \) between two sets given as integer arrays. The set difference
     * of two sets contains all elements that are present in the first argument,
     * but not in the second.
     * The method relies on the precondition that the input arguments are
     * non-null sets (not containing duplicate values), thus the method's
     * functionality is undefined for null inputs and inputs that contain
     * duplicates.
     *
     * @param a1 left operand of set difference
     * @param a2 right operand of set difference
     * @return the set difference
     */
    int[] diff(int[] a1, int[] a2);
}
