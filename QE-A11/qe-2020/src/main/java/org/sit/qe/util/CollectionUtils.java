package org.sit.qe.util;

import java.util.Arrays;

public class CollectionUtils implements ICollectionUtils{
    public int[][] powerSet(int [] set){
        int powersetSize = (int)Math.pow(2,set.length);
        int[][] subsets = new int[powersetSize][];
        for(int bits = 0; bits < powersetSize; bits++){
            int[] subset = new int[Integer.bitCount(bits)];
            int elemsInSubset = 0;
            for(int i = 0; i < set.length; i++){
                int bitmask = 1 << i;
                if((bitmask & bits) > 0){
                    subset[elemsInSubset] = set[i];
                    elemsInSubset ++;
                }
            }
            subsets[bits]= subset;
        }
        return subsets;
    }

    public int minArrayIndex(int[] values)
    {
        int minIndex = -1;
        for (int i = 0; i < values.length; i++)
        {
            if (minIndex == -1 || values[i] < values[minIndex])
            {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public int[] diff(int[] a1, int[] a2)
    {
        int [] result = new int[a1.length];
        int resultI = 0;
        for (int i = 0; i < a1.length; i++)
        {
            int currentVal = a1[i];
            boolean inA2 = false;
            for (int j = 0; j < a2.length; j++)
            {
                if (a2[j] == currentVal)
                {
                    inA2 = true;
                    break;
                }
            }
            if (!inA2)
            {
                result[resultI++] = currentVal;
            }
        }
        return Arrays.copyOf(result,resultI);
    }

    public int[] toSet(int[] values)
    {
        int[] result = new int[values.length];
        int resultI = 0;
        for (int i = 0; i < values.length; i++)
        {
            boolean inResult = false;
            int currentVal = values[i];
            for (int j = 0; j < resultI; j++)
            {
                if (currentVal == result[j])
                {
                    inResult = true;
                    break;
                }
            }
            if (!inResult)
            {
                result[resultI++] = currentVal;
            }
        }
        return Arrays.copyOf(result,resultI);
    }

}
