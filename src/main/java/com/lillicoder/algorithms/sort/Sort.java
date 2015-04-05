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
 * Collection of sorting algorithms.
 * <p/>
 * All methods will throw a {@link NullPointerException} if given any null arguments or a given
 * list contains a null item.
 */
public class Sort {

    private Sort() {}

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
    private static class AscendingComparator<T extends Comparable<? super T>> implements Comparator<T>, Serializable {

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
    private static class DescendingComparator<T extends Comparable<? super T>> implements Comparator<T>, Serializable {

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
    public static <T extends Comparable<? super T>> boolean isSorted(List<T> list, Order order) {
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

    /**
     * Performs a bubble sort on the given list for the given {@link Order}.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(n)</li>
     *     <li>Average case time: O(n^2)</li>
     *     <li>Worst case time: O(n^2)</li>
     *     <li>Worst case space: O(1)</li>
     * </ul>
     * @param list List to sort.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     */
    public static <T extends Comparable<? super T>> void bubbleSort(List<T> list, Order order) {
        boolean didSwap;
        do {
            Comparator<T> comparator =
                order == Order.ASCENDING ? new AscendingComparator<>() : new DescendingComparator<>();
            didSwap = false;
            for (int index = 0; index < list.size(); index++) {
                // Only try while there a next index to look at in addition to the current index
                int nextIndex = index + 1;
                if (nextIndex <= list.size() - 1) {
                    T element = list.get(index);
                    T next = list.get(index + 1);

                    int comparison = comparator.compare(element, next);
                    if (comparison > 0) {
                        // Element is bigger than next, swap
                        list.set(index, next);
                        list.set(nextIndex, element);

                        didSwap = true;
                    }
                }
            }
        } while (didSwap);
    }

    /**
     * Performs an insertion sort on the given list for the given {@link Order}.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(n)</li>
     *     <li>Average case time: O(n^2)</li>
     *     <li>Worst case time: O(n^2)</li>
     *     <li>Worst case space: O(1)</li>
     * </ul>
     * @param list List to sort.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     */
    public static <T extends Comparable<? super T>> void insertionSort(List<T> list, Order order) {
        if (list.size() > 1) {
            Comparator<T> comparator =
                order == Order.ASCENDING ? new AscendingComparator<>() : new DescendingComparator<>();
            for (int index = 1; index < list.size(); index++) {
                int reverseIndex = index;
                while (reverseIndex > 0) {
                    // Walk backwards over each pair of elements up to this index
                    // and swap elements if necessary
                    T element = list.get(reverseIndex);
                    T prior = list.get(reverseIndex - 1);

                    int comparison = comparator.compare(element, prior);
                    if (comparison < 1) {
                        list.set(reverseIndex, prior);
                        list.set(reverseIndex - 1, element);
                    }

                    reverseIndex--;
                }
            }
        }
    }

    /**
     * Performs a merge sort on the given list for the given {@link Order}.
     * <p/>
     * Note that this sort is not an in place sort, so a list of sorted results is returned that
     * is not the same as the given list to sort.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(n log(n))</li>
     *     <li>Average case time: O(n log(n))</li>
     *     <li>Worst case time: O(n log(n))</li>
     *     <li>Worst case space: O(n)</li>
     * </ul>
     * @param list List to sort.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     * @return Sorted list.
     */
    public static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list, Order order) {
        List<T> sortedList = list;
        if (list.size() > 1) {
            int middle = (list.size()) >>> 1;
            List<T> left = mergeSort(list.subList(0, middle), order);
            List<T> right = mergeSort(list.subList(middle, list.size()), order);
            sortedList = merge(left, right, order);
        }

        return sortedList;
    }

    /**
     * Performs a quicksort on the given list for the given {@link Order}.
     *
     * <h4>Complexity</h4>
     * <ul>
     *     <li>Best case time: O(n log(n))</li>
     *     <li>Average case time: O(n log(n))</li>
     *     <li>Worst case time: O(n^2)</li>
     *     <li>Worst case space: O(n)</li>
     * </ul>
     * @param list List to sort.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     */
    public static <T extends Comparable<? super T>> void quicksort(List<T> list, Order order) {
        if (list.size() > 1) {
            int partition = partition(list, order);
            quicksort(list.subList(0, partition), order);
            quicksort(list.subList(partition + 1, list.size()), order);
        }
    }

    /**
     * Merges the elements of the given lists into a single list with the given {@link Order}. Each given
     * list is assumed to already be sorted in the given order.
     * @param left List to merge.
     * @param right List to merge.
     * @param <T> Type of elements to merge. The type must support the {@link Comparable} interface.
     * @return Sorted list.
     */
    private static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right, Order order) {
        List<T> merged = new ArrayList<>(left.size() + right.size());

        Comparator<T> comparator =
            order == Order.ASCENDING ? new AscendingComparator<>() : new DescendingComparator<>();

        // To do this, simply walk over the total number of elements in both lists and advance
        // a index tracking value for each list so that we add elements in the right comparison order
        int leftPosition = 0;
        int rightPosition = 0;
        for (int index = 0; index < left.size() + right.size(); index++) {
            if (leftPosition < left.size() && rightPosition < right.size()) {
                // Both positions in bounds, do comparison
                T leftElement = left.get(leftPosition);
                T rightElement = right.get(rightPosition);

                int comparison = comparator.compare(leftElement, rightElement);
                if (comparison < 1) {
                    // Left precedes or is equal to right, take left
                    merged.add(leftElement);
                    leftPosition++;
                } else {
                    // Right precedes left, take right
                    merged.add(rightElement);
                    rightPosition++;
                }
            } else if (leftPosition < left.size()) {
                // Left in bounds and right is not, take left
                merged.add(left.get(leftPosition));
                leftPosition++;
            } else if (rightPosition < right.size()) {
                // Right in bounds and left is not, take right
                merged.add(right.get(rightPosition));
                rightPosition++;
            } else {
                System.out.println("Something is going wrong, nobody is in bounds!");
            }
        }

        return merged;
    }

    /**
     * Partitions the given list and returns the index of the pivot element.
     * <p/>
     * This pivot method is intended for use with the quicksort algorithm.
     * @param list List to partition.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     * @return Position in the list of the pivot element after partitioning.
     */
    private static <T extends Comparable<? super T>> int partition(List<T> list, Order order) {
        int right = list.size() - 1;
        int pivotIndex = right >>> 1;
        T pivotElement = list.get(pivotIndex);

        // Move pivot to end of list
        list.set(pivotIndex, list.get(right));
        list.set(right, pivotElement);

        Comparator<T> comparator = order ==
                                   Order.ASCENDING ? new AscendingComparator<>() : new DescendingComparator<>();
        int storeIndex = 0;
        for (int left = 0; left < right; left++) {
            T element = list.get(left);
            int comparison = comparator.compare(element, pivotElement);
            if (comparison < 1) {
                // Element comes before pivot, perform swap
                list.set(left, list.get(storeIndex));
                list.set(storeIndex, element);

                storeIndex++;
            }
        }

        // Move pivot to final position
        list.set(right, list.get(storeIndex));
        list.set(storeIndex, pivotElement);

        return storeIndex;
    }

}
