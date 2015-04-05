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

import java.util.List;

/**
 * Collection of search algorithms.
 * <p/>
 * All algorithms presented here will throw {@link NullPointerException} when given lists with {@code null} elements
 * or a {@code null} element to find. This is for simplicity. This could be handled by providing methods
 * that take comparators so you can custom define null handling if you so desired.
 */
public class Search {

    private Search() {}

    /**
     * Performs a binary search on the given list to find the given element. The given list must be sorted, otherwise
     * results are undefined. If there are multiple elements that match the given element to find, there is
     * no guarantee as to which of those elements will be found.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(1)</li>
     *     <li>Average case time: O(log(n))</li>
     *     <li>Worst case time: O(log(n))</li>
     *     <li>Worst case space: O(1)</li>
     * </ul>
     * @param list List to search.
     * @param toFind Elements to find.
     * @param <T> Type of elements being searched.
     * @return Position of the found element in the list or a negative integer if there is no match.
     */
    public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T toFind) {
        int position = -1;

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            /**
             * Normally a basic midpoint calculation is (low + high) / 2. However, very large ints will
             * overflow past the maximum integer value and break. To avoid this, we do a unsigned right shift
             * by 1 bit to safely handle very large ints.
             *
             * Alternatively you can do: low + ((high - low) / 2).
             * See http://googleresearch.blogspot.com/2006/06/extra-extra-read-all-about-it-nearly.html
             */
            int middle = (low + high) >>> 1;
            Comparable<? super T> middleElement = list.get(middle);

            int comparison = middleElement.compareTo(toFind);
            if (comparison == 0) {
                // Match found, assign position and stop iteration
                position = middle;
                break;
            } else if (comparison < 0) {
                // Element to find is bigger than middle position,
                // check upper half of list
                low += middle + 1;
            } else if (comparison > 0) {
                // Element to find is smaller than middle position,
                // check lower half of list
                high = middle - 1;
            }
        }

        return position;
    }

    /**
     * Performs a linear search on the given list to find the given element. If the list contains multiple elements
     * that match the given element to find, the first encountered will have its position returned.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(1)</li>
     *     <li>Average case time: O(n)</li>
     *     <li>Worst case time: O(n)</li>
     *     <li>Worst case space: O(1)</li>
     * </ul>
     * @param list List to search.
     * @param toFind Element to find.
     * @param <T> Type of elements being searched.
     * @return Position of the found element in the list or a negative integer if there is no match.
     */
    public static <T> int linearSearch(List<? extends Comparable<? super T>> list, T toFind) {
        int position = -1;

        for (int index = 0; index < list.size(); index++) {
            Comparable<? super T> element = list.get(index);

            int comparison = element.compareTo(toFind);
            if (comparison == 0) {
                // Match found, assign value and stop iteration
                position = index;
                break;
            }
        }

        return position;
    }

}
