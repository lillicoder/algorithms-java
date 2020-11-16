package com.lillicoder.algorithms.sort;

import java.util.List;

/**
 * Performs a quicksort on a given list for a given {@link Sort.Order}.
 *
 * <h4>Complexity</h4>
 * <ul>
 *     <li>Best case time: O(n log(n))</li>
 *     <li>Average case time: O(n log(n))</li>
 *     <li>Worst case time: O(n^2)</li>
 *     <li>Worst case space: O(n)</li>
 * </ul>
 */
public class Quicksort extends Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort.Order order) {
        if (list.size() > 1) {
            int partition = new Partitioner().partition(list, order);
            sort(list.subList(0, partition), order);
            sort(list.subList(partition + 1, list.size()), order);
        }

        return list;
    }

}
