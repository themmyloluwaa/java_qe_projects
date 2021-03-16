package org.sit.qe.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class CollectionUtilsTest {
    @Test
    void testForListAsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            CollectionUtils.sort(null);
        });
    }

    @Test
    void assertSorted() {
        List<Integer> list = Arrays.asList(4, 2, 5, 3,1);
        CollectionUtils.sort(list);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), list);
    }

    @Test
    void assertSortedTwo() {
        List<String> list = Arrays.asList("H", "H");
        CollectionUtils.sort(list);
        assertEquals(Arrays.asList("H", "H"), list);
    }

    @Test
    void assertSortedThree() {
        List<String> list = Arrays.asList("H", "Z");
        CollectionUtils.sort(list);
        assertEquals(Arrays.asList("H", "Z"), list);
    }

}
