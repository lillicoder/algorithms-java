package com.lillicoder.algorithms.sort;

import java.util.Comparator;
import java.util.List;

/**
 * Performs a bubble sort on a given list for a given {@link Sort.Order}.
 *
 * <h4>Complexity</h4>
 * <ul>
 *     <li>Best case time: O(n)</li>
 *     <li>Average case time: O(n^2)</li>
 *     <li>Worst case time: O(n^2)</li>
 *     <li>Worst case space: O(1)</li>
 * </ul>
 */
public class BubbleSort extends Sort {

    @Override
    public <T extends Comparable<? super T>> List<T> sort(List<T> list, Sort.Order order) {
        boolean didSwap;
        do {
            Comparator<T> comparator =
                    order == Sort.Order.ASCENDING ? new Sort.AscendingComparator<>() : new Sort.DescendingComparator<>();
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

        return list;
    }

}
