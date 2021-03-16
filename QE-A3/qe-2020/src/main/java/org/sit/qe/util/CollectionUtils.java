package org.sit.qe.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtils {

    private static final double EPSILON = 1e-6;

    /**
     * Implementation of insertion sort. Insertion sort can be used in cases
     * where the input list is almost sorted or small. The list implementation
     * should provide fast indexed access. Due to its quadratic worst-case
     * runtime complexity, other sorting algorithms should be used in the
     * general case.
     *
     * @param list the list to be sorted in-place
     * @param <T> the type of the elements in the list (need to be comparable)
     * @throws IllegalArgumentException if called with null pointer
     */
    static <T extends Comparable<T>> void sort(List<T> list){
        if(list == null)
            throw new IllegalArgumentException("Sort must not be called with " +
                    "null");
        for(int i = 1; i < list.size(); i++){
            T key = list.get(i);
            int j = 0;
            for(j = i-1; j >= 0; j--){
                T elem = list.get(j);
                if(elem.compareTo(key) > 0){ // check if elem > key
                    list.set(j+1, elem);
                } else{
                    break;
                }
            }
            list.set(j+1,key);
        }
    }

    /**
     * This method computes the arithmetic mean of values in a subarray of
     * the array passed as an argument. It returns {@code Double.NaN} if the 
     * length of the subarray is zero.
     *
     * @param values values for which the mean should be computed
     * @param begin  the first of the considered subarray
     * @param length the length of the subarray
     * @return the arithmetic mean or {@code Double.NaN} if length is zero
     * @throws IllegalArgumentException if values is null or the subarray length
     * exceeds the length of the array {@code values}
     */
    public static double mean(int[] values, int begin, int length){
        if(length == 0)
            return Double.NaN;
        if(values == null)
            throw new IllegalArgumentException("mean must not be called with " +
                    "null.");
        if(begin + length > values.length)
            throw new IllegalArgumentException("Boundary mismatch: the " +
                    "specified length of the subarray exceeds the length of " +
                    "the array.");
        int sum = 0;
        for (int i = begin; i < begin + length; i++){
            sum += values[i];
        }
        double mean = (double)sum/length;
        return mean;
    }

}
