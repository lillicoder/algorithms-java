package com.lillicoder.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchTest {

    /**
     * Tests if a linear search correctly finds an element in a list.
     */
    @Test
    public void linearSearchFindsElement() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);

        int position = new LinearSearch().search(elements, 3);

        int expectedPosition = 2;
        Assert.assertEquals(position, expectedPosition);
    }

    /**
     * Tests if a linear search correctly handles an element that is not in the list.
     */
    @Test
    public void linearSearchDoesNotFindElement() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);

        LinearSearch linearSearch = new LinearSearch();
        int position = linearSearch.search(elements, 10);
        Assert.assertTrue(position < 0);

        // Search should never find an element in an empty list
        position = linearSearch.search(new ArrayList<Integer>(), 1);
        Assert.assertTrue(position < 0);
    }

}
