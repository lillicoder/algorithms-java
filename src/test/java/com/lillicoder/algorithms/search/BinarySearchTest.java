package com.lillicoder.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTest {

    /**
     * Tests if a binary search correctly finds an element in a sorted list.
     */
    @Test
    public void binarySearchFindsElement() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);

        int position = new BinarySearch().search(elements, 3);

        int expectedPosition = 2;
        Assert.assertEquals(position, expectedPosition);
    }

    /**
     * Tests if a binary search correctly handles an element that is not in the list.
     */
    @Test
    public void binarySearchDoesNotFindElement() {
        List<Integer> elements = new ArrayList<>();
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);

        BinarySearch binarySearch = new BinarySearch();
        int position = binarySearch.search(elements, 10);
        Assert.assertTrue(position < 0);

        // Search should never find an element in an empty list
        position = binarySearch.search(new ArrayList<Integer>(), 1);
        Assert.assertTrue(position < 0);
    }

}
