package com.lillicoder.algorithms.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Performs an insertion sort on a given list for a given {@link Sort.Order}.
 *
 * <h4>Complexity</h4>
 * <ul>
 *     <li>Best case time: O(n)</li>
 *     <li>Average case time: O(n^2)</li>
 *     <li>Worst case time: O(n^2)</li>
 *     <li>Worst case space: O(1)</li>
 * </ul>
 */
public class InsertionSort extends Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort.Order order) {
        if (list.size() > 1) {
            Comparator<T> comparator =
                    order == Sort.Order.ASCENDING ? new Sort.AscendingComparator<>() : new Sort.DescendingComparator<>();
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

        return list;
    }

}
