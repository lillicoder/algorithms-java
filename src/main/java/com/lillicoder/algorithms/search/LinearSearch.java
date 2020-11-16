package com.lillicoder.algorithms.search;

import java.util.List;

/**
 * Implementation of a linear search on a given list. If the list contains multiple elements
 * that match the given element to find, the first encountered will have its position returned.
 *
 * <h4>Complexity</h4>
 * <ul>
 *     <li>Best case time: O(1)</li>
 *     <li>Average case time: O(n)</li>
 *     <li>Worst case time: O(n)</li>
 *     <li>Worst case space: O(1)</li>
 * </ul>
 */
class LinearSearch implements Search {

    @Override
    public <T> int search(List<? extends Comparable<? super T>> list, T toFind) {
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
