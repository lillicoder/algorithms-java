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

package com.lillicoder.algorithms.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for the algorithms implemented in {@link Search}.
 */
public class SearchTest {

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

        int position = Search.binarySearch(elements, 3);

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

        int position = Search.binarySearch(elements, 10);
        Assert.assertTrue(position < 0);

        // Search should never find an element in an empty list
        position = Search.binarySearch(new ArrayList<Integer>(), 1);
        Assert.assertTrue(position < 0);
    }

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

        int position = Search.linearSearch(elements, 3);

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

        int position = Search.linearSearch(elements, 10);
        Assert.assertTrue(position < 0);

        // Search should never find an element in an empty list
        position = Search.linearSearch(new ArrayList<Integer>(), 1);
        Assert.assertTrue(position < 0);
    }

}
