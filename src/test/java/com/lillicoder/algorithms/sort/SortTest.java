/*
 * Copyright 2014 Scott Weeden-Moody
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this project except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lillicoder.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the algorithms implemented in {@link Sort}.
 */
public class SortTest {

    /**
     * Checks if all sort algorithms correctly handle an input
     * of a list with a no element.
     */
    @Test
    public void allSortsHandleEmptyList() {
        List<Integer> empty = new ArrayList<>();

        // The list should indicate as sorted and each method call
        // should not throw any exceptions
        Assert.assertTrue(Sort.isSorted(empty, Sort.Order.ASCENDING));
        Sort.bubbleSort(empty, Sort.Order.ASCENDING);
        Sort.insertionSort(empty, Sort.Order.ASCENDING);
        Sort.mergeSort(empty, Sort.Order.ASCENDING);
        Sort.quicksort(empty, Sort.Order.ASCENDING);
    }

    /**
     * Checks if all sort algorithms correctly handle an input
     * of a list with a single element.
     */
    @Test
    public void allSortsHandleSingleElementList() {
        List<Integer> solo = new ArrayList<>();
        solo.add(1);

        // The list should indicate as sorted and each method call
        // should not throw any exceptions
        Assert.assertTrue(Sort.isSorted(solo, Sort.Order.ASCENDING));
        Sort.bubbleSort(solo, Sort.Order.ASCENDING);
        Sort.insertionSort(solo, Sort.Order.ASCENDING);
        Sort.mergeSort(solo, Sort.Order.ASCENDING);
        Sort.quicksort(solo, Sort.Order.ASCENDING);
    }

    /**
     * Checks if bubble sort correctly sorts a list in ascending order.
     */
    @Test
    public void bubbleSortSortsAscending() {
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

        Sort.bubbleSort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if bubble sort correctly sorts a list in descending order.
     */
    @Test
    public void bubbleSortSortsDescending() {
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

        Sort.bubbleSort(elements, Sort.Order.DESCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

    /**
     * Checks if insertion sort correctly sorts a list in ascending order.
     */
    @Test
    public void insertionSortSortsAscending() {
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

        Sort.insertionSort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if insertion sort correctly sorts a list in descending order.
     */
    @Test
    public void insertionSortSortsDescending() {
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

        Sort.insertionSort(elements, Sort.Order.DESCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

    /**
     * Checks if merge sort correctly sorts a list in ascending order.
     */
    @Test
    public void mergeSortSortsAscending() {
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

        elements = Sort.mergeSort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if merge sort correctly sorts a list in descending order.
     */
    @Test
    public void mergeSortSortsDescending() {
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

        elements = Sort.mergeSort(elements, Sort.Order.DESCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

    /**
     * Checks if quicksort correctly sorts a list in ascending order.
     */
    @Test
    public void quicksortSortsAscending() {
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

        Sort.quicksort(elements, Sort.Order.ASCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if quicksort correctly sorts a list in descending order.
     */
    @Test
    public void quicksortSortsDescending() {
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

        Sort.quicksort(elements, Sort.Order.DESCENDING);
        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

    /**
     * Checks if a sorted list is indicated as sorted in ascending order by {@link Sort#isSorted(List, Sort.Order)}.
     */
    @Test
    public void isSortOnAscendingSortedList() {
        List<Integer> elements = new ArrayList<>();
        elements.add(-2);
        elements.add(-1);
        elements.add(0);
        elements.add(1);
        elements.add(5);
        elements.add(17);
        elements.add(22);
        elements.add(45);
        elements.add(79);
        elements.add(100);

        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.ASCENDING));
    }

    /**
     * Checks if a sorted list is indicated as sorted in descending order by {@link Sort#isSorted(List, Sort.Order)}.
     */
    @Test
    public void isSortOnDescendingSortedList() {
        List<Integer> elements = new ArrayList<>();
        elements.add(100);
        elements.add(79);
        elements.add(45);
        elements.add(22);
        elements.add(17);
        elements.add(5);
        elements.add(1);
        elements.add(0);
        elements.add(-1);
        elements.add(-2);

        Assert.assertTrue(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

    /**
     * Checks if an unsorted list is indicated as unsorted by {@link Sort#isSorted(List, Sort.Order)});
     */
    @Test
    public void isSortOnUnsortedList() {
        List<Integer> elements = new ArrayList<>();
        elements.add(-2);
        elements.add(1);
        elements.add(0);
        elements.add(45);
        elements.add(17);
        elements.add(5);
        elements.add(100);
        elements.add(22);
        elements.add(-1);
        elements.add(79);

        Assert.assertFalse(Sort.isSorted(elements, Sort.Order.ASCENDING));
        Assert.assertFalse(Sort.isSorted(elements, Sort.Order.DESCENDING));
    }

}
