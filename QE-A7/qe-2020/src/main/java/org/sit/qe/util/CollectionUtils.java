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
}
