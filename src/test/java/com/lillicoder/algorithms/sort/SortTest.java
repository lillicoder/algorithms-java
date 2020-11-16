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
     * Checks if {@link Sort#isSorted(List, Sort.Order)} correctly handles an input of a list with
     * no elements.
     */
    @Test
    public void isSortedHandlesEmptyList() {
        List<Integer> empty = new ArrayList<>();

        // Empty lists have no sort, this test is purely for the convention in Sort
        Sort testSort = new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        };
        Assert.assertTrue(testSort.isSorted(empty, Sort.Order.ASCENDING));
        Assert.assertTrue(testSort.isSorted(empty, Sort.Order.DESCENDING));
    }

    /**
     * Checks if {@link Sort#isSorted(List, Sort.Order)} correctly handles an input
     * of a list with a single element.
     */
    @Test
    public void isSortedHandlesSingleElementList() {
        List<Integer> solo = new ArrayList<>();
        solo.add(1);

        // By definition single element lists are sorted, calls for any sort direction should be return true
        Sort testSort = new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        };
        Assert.assertTrue(testSort.isSorted(solo, Sort.Order.ASCENDING));
        Assert.assertTrue(testSort.isSorted(solo, Sort.Order.DESCENDING));
    }

    /**
     * Checks if a sorted list is indicated as sorted in ascending order by {@link Sort#isSorted(List, Sort.Order)}.
     */
    @Test
    public void isSortedOnAscendingSortedList() {
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

        Sort testSort = new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        };
        Assert.assertTrue(testSort.isSorted(elements, Sort.Order.ASCENDING));
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

        Sort testSort = new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        };
        Assert.assertTrue(testSort.isSorted(elements, Sort.Order.DESCENDING));
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

        Sort testSort = new Sort() {
            @Override
            public <T extends Comparable<? super T>> List<T> sort(List<T> list, Order order) {
                // This method is not under test here
                return null;
            }
        };
        Assert.assertFalse(testSort.isSorted(elements, Sort.Order.ASCENDING));
        Assert.assertFalse(testSort.isSorted(elements, Sort.Order.DESCENDING));
    }

}
