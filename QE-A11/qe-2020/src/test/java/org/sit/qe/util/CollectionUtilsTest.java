package org.sit.qe.util;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class CollectionUtilsTest {
    static final int MAX_ARRAY_SIZE = 10;
    static final int SMALL_MAX_ARRAY_SIZE = 5;
    static final int NR_RAND_TESTS = 10000;
    static final int MAX_VALUE = 10;
    static final long FIXED_SEED = 123;
    static Random random = null;
    ICollectionUtils cu = null;

    private boolean contains(int[] set, int elem){
        for(int i : set){
            if(i == elem)
                return true;
        }
        return false;
    }

    @BeforeAll
    static void setup(){
        random = new Random(FIXED_SEED); // use fixed seed to ensure reproducibility
    }
    @BeforeEach
    public void createNumberChecker(){
        cu = CollectionUtilsFactory.create();
    }

    public static List<int[]> generateRandomIntegers(int arraySize){
        List<int[]> listOfArrays = new ArrayList<>();

        for(int i = 0; i < NR_RAND_TESTS; i++) {
            int len = random.nextInt(arraySize + 1);
            int[] randomArray = new int[len];
            for (int j = 0; j < len; j++) {
                // generate values between 1 and MAX_VALUE
                randomArray[j] = 1 + random.nextInt(MAX_VALUE);
            }
            listOfArrays.add(randomArray);
        }
        return listOfArrays;
    }

    @Test
    void powerSetTest(){
        // test with lots of non-null inputs
        List<int[]> testInputs = generateRandomIntegers(SMALL_MAX_ARRAY_SIZE);
        for(int[] input : testInputs){
            int[] set = cu.toSet(input);
            int[][] powerSet = cu.powerSet(set);
            powerSetOracle(set,powerSet);
        }
    }

    private void powerSetOracle(int[] set, int[][] powerSet) {
        // TODO: add assertions to create your oracle here

        // if the set is empty
            if(set.length == 0) {
            // assert that the power set contains only one element which is an empty set
                assertEquals(powerSet.length,1);
            }else {
                // else assert that the power sets length is the 2 raised to the power
                // of the length of the set's length
                assertEquals(powerSet.length, (int)Math.pow(2,set.length));
            }
        // loop through the powerSet
        for(int i = 0; i < powerSet.length; i++) {
            // loop through the arrays in the powerset
            for(int j = 0; j < powerSet[i].length; j++) {
                // check that the set contains the value of the arrays in the powerset
                assertTrue(contains(set, powerSet[i][j]));
            }
            assertTrue(powerSet[i].length <= set.length);
            // check that each array in the powerset is a set i.e contains no duplicate values
            // we use the toSetOracle here
            toSetOracle(set, powerSet[i]);
            for(int k = 1; k < powerSet.length; k++) {
                // finally check that no two subsets are equal
                assertFalse(Arrays.equals(powerSet[i], powerSet[k]));
            }
        }
    }

    @Test
    void toSetTest(){
        // test with lots of non-null inputs
        List<int[]> testInputs = generateRandomIntegers(MAX_ARRAY_SIZE);
        for(int[] input : testInputs){
            int[] set = cu.toSet(input);
            toSetOracle(input, set);
        }
    }

    private void toSetOracle(int[] input, int[] set) {
        // TODO: add assertions to create your oracle here

        // This loops through each element in input
        for(int i = 0; i < input.length; i++) {
        // Variable to hold the number of times input[i] is found in the set
            int count = 0;
        // Loop through the set
            for(int j = 0; j < set.length; j++) {
                // if input[i] is found in the set
                if(input[i] == set[j]) {
                    // increment count by 1
                    count++;
                }
            }
        // this assertion checks two things,
            // it checks that input[i] exists in the set and
            // input[i] is only found once in the set
            assertTrue(count == 1);
        }
    }

    @Test
    void diffTests(){
        List<int[]> testSets1 = generateRandomIntegers(MAX_ARRAY_SIZE);
        List<int[]> testSets2 = generateRandomIntegers(MAX_ARRAY_SIZE);
        for(int i = 0; i < NR_RAND_TESTS; i++){
            // make sure that arrays are sets
            // Generally, it may not be ideal to use a method under test for
            // scaffolding. We do this for this assignment, as there is no
            // other way to remove duplicates...
            int[] set1 = cu.toSet(testSets1.get(i));
            int[] set2 = cu.toSet(testSets2.get(i));
            int[] setDifference = cu.diff(set1, set2);
            diffOracle(set1,set2, setDifference);
        }
    }


    private void diffOracle(int[] set1, int[] set2, int[] setDifference) {
        // TODO: add assertions to create your oracle here

        // loop through the set difference array
        for(int i = 0; i < setDifference.length; i++) {
            // assert that elements in the set difference is contained in the first set
            assertTrue(contains(set1, setDifference[i]));
            // assert that elements in set difference is absent in second set
            assertFalse(contains(set2, setDifference[i]));
        }
        assertTrue (set1.length == setDifference.length);
    }

    @Test
    void minArrayIndexTest(){
        List<int[]> testInputs = generateRandomIntegers(MAX_ARRAY_SIZE);
        for(int[] input : testInputs){
            int minIndex = cu.minArrayIndex(input);
            minArrayIndexOracle(input, minIndex);
        }
    }

    private void minArrayIndexOracle(int[] input, int minIndex) {
        // TODO: add assertions to create your oracle here

        for (int i=0; i<input.length; i++){
            // check that value found i the minimum index variable is equal or less than
            // other elements in the array
            assertTrue(input[minIndex]<=input[i]);
        }
    }
}
