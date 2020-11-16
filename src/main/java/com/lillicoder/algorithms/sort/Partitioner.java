package com.lillicoder.algorithms.sort;

import java.util.Comparator;
import java.util.List;

public class Partitioner {

    /**
     * Partitions a given list and returns the index of the pivot element..
     * @param list List to partition.
     * @param order Order for the sort.
     * @param <T> Type of element to sort. The type must support the {@link Comparable} interface.
     * @return Position in the list of the pivot element after partitioning.
     */
    <T extends Comparable<? super T>> int partition(List<T> list, Sort.Order order) {
        int right = list.size() - 1;
        int pivotIndex = right >>> 1;
        T pivotElement = list.get(pivotIndex);

        // Move pivot to end of list
        list.set(pivotIndex, list.get(right));
        list.set(right, pivotElement);

        Comparator<T> comparator = order ==
                Sort.Order.ASCENDING ? new Sort.AscendingComparator<>() : new Sort.DescendingComparator<>();
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
