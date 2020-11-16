package com.lillicoder.algorithms.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Performs a merge sort on a given list for a given {@link Sort.Order}.
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
 */
public class MergeSort extends Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort.Order order) {
        List<T> sortedList = list;
        if (list.size() > 1) {
            int middle = (list.size()) >>> 1;
            List<T> left = sort(list.subList(0, middle), order);
            List<T> right = sort(list.subList(middle, list.size()), order);
            sortedList = new Merger().merge(left, right, order);
        }

        return sortedList;
    }

}
