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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Base class for sort implementations.
 */
public abstract class Sort implements ISort {

    /**
     * Describes available sort orders.
     */
    public enum Order {

        /**
         * Specifies a sort in ascending (natural) order.
         */
        ASCENDING,

        /**
         * Specifies a sort in descending (reverse natural) order.
         */
        DESCENDING

    }

    /**
     * {@link Comparator} that sorts a type in ascending (natural) order.
     * @param <T> Type of element to compare. The type must implement the {@link Comparable} interface.
     */
    static class AscendingComparator<T extends Comparable<? super T>> implements Comparator<T>, Serializable {

        private static final long serialVersionUID = 2372423081923264517L;

        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }

    }

    /**
     * {@link Comparator} that sorts a type in descending (reverse natural) order.
     * @param <T> Type of element to compare. The type must implement the {@link Comparable} interface.
     */
    static class DescendingComparator<T extends Comparable<? super T>> implements Comparator<T>, Serializable {

        private static final long serialVersionUID = -5330600708522701140L;

        @Override
        public int compare(T o1, T o2) {
            return o2.compareTo(o1);
        }

    }

    /**
     * Determines if the given list is sorted in the given {@link Order}.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(n)</li>
     *     <li>Average case time: O(n)</li>
     *     <li>Worst case time: O(n)</li>
     *     <li>Worst case space: O(1)</li>
     * </ul>
     * @param list List to check.
     * @param order Order to check.
     * @param <T> Type of list elements. The type must support the {@link Comparable} interface.
     * @return {@code true} if the given list is sorted in the given order, {@code false} otherwise.
     */
    <T extends Comparable<? super T>> boolean isSorted(List<T> list, Order order) {
        Comparator<T> comparator =
            order == Order.ASCENDING ? new AscendingComparator<>() : new DescendingComparator<>();
        for (int index = 0; index < list.size(); index++) {
            if (index + 1 < list.size()) {
                // Not yet at the end of the list, compare elements
                T element = list.get(index);
                T next = list.get(index + 1);

                int comparison = comparator.compare(element, next);
                if (comparison > 0) {
                    // Comparator indicates elements are out of order
                    return false;
                }
            }
        }

        return true;
    }

}
