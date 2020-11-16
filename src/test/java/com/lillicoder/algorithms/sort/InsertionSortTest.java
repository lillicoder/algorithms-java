package com.lillicoder.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortTest {

    /**
     * Checks if insertion sort correctly sorts a list with no elements.
     */
    @Test
    public void sortsEmpty() {
        List<Integer> elements = new ArrayList<>();

        InsertionSort insertionSort = new InsertionSort();
        elements = insertionSort.sort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(insertionSort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if insertion sort correctly sorts a list in ascending order.
     */
    @Test
    public void sortsAscending() {
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(3);
        elements.add(12);
        elements.add(1);
        elements.add(0);
        elements.add(-1);
        elements.add(-10);
        elements.add(6);
        elements.add(7);
        elements.add(7);

        InsertionSort insertionSort = new InsertionSort();
        elements = insertionSort.sort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(insertionSort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if insertion sort correctly sorts a list in descending order.
     */
    @Test
    public void sortsDescending() {
        List<Integer> elements = new ArrayList<>();
        elements.add(5);
        elements.add(3);
        elements.add(12);
        elements.add(1);
        elements.add(0);
        elements.add(-1);
        elements.add(-10);
        elements.add(6);
        elements.add(7);
        elements.add(7);

        InsertionSort insertionSort = new InsertionSort();
        elements = insertionSort.sort(elements, Sort.Order.DESCENDING);
        Assert.assertTrue(insertionSort.isSorted(elements, Sort.Order.DESCENDING));
    }

}
